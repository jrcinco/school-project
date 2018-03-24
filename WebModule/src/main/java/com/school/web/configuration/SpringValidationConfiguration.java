package com.school.web.configuration;

import com.school.web.validation.validator.*;
import com.school.web.validation.ValidatorRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author jhonny
 */
@Configuration
@ComponentScan(basePackages = "com.school.web.validation")
public class SpringValidationConfiguration {
    @Bean
    public ValidatorRegistry validatorRegistry() {
        ValidatorRegistry registry = new ValidatorRegistry();        
        registry.addValidator(new StudentDetailValidator());
        return registry;
    }

    @Bean
    public Validator annotationValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }
}
