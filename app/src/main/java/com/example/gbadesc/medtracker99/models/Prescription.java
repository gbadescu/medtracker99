package com.example.gbadesc.medtracker99.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gbadesc on 6/24/16.
 */
public class Prescription {
    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Date getFillDate() {
        return fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getNoOfRefills() {
        return noOfRefills;
    }

    public void setNoOfRefills(int noOfRefills) {
        this.noOfRefills = noOfRefills;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Double getInventory() {
        return inventory;
    }

    public void setInventory(Double inventory) {
        this.inventory = inventory;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    private Medication medication;

    private Date fillDate;
    private Date expirationDate;

    private int noOfRefills;

    private Pharmacy pharmacy;

    private Double inventory;

    private Schedule schedule;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prescription(String name) {
        this.name = name;

    }

    public static List<Prescription> getDailyMedsForPeriod(DailySchedule dailySchedule, Date date) {

        switch (dailySchedule.getPeriod())
        {
            case 0:
                ArrayList<Prescription> l1 = new ArrayList<>();
                Medication med1 = new Medication("Aspirin",81,"mg");
                Prescription p1 = new Prescription("P1");
                p1.setMedication(med1);

                Medication med6 = new Medication("Bayer",81,"mg");
                Prescription p6 = new Prescription("P6");
                p6.setMedication(med6);

                l1.add(p1);
                l1.add(p6);

                return l1;
            case 1:
                ArrayList<Prescription> l2 = new ArrayList<>();
                Medication med2 = new Medication("Tylenol",81,"mg");
                Prescription p2 = new Prescription("P2");
                p2.setMedication(med2);
                l2.add(p2);
                return l2;
            case 2:
                ArrayList<Prescription> l3 = new ArrayList<>();
                Medication med3 = new Medication("Motrin",81,"mg");
                Prescription p3 = new Prescription("P3");
                p3.setMedication(med3);
                l3.add(p3);
                return l3;
            case 3:
                ArrayList<Prescription> l4 = new ArrayList<>();
                Medication med4 = new Medication("Advil",81,"mg");
                Prescription p4 = new Prescription("P4");
                p4.setMedication(med4);
                l4.add(p4);
                return l4;
            case 4:
                ArrayList<Prescription> l5 = new ArrayList<>();
                Medication med5 = new Medication("Aleve",81,"mg");
                Prescription p5 = new Prescription("P5");
                p5.setMedication(med5);
                l5.add(p5);
                return l5;
            default:
                return null;
        }


    }
}
