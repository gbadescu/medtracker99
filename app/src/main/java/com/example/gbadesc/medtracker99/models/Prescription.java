package com.example.gbadesc.medtracker99.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hirondelle.date4j.DateTime;

/**
 * Created by gbadesc on 6/24/16.
 */
public class Prescription implements Serializable{

    private static ArrayList<Prescription> prescriptionList;

    public static ArrayList<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public static void setPrescriptionList(ArrayList<Prescription> prescriptionList) {
        Prescription.prescriptionList = prescriptionList;
    }

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

    public static List<Prescription> getDailyMedsForPeriod(DailySchedule dailySchedule, DateTime date) {

        Prescription prescription;
        int size = Prescription.getPrescriptionList().size();

        switch (dailySchedule.getPeriod())
        {
            case 0:
                ArrayList<Prescription> l1 = new ArrayList<>();

                for (int i=0; i< size; i++)
                {
                    prescription = Prescription.getPrescriptionList().get(i);

                    if (prescription.getSchedule().isMorning()) {
                        l1.add(prescription);
                    }
                }

                return l1;
            case 1:
                ArrayList<Prescription> l2 = new ArrayList<>();

                for (int i=0; i< size; i++)
                {
                    prescription = Prescription.getPrescriptionList().get(i);

                    if (prescription.getSchedule().isNoon()) {
                        l2.add(prescription);
                    }
                }

                return l2;
            case 2:
                ArrayList<Prescription> l3 = new ArrayList<>();

                for (int i=0; i< size; i++)
                {
                    prescription = Prescription.getPrescriptionList().get(i);

                    if (prescription.getSchedule().isAfternoon()) {
                        l3.add(prescription);
                    }
                }
                return l3;
            case 3:
                ArrayList<Prescription> l4 = new ArrayList<>();

                for (int i=0; i< size; i++)
                {
                    prescription = Prescription.getPrescriptionList().get(i);

                    if (prescription.getSchedule().isEvening()) {
                        l4.add(prescription);
                    }
                }
                return l4;
            case 4:
                ArrayList<Prescription> l5 = new ArrayList<>();

                for (int i=0; i< size; i++)
                {
                    prescription = Prescription.getPrescriptionList().get(i);

                    if (prescription.getSchedule().isNight()) {
                        l5.add(prescription);
                    }
                }
                return l5;
            default:
                return null;
        }


    }
}
