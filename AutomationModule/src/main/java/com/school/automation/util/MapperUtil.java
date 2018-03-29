package com.school.automation.util;

import com.school.automation.common.DataPath;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jhonny
 */
public class MapperUtil<T> {
    private ObjectMapper objectMapper;
    private final static Logger logger = LoggerFactory.getLogger(MapperUtil.class);

    public MapperUtil() {
        objectMapper = new ObjectMapper();
    }

    public <T> List<T> getJsonListFunctionality(Class<T> typeClass, String jsonPath){
        return getJsonList(typeClass, DataPath.FUNCTIONALITY_PATH, jsonPath);
    }

    public <T> List<T> getJsonList(Class<T> typeClass, String dataPath, String jsonPath){
        List<T> list = null;

        try {
            list = objectMapper.readValue(new File(getClass().getResource(dataPath + jsonPath).getPath()),
                    TypeFactory.defaultInstance().constructCollectionType(List.class,
                            typeClass));
        } catch (IOException ex) {
            logger.error("[MapperUtil][getJsonList] Error Json List: " + ex);
        }

        logger.info("[MapperUtil][getJsonList] Json List: " + list);
        return list;
    }
}