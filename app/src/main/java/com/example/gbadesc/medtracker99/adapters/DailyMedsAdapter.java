package com.example.gbadesc.medtracker99.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gbadesc.medtracker99.R;
import com.example.gbadesc.medtracker99.models.DailySchedule;
import com.example.gbadesc.medtracker99.models.Prescription;

import java.util.Date;
import java.util.List;

// Provide the underlying view for an individual list item.
public class DailyMedsAdapter extends RecyclerView.Adapter<DailyMedsAdapter.VH> {
    private Activity mContext;
    private DailySchedule mDailySchedule;
    private List<Prescription> mPrescriptions;
    private DailyPeriodMedAdapter medAdapter;
    private RecyclerView rvMeds;


    public DailyMedsAdapter(Activity context, DailySchedule dailySchedule) {
        mContext = context;
        if (dailySchedule == null) {
            throw new IllegalArgumentException("contacts must not be null");
        }
        mDailySchedule = dailySchedule;

         List<Prescription> prescriptions = Prescription.getDailyMedsForPeriod(dailySchedule,new Date());

        mPrescriptions = prescriptions;

    }

    // Inflate the view based on the viewType provided.
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily_med_detail, parent, false);

        return new VH(itemView, mContext);
    }

    // Display data at the specified position
    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        DailySchedule dailySchedule = mDailySchedule;
        holder.rootView.setTag(mPrescriptions.get(position));

        holder.medName.setText(mPrescriptions.get(position).getMedication().getName());
        holder.medDose.setText(new Float(mPrescriptions.get(position).getMedication().getDosage()).toString());
        holder.medUnit.setText(mPrescriptions.get(position).getMedication().getUnits());

        // Navigate to contact details activity on click of card view.
        holder.takeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext,"Taken:" + holder.medName.getText(),Toast.LENGTH_SHORT).show();

                holder.takeButton.setText("Taken");
                holder.takeButton.setEnabled(false);
            }
        });



     }

    @Override
    public int getItemCount() {
        return mPrescriptions.size();
    }

    // Provide a reference to the views for each contact item
    public final static class VH extends RecyclerView.ViewHolder {
        final View rootView;

        final TextView medName;
        final TextView medDose;
        final TextView medUnit;
        final Button takeButton;



        public VH(final View itemView, final Context context) {
            super(itemView);
            rootView = itemView;

            medName = (TextView)itemView.findViewById(R.id.medName);
            medDose = (TextView)itemView.findViewById(R.id.medDose);
            medUnit = (TextView)itemView.findViewById(R.id.medUnit);

            takeButton = (Button)itemView.findViewById(R.id.ivTakeButton);





        }
    }
}
