package com.nure.bearer.DTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Beast {
    private String id;
    private String nameAnimal;
    private int weight;
    private String herdId;

    public Beast() {
    }

    public Beast(String id, String nameAnimal, int weight, String herdId) {
        this.id = id;
        this.nameAnimal = nameAnimal;
        this.weight = weight;
        this.herdId = herdId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getHerdId() {
        return herdId;
    }

    public String getIdFromHerdId() {
        if (herdId == null) return null;
        Pattern pattern = Pattern.compile("\"_id\":\"(.+?)\"");
        Matcher matcher = pattern.matcher(herdId);
        if (!matcher.find()) {
            return null;
        }
        return matcher.group(0).replace("\"_id\":\"", "").replace("\"", "");
    }

    public void setHerdId(String herdId) {
        this.herdId = herdId;
    }
}
