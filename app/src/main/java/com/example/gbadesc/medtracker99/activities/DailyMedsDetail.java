package com.example.gbadesc.medtracker99.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.gbadesc.medtracker99.R;
import com.example.gbadesc.medtracker99.adapters.DailyMedsAdapter;
import com.example.gbadesc.medtracker99.adapters.DividerItemDecoration;
import com.example.gbadesc.medtracker99.models.DailySchedule;
import com.example.gbadesc.medtracker99.models.Prescription;

import java.util.Date;
import java.util.List;

public class DailyMedsDetail extends AppCompatActivity {

    public static final String EXTRA_DAILY_SCHEDULE = "EXTRA_DAILY_SCHEDULE";
    public static final String EXTRA_PRESCRIPTIONS = "EXTRA_PRESCRIPTIONS";
    RecyclerView rvMedsDetail;
    DailyMedsAdapter medsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_meds_detail);

        DailySchedule dailySchedule =  (DailySchedule) getIntent().getExtras().getSerializable(EXTRA_DAILY_SCHEDULE);

        List<Prescription> prescriptions = Prescription.getDailyMedsForPeriod(dailySchedule,new Date());

        //view lookups and view initialization

        // Find RecyclerView and bind to adapter
        rvMedsDetail = (RecyclerView) findViewById(R.id.rvDailyMedsDetail);

        // allows for optimizations
        rvMedsDetail.setHasFixedSize(true);

        // Define 2 column grid layout
        final LinearLayoutManager layout = new LinearLayoutManager(DailyMedsDetail.this,LinearLayoutManager.VERTICAL, false);

        // Unlike ListView, you have to explicitly give a LayoutManager to the RecyclerView to position items on the screen.
        // There are three LayoutManager provided at the moment: GridLayoutManager, StaggeredGridLayoutManager and LinearLayoutManager.
        rvMedsDetail.setLayoutManager(layout);

        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        rvMedsDetail.addItemDecoration(itemDecoration);


        // Create an adapter
        medsAdapter = new DailyMedsAdapter(DailyMedsDetail.this, dailySchedule);

        // Bind adapter to list
        rvMedsDetail.setAdapter(medsAdapter);

        TextView tvName = (TextView) findViewById(R.id.tvName);

        tvName.setText(dailySchedule.getName());
    }
}
