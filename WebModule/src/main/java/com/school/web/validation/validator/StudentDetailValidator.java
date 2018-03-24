package com.school.web.validation.validator;

import com.school.web.validation.ApplicationAbstractValidator;
import com.school.web.dto.StudentDetailDto;
import org.springframework.validation.Errors;

import javax.validation.ConstraintViolation;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jhonny
 */
public class StudentDetailValidator extends ApplicationAbstractValidator {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == StudentDetailDto.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDetailDto dto = (StudentDetailDto)target;
        Set<ConstraintViolation<StudentDetailDto>> constraintViolations = annotationValidator.validate(dto);

        for (ConstraintViolation<StudentDetailDto> constraintViolation : constraintViolations) {
            logger.info("[StudentDetailValidator].[validate] message: " 
                    + constraintViolation.getMessage() + " " 
                    + constraintViolation.getPropertyPath().toString());            
            errors.rejectValue(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
        }
    }
}
