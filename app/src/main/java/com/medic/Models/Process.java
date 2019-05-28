package com.medic.Models;

import java.io.Serializable;

public class Process implements Serializable {

    private String name;
    private String description;
    private Formula formula;

    public Process() {
    }

    public Process(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Process(String name, String description, Formula formula) {
        this.name = name;
        this.description = description;
        this.formula = formula;
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

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }
}
