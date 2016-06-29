package com.example.gbadesc.medtracker99.models;

/**
 * Created by gbadesc on 6/24/16.
 */
public class Schedule {

    private String Day;
    private boolean Morning;
    private boolean Noon;
    private boolean Afternoon;
    private boolean Evening;
    private boolean Night;


    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
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
