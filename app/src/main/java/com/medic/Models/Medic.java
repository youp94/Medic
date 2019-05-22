package com.medic.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Medic implements Serializable {

    private String name;
    private String description;
    private ArrayList<MedicForm> medicFormArrayList;

    public Medic(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Medic(String name, String description, ArrayList<MedicForm> medicFormArrayList) {
        this.name = name;
        this.description = description;
        this.medicFormArrayList = medicFormArrayList;
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

    public ArrayList<MedicForm> getMedicFormArrayList() {
        return medicFormArrayList;
    }

    public void setMedicFormArrayList(ArrayList<MedicForm> medicFormArrayList) {
        this.medicFormArrayList = medicFormArrayList;
    }
}
