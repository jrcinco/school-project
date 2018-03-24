package com.school.web.validation;

import org.springframework.validation.Validator;

/**
 * @author jhonny
 */
public abstract class ApplicationAbstractValidator implements Validator {
    protected javax.validation.Validator annotationValidator;

    public void setAnnotationValidator(javax.validation.Validator annotationValidator) {
        this.annotationValidator = annotationValidator;
    }
}
