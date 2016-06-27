package com.example.gbadesc.medtracker99.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gbadesc.medtracker99.R;
import com.example.gbadesc.medtracker99.models.Prescription;

import java.util.List;

// Provide the underlying view for an individual list item.
public class DailyPeriodMedAdapter extends RecyclerView.Adapter<DailyPeriodMedAdapter.FormHolder> {
    private List<Prescription> mPrescriptions;

    public DailyPeriodMedAdapter(Activity context, List<Prescription> prescriptions) {
        if (prescriptions == null) {
            throw new IllegalArgumentException("contacts must not be null");
        }
        mPrescriptions = prescriptions;
    }

    // Inflate the view based on the viewType provided.
    @Override
    public FormHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily_med_period, parent, false);
        return new FormHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FormHolder fh, int pos) {

        fh.txt.setText(mPrescriptions.get(pos).getName());

        // other implementation

    }

    @Override
    public int getItemCount() {
        return mPrescriptions.size();
    }

    static class FormHolder extends RecyclerView.ViewHolder{

        TextView txt;

        public FormHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.tvName);
        }
    }

}
