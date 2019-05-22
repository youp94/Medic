package com.medic.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Formula implements Serializable {

    private String name;
    private String description;
    private ArrayList<Constituant> constituants;

    public Formula(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Formula(String name, String description, ArrayList<Constituant> constituants) {
        this.name = name;
        this.description = description;
        this.constituants = constituants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Constituant> getConstituants() {
        return constituants;
    }

    public void setConstituants(ArrayList<Constituant> constituants) {
        this.constituants = constituants;
    }
}
