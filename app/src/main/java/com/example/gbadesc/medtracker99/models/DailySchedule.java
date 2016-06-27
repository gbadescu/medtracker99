package com.example.gbadesc.medtracker99.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gbadesc on 6/24/16.
 */
public class DailySchedule {

    private String startTime;
    private String endTime;
    private String name;
    private int period;

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getName() {
        return name;
    }

    public int getPeriod() {
        return period;
    }

    public DailySchedule(String name, int period, String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.period = period;
    }

    // Returns a list of contacts
    public static List<DailySchedule> getDailySchedules() {
        List<DailySchedule> dailySchedules = new ArrayList<>();
        dailySchedules.add(new DailySchedule("Morning",0,"8:00","11:59"));
        dailySchedules.add(new DailySchedule("Noon",1,"12:00","14:00"));
        dailySchedules.add(new DailySchedule("Afternoon",2,"14:01","17:00"));
        dailySchedules.add(new DailySchedule("Evening",3,"17:01","19:59"));
        dailySchedules.add(new DailySchedule("Night",4,"20:00","23:59"));


        return dailySchedules;
    }

}
