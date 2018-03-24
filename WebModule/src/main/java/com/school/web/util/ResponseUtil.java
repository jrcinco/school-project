package com.school.web.util;

import com.school.web.common.payload.OperationResult;
import com.school.web.common.payload.BasicResult;
import com.school.web.common.payload.EmptyResult;

/**
 * @author jhonny
 */
public class ResponseUtil {
    public static OperationResult ok() {
        return new EmptyResult();
    }

    public static OperationResult okById(Long id) {
        return new BasicResult(id);
    }    
}
    
