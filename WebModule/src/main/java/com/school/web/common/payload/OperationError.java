package com.school.web.common.payload;

import java.io.Serializable;

public abstract class OperationError implements Serializable {
    private String code;
    private String message;

    public OperationError(String code, String message) {
        this.code    = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    } 

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
