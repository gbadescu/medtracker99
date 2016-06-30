package com.example.gbadesc.medtracker99.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gbadesc.medtracker99.R;
import com.example.gbadesc.medtracker99.activities.DailyMedsDetail;
import com.example.gbadesc.medtracker99.models.DailySchedule;
import com.example.gbadesc.medtracker99.models.Prescription;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Provide the underlying view for an individual list item.
public class DailyScheduleAdapter extends RecyclerView.Adapter<DailyScheduleAdapter.VH> {
    private Activity mContext;
    private List<DailySchedule> mDailySchedules;
    private List<Prescription> mPrescriptions;
    private DailyPeriodMedAdapter medAdapter;
    private RecyclerView rvMeds;
    private String mDate;


    public DailyScheduleAdapter(Activity context, List<DailySchedule> dailySchedules,String date) {
        mContext = context;
        if (dailySchedules == null) {
            throw new IllegalArgumentException("contacts must not be null");
        }
        mDailySchedules = dailySchedules;

        mPrescriptions = new ArrayList<Prescription>();

        mDate = date;

    }



    // Inflate the view based on the viewType provided.
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily, parent, false);

        // Find RecyclerView and bind to adapter
        rvMeds = (RecyclerView) itemView.findViewById(R.id.rvPeriodMeds);

        // allows for optimizations
        rvMeds.setHasFixedSize(true);

        // Define 2 column grid layout
        final GridLayoutManager layout = new GridLayoutManager(mContext, 2);

        //final CustomLinearLayoutManager layout = new CustomLinearLayoutManager(mContext);

        //final LinearLayoutManager layout = new LinearLayoutManager(mContext);

        // Unlike ListView, you have to explicitly give a LayoutManager to the RecyclerView to position items on the screen.
        // There are three LayoutManager provided at the moment: GridLayoutManager, StaggeredGridLayoutManager and LinearLayoutManager.
        rvMeds.setLayoutManager(layout);

        return new VH(itemView, mContext);
    }

    // Display data at the specified position
    @Override
    public void onBindViewHolder(final VH holder, int position) {
        DailySchedule dailySchedule = mDailySchedules.get(position);
        holder.rootView.setTag(dailySchedule);
        holder.tvName.setText(dailySchedule.getName());

        medAdapter = new DailyPeriodMedAdapter(mContext,mPrescriptions, new setOnClick() {
            @Override
            public void setOnClick() {
                Toast.makeText(holder.itemView .getContext(),"FF  F",Toast.LENGTH_SHORT).show();
            }
        });



        // Bind adapter to list
        rvMeds.setAdapter(medAdapter);

        mPrescriptions.clear();

        List<Prescription> prescriptions = Prescription.getDailyMedsForPeriod(dailySchedule,new Date());

        mPrescriptions.addAll(prescriptions);


        medAdapter.setmPrescriptions(prescriptions);

        medAdapter.notifyDataSetChanged();

// Navigate to contact details activity on click of card view.
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DailySchedule dailySchedule = (DailySchedule) v.getTag();

                if (dailySchedule != null) {
                    // Fire an intent when a contact is selected
                    // Pass contact object in the bundle and populate details activity.

                    Intent i = new Intent(mContext,DailyMedsDetail.class);
                    i.putExtra(DailyMedsDetail.EXTRA_DAILY_SCHEDULE, dailySchedule);
                    i.putExtra(DailyMedsDetail.EXTRA_DATE, mDate );

                    mContext.startActivity(i);
                }


            }
        });



    }

    @Override
    public int getItemCount() {
        return mDailySchedules.size();
    }

    // Provide a reference to the views for each contact item
    public final static class VH extends RecyclerView.ViewHolder {
        final View rootView;
        final ImageView ivProfile;
        final TextView tvName;
        final View vPalette;

        public VH(final View itemView, final Context context) {
            super(itemView);
            rootView = itemView;
            ivProfile = (ImageView)itemView.findViewById(R.id.ivProfile);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            vPalette = itemView.findViewById(R.id.vPalette);


        }
    }
}
