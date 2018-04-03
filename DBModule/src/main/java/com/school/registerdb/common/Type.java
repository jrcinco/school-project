package com.school.registerdb.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Type {
    ELEMENTARY,
    KINDER,
    HIGH;
    
    private final static Logger logger = LoggerFactory.getLogger(Type.class);

    public static boolean isValid(String type) {
        Type value = null;
        try {
            value = Type.valueOf(type);
        } catch (IllegalArgumentException exception) {
            logger.info("[Type.isValid] printStackTrace: ");		
		    exception.printStackTrace();
            return false;
        }     
        switch (value) {
            case ELEMENTARY:
                return true;
            case KINDER:
                return true;
            case HIGH:
                return true;
            default:
                return false;
        }
    }
}
