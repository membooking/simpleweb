package com.enet.io.lppage.webapp.util;

import com.enet.io.lppage.webapp.model.ComponentData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * User: lehungban
 * Date: 10/3/19
 * Time: 9:52 PM
 */
public class ObjectMapperUtil {

    private static ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }

    public static String toJsonString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
    public static ComponentData parseComponentData(String jdata) {
        try {
            return mapper.readValue(jdata,ComponentData.class);
        } catch (Exception e) {
            return null;
        }
    }
}
