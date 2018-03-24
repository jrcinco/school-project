package com.school.web.validation;

/**
 * @author jhonny
 */
public class ValidationDetail {
    private String resultCode;
    private String field;
    private String message;

    public ValidationDetail() {}

    public ValidationDetail(String resultCode, String field, String message) {
        this.resultCode = resultCode;
        this.field = field;
        this.message = message;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
