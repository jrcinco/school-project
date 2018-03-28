package com.school.web.validation.aspect;

import com.school.registerdb.service.StudentManager;
import com.school.web.validation.ApplicationAbstractValidator;
import com.school.web.validation.ValidatorRegistry;
import com.school.web.validation.ValidationDetail;
import com.school.web.common.exception.ClientErrorException;
import com.school.web.util.PropertiesUtil;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jhonny
 */
@Aspect
public class ValidationAspect {    
    @Autowired
    private ValidatorRegistry registry;    
    @Autowired
    private Validator annotationValidator;
    @Autowired
    private Properties properties;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before(value = "execution(public * *(..)) && @annotation(com.school.web.validation.annotation.FieldValidation)")
    public void doBefore(JoinPoint point) {
        Annotation[][] paramAnnotations =
                ((MethodSignature) point.getSignature()).getMethod().getParameterAnnotations();

        for (int i = 0; i < paramAnnotations.length; i++) {
            for (Annotation annotation: paramAnnotations[i]) {
                //checking for standard org.springframework.validation.annotation.Validated
                if (annotation.annotationType() == Validated.class) {
                    Object arg = point.getArgs()[i];                    
                    if (arg == null) continue;
                    validate(arg);
                }
            }
        }
    }

    private void validate(Object arg) {
        int errorCount = 0;
        List<ValidationDetail> messages = new ArrayList<>();
        List<ApplicationAbstractValidator> validatorList = registry.getValidatorsForObject(arg);

        for (ApplicationAbstractValidator validator : validatorList) {
            validator.setAnnotationValidator(annotationValidator);
            BindingResult errors = new BeanPropertyBindingResult(arg, arg.getClass().getSimpleName());
            validator.validate(arg, errors);
            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    FieldError fieldError = (FieldError) error;
                    errorCount++;

                    // CHANGES NECESSARY FOR CUSTOM CODE-BASED VALIDATION
                    messages.add(new ValidationDetail(fieldError.getCode(), 
                                fieldError.getField(), 
                                PropertiesUtil.getPropertiesByPropertiesFile("/SchoolMessages.properties").getProperty(fieldError.getCode())));
                }
            }
        }

        if (errorCount > 0) {      
            logger.info("[ValidationAspect.validate] throw error: {}", messages);  
            throw new ClientErrorException("VA001", messages);
        } 
    }
}
