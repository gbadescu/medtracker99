package com.example.gbadesc.medtracker99.models;

/**
 * Created by gbadesc on 6/24/16.
 */
public class Schedule {

    private boolean monday;
    private boolean tuesday;
    private boolean wednesday;
    private boolean thursday;
    private boolean friday;
    private boolean saturday;
    private boolean sunday;

    public Schedule(boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday, boolean morning, boolean noon, boolean afternoon, boolean evening, boolean night) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        Morning = morning;
        Noon = noon;
        Afternoon = afternoon;
        Evening = evening;
        Night = night;
    }

    private boolean Morning;
    private boolean Noon;
    private boolean Afternoon;
    private boolean Evening;
    private boolean Night;

    public boolean isMonday() {
        return monday;
    }

    public void setMonday(boolean monday) {
        this.monday = monday;
    }

    public boolean isTuesday() {
        return tuesday;
    }

    public void setTuesday(boolean tuesday) {
        this.tuesday = tuesday;
    }

    public boolean isWednesday() {
        return wednesday;
    }

    public void setWednesday(boolean wednesday) {
        this.wednesday = wednesday;
    }

    public boolean isThursday() {
        return thursday;
    }

    public void setThursday(boolean thursday) {
        this.thursday = thursday;
    }

    public boolean isFriday() {
        return friday;
    }

    public void setFriday(boolean friday) {
        this.friday = friday;
    }

    public boolean isSaturday() {
        return saturday;
    }

    public void setSaturday(boolean saturday) {
        this.saturday = saturday;
    }

    public boolean isSunday() {
        return sunday;
    }

    public void setSunday(boolean sunday) {
        this.sunday = sunday;
    }

    public boolean isMorning() {
        return Morning;
    }

    public void setMorning(boolean morning) {
        Morning = morning;
    }

    public boolean isNoon() {
        return Noon;
    }

    public void setNoon(boolean noon) {
        Noon = noon;
    }

    public boolean isAfternoon() {
        return Afternoon;
    }

    public void setAfternoon(boolean afternoon) {
        Afternoon = afternoon;
    }

    public boolean isEvening() {
        return Evening;
    }

    public void setEvening(boolean evening) {
        Evening = evening;
    }

    public boolean isNight() {
        return Night;
    }

    public void setNight(boolean night) {
        Night = night;
    }
}
