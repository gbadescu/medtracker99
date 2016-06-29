package com.example.gbadesc.medtracker99.models;

/**
 * Created by gbadesc on 6/24/16.
 */
public class Medication {
    private String name;
    private float dosage;
    private String units;
    private int color;

    public int getColor() {
        return color;
    }

    public Medication(String name, float dosage, String units, int color) {
        this.name = name;
        this.dosage = dosage;
        this.units = units;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDosage() {
        return dosage;
    }

    public void setDosage(Float dosage) {
        this.dosage = dosage;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
