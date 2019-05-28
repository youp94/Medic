package com.medic.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Formula implements Serializable {

    private String refBrevet;
    private String name;
    private String description;
    private ArrayList<Constituant> constituants;
    private ArrayList<Step> steps;

    private String characs;

    public Formula(String refBrevet, String name, String description, ArrayList<Constituant> constituants, ArrayList<Step> steps, String characs) {
        this.refBrevet = refBrevet;
        this.name = name;
        this.description = description;
        this.constituants = constituants;
        this.steps = steps;
        this.characs = characs;
    }

    public Formula(String refBrevet, String name, String description, ArrayList<Constituant> constituants, ArrayList<Step> steps) {
        this.refBrevet = refBrevet;
        this.name = name;
        this.description = description;
        this.constituants = constituants;
        this.steps = steps;
    }

    public Formula(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Formula(String name, String description, ArrayList<Constituant> constituants) {
        this.name = name;
        this.description = description;
        this.constituants = constituants;
    }

    public Formula(String refBrevet, String name, String description, ArrayList<Constituant> constituants) {
        this.refBrevet = refBrevet;
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

    public String getRefBrevet() {
        return refBrevet;
    }

    public void setRefBrevet(String refBrevet) {
        this.refBrevet = refBrevet;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    public String getCharacs() {
        return characs;
    }

    public void setCharacs(String characs) {
        this.characs = characs;
    }
}
