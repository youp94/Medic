package com.medic.Models;

import java.io.Serializable;

public class Equipment implements Serializable {

    private String name;
    private String params;

    public Equipment(String name, String params) {
        this.name = name;
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
}
