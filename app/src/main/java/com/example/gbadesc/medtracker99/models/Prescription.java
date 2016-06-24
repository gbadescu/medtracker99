package com.example.gbadesc.medtracker99.models;

import java.util.Date;

/**
 * Created by gbadesc on 6/24/16.
 */
public class Prescription {

    private Medication medication;

    private Date fillDate;
    private Date expirationDate;

    private int noOfRefills;

    private Pharmacy pharmacy;

    private Double inventory;
}
