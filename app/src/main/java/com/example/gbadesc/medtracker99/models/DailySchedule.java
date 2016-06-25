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


    public DailySchedule(String startTime, String endTime, String name) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
    }

    // Returns a list of contacts
    public static List<DailySchedule> getDailySchedules() {
        List<DailySchedule> dailySchedules = new ArrayList<>();
        dailySchedules.add(new DailySchedule("Morning","8:00","11:59"));
        dailySchedules.add(new DailySchedule("Noon","12:00","14:00"));
        dailySchedules.add(new DailySchedule("Afternoon","14:01","17:00"));
        dailySchedules.add(new DailySchedule("Evening","17:01","19:59"));
        dailySchedules.add(new DailySchedule("Night","20:00","23:59"));


        return dailySchedules;
    }

}
