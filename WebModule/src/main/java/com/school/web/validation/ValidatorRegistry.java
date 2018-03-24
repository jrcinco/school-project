package com.school.web.validation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jhonny
 */
public class ValidatorRegistry {
    private List<ApplicationAbstractValidator> validatorList = new ArrayList<>();

    public void addValidator(ApplicationAbstractValidator validator){
        validatorList.add(validator);
    }

    public List<ApplicationAbstractValidator> getValidatorsForObject(Object o) {
        List<ApplicationAbstractValidator> result = new ArrayList<>();
        for(ApplicationAbstractValidator validator: validatorList){
            if(validator.supports(o.getClass())){
                result.add(validator);
            }
        }

        return result;
    }
}
