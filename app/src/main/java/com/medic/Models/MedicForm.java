package com.medic.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class MedicForm implements Serializable {

    private String name;
    private String description;
    private ArrayList<Process> processArrayList;

    public MedicForm(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public MedicForm(String name, String description, ArrayList<Process> process) {
        this.name = name;
        this.description = description;
        this.processArrayList = process;
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

    public ArrayList<Process> getProcessArrayList() {
        return processArrayList;
    }

    public void setProcessArrayList(ArrayList<Process> processArrayList) {
        this.processArrayList = processArrayList;
    }
}
