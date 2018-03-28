package com.school.web.common.exception;

import com.school.web.util.PropertiesUtil;

/**
 * @author jhonny
 * code status 400
 */
public class ApplicationException extends RuntimeException {
    private String code;

    public ApplicationException(String code) {
        super(PropertiesUtil.getProperties().getProperty(code));
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
