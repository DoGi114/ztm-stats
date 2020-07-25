package sda.advanced.inbound;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import sda.advanced.model.ZtmData;

import java.io.IOException;
import java.net.URL;

public class DataMapper {
    public static ZtmData map(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        try {
            return objectMapper.readValue(json, ZtmData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ZtmData map(URL url){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        try {
            ZtmData ztmData = objectMapper.readValue(url, ZtmData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
