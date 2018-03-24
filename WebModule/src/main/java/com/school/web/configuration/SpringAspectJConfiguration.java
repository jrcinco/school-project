package com.school.web.configuration;

import com.school.web.validation.aspect.ValidationAspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.Bean;

/**
 * @author jhonny
 */
@Configuration
@ComponentScan(basePackages = "com.school.web")
@EnableAspectJAutoProxy
public class SpringAspectJConfiguration {
    @Bean	
    public ValidationAspect validationAspect(){
        return new ValidationAspect();
    }
}
