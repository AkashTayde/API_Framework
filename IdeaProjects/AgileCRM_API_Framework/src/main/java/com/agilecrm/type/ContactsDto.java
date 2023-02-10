package com.agilecrm.type;

import java.util.List;
import java.util.Map;

public class ContactsDto {

    private String star_value;

    public void setStar_value(String star_value) {
        this.star_value = star_value;
    }

    public String getStar_value() {
        return star_value;
    }

    private String lead_score;

    public void setLead_score(String lead_score) {
        this.lead_score = lead_score;
    }

    public String getLead_score() {
        return lead_score;
    }


    private List<String> tags;

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }



    private List<Map<String, String>> properties;

    public void setProperties(List<Map<String, String>> properties) {
        this.properties = properties;
    }

    public List<Map<String, String>> getProperties() {
        return properties;
    }

}
