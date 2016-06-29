package com.example.gbadesc.medtracker99.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gbadesc.medtracker99.R;
import com.example.gbadesc.medtracker99.models.Prescription;

import java.util.List;

// Provide the underlying view for an individual list item.
public class DailyPeriodMedAdapter extends RecyclerView.Adapter<DailyPeriodMedAdapter.FormHolder> {
    private List<Prescription> mPrescriptions;
    private Context mContext;
    static setOnClick setOnClick;

    public DailyPeriodMedAdapter(Activity context, List<Prescription> prescriptions,setOnClick setOnClick) {
        if (prescriptions == null) {
            throw new IllegalArgumentException("contacts must not be null");
        }
        mPrescriptions = prescriptions;
        mContext = context;
        this.setOnClick = setOnClick;
    }

    public List<Prescription> getmPrescriptions() {
        return mPrescriptions;
    }

    public void setmPrescriptions(List<Prescription> mPrescriptions) {
        this.mPrescriptions = mPrescriptions;
    }

    // Inflate the view based on the viewType provided.
    @Override
    public FormHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily_med_period, parent, false);
        return new FormHolder(itemView,mContext);
    }

    @Override
    public void onBindViewHolder(FormHolder fh, int pos) {

        fh.txt.setText(mPrescriptions.get(pos).getName());

        GradientDrawable bgShape = (GradientDrawable)fh.myImg.getBackground();

        bgShape.setColor(mPrescriptions.get(pos).getMedication().getColor());

        fh.medName.setText(mPrescriptions.get(pos).getMedication().getName() + "-"+ mPrescriptions.get(pos).getMedication().getDosage() + " "+mPrescriptions.get(pos).getMedication().getUnits());



            // other implementation

    }

    @Override
    public int getItemCount() {

        return mPrescriptions.size();
    }

    public final static class FormHolder extends RecyclerView.ViewHolder{

        TextView txt;
        //get the image button by id
        ImageButton myImg;
        TextView medName;



        public FormHolder(final View itemView,final Context context) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.tvName);
            myImg = (ImageButton) itemView.findViewById(R.id.ivButton);
            medName = (TextView) itemView.findViewById(R.id.medName);

            // Navigate to contact details activity on click of card view.
            myImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //setOnClick.setOnClick();
                    Toast.makeText(itemView .getContext(),medName.getText(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
