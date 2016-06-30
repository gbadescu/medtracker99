package com.example.gbadesc.medtracker99.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gbadesc.medtracker99.R;
import com.example.gbadesc.medtracker99.adapters.DailyScheduleAdapter;
import com.example.gbadesc.medtracker99.models.DailySchedule;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyFragment extends Fragment {

    private String date;

    private RecyclerView rvDaily;
    private DailyScheduleAdapter mAdapter;
    private List<DailySchedule> dailySchedules;

    public DailyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //non-view related initiazliation

        date = getArguments().getString("date");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvLabel = (TextView) view.findViewById(R.id.frTitle);
        tvLabel.setText(date);

        //view lookups and view initialization

        // Find RecyclerView and bind to adapter
        rvDaily = (RecyclerView) view.findViewById(R.id.rvDaily);

        // allows for optimizations
        rvDaily.setHasFixedSize(true);

        // Define 2 column grid layout
        final StaggeredGridLayoutManager layout = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        // Unlike ListView, you have to explicitly give a LayoutManager to the RecyclerView to position items on the screen.
        // There are three LayoutManager provided at the moment: GridLayoutManager, StaggeredGridLayoutManager and LinearLayoutManager.
        rvDaily.setLayoutManager(layout);

        // get data
        dailySchedules = DailySchedule.getDailySchedules();

        // Create an adapter
        mAdapter = new DailyScheduleAdapter(getActivity(), dailySchedules, date);

        // Bind adapter to list
        rvDaily.setAdapter(mAdapter);
    }

}
