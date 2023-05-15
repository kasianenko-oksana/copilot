package com.epam.utils;

import com.epam.utils.exception.FileException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtils {

    private final ObjectMapper objectMapper;

    public JsonUtils(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Read object from json file
     *
     * @param path  path to json file
     * @param clazz class of object
     * @param <T>   type of object
     * @return object
     */
    public <T> List<T> readListFromJsonFile(String path, Class<T> clazz) {
        try {
            return objectMapper.readValue(new File(path), objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            throw new FileException(e.getMessage());
        }
    }

    /**
     * Read string from json file
     *
     * @param path path to json file
     * @return string
     */
    public String readStringFromJsonFile(String path) {
        try {
            return objectMapper.readValue(new File(path), String.class);
        } catch (IOException e) {
            throw new FileException(e.getMessage());
        }
    }

    /**
     * Write list into json file
     *
     * @param path path to json file
     * @param list to write
     */
    public void writeListToJsonFile(String path, List<?> list) {
        try {
            objectMapper.writeValue(new File(path), list);
        } catch (IOException e) {
            throw new FileException(e.getMessage());
        }
    }

    /**
     * Write object into json file
     *
     * @param path   path to json file
     * @param object object to write
     */
    public void writeObjectToJsonFile(String path, Object object) {
        try {
            objectMapper.writeValue(new File(path), object);
        } catch (IOException e) {
            throw new FileException(e.getMessage());
        }
    }

    /**
     * Write object into json string
     *
     * @param objects object to write
     * @return json string
     */
    public String listObjectsToJsonString(List<Object> objects) {
        try {
            return objectMapper.writeValueAsString(objects);
        } catch (IOException e) {
            throw new FileException(e.getMessage());
        }
    }

    public String objectToJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new FileException(e.getMessage());
        }
    }
}
