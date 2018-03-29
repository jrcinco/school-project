package com.school.automation.util;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jhonny
 */
public class RequestUtil {
    /**     
     * @param path
     * @return
     */
    public static Response getRequest(String path) {
        return getRequest(path, new HashMap<String, Object>());
    }

    /**
     *
     * @param path
     * @param pathParams
     * @return
     */
    public static Response getRequest(String path, final Map<String, Object> pathParams) {
        WebTarget target = RestClienUtil.getTargetClient(path);
        target = target.resolveTemplates(pathParams);
        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);

        return request.get();
    }

    /**
     *
     * @param <T>
     * @param path
     * @param payload
     * @return
     */
    public static <T> Response postRequest(String path, T payload) {
        WebTarget target = RestClienUtil.getTargetClient(path);
        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);

        return request.post(Entity.json(payload));
    }    

    /**
     *
     * @param <T>
     * @param path
     * @param pathParams
     * @param payload
     * @return
     */
    public static <T> Response putRequest(String path, final Map<String, Object> pathParams, T payload) {
        WebTarget target = RestClienUtil.getTargetClient(path);
        target = target.resolveTemplates(pathParams);
        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);

        return request.put(Entity.json(payload));
    }

    /**
     *
     * @param <T>
     * @param path
     * @param pathParams
     * @return
     */
    public static <T> Response deleteRequest(String path, final Map<String, Object> pathParams) {
        WebTarget target = RestClienUtil.getTargetClient(path);
        target = target.resolveTemplates(pathParams);
        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);

        return request.delete();
    }
}