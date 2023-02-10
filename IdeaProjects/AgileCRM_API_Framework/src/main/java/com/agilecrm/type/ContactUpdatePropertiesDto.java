package com.agilecrm.type;

import java.util.List;
import java.util.Map;

public class ContactUpdatePropertiesDto {

    private String Id;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }



    private List<Map<String, String>> properties;

    public void setProperties(List<Map<String, String>> properties) {
        this.properties = properties;
    }

    public List<Map<String, String>> getProperties() {
        return properties;
    }
}
