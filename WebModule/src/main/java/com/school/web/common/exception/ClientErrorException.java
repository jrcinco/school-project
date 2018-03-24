package com.school.web.common.exception;

import com.school.web.validation.ValidationDetail;
import com.school.web.util.PropertiesUtil;

import java.util.List;

/**
 * @author jhonny
 * code status 400
 */
public class ClientErrorException extends RuntimeException {
    private String code;
    private List<ValidationDetail> messages;

    public ClientErrorException(String code) {
        super(PropertiesUtil.getProperties().getProperty(code));
        System.out.println("Properties Util: "+PropertiesUtil.getProperties());
        System.out.println("Properties Util CODE: "+PropertiesUtil.getProperties().getProperty(code));        
        this.code = code;
    }

    public ClientErrorException(String code, String msg) {
        super(PropertiesUtil.getProperties().getProperty(code));
        this.code = code;
    }

    public ClientErrorException(String msg, Throwable rootException) {
        super(msg);
        rootException.printStackTrace();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ValidationDetail> getMessages() {
        return messages;
    }

    public void setMessages(List<ValidationDetail> messages) {
        this.messages = messages;
    }
}
