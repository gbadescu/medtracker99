package com.example.gbadesc.medtracker99.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.gbadesc.medtracker99.R;
import com.example.gbadesc.medtracker99.adapters.BootstrapPagerAdapter;
import com.example.gbadesc.medtracker99.models.Medication;
import com.example.gbadesc.medtracker99.models.Prescription;
import com.example.gbadesc.medtracker99.models.Schedule;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class DailyMedsActivity extends AppCompatActivity {
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_meds);

        createSamplePrescriptions();

        pager = (ViewPager) findViewById(R.id.vpPager);

        pager.setAdapter(new BootstrapPagerAdapter(getResources(), getSupportFragmentManager()));
        pager.setCurrentItem(5000, false);
        pager.post(new Runnable() {
            public void run() {
                pager.setCurrentItem(5000, false);
            }
        });
        pager.getAdapter().notifyDataSetChanged();
        pager.setOffscreenPageLimit(0);

        ImageButton leftNav = (ImageButton) findViewById(R.id.left_nav);
        ImageButton rightNav = (ImageButton) findViewById(R.id.right_nav);

// Images left navigation
        leftNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = pager.getCurrentItem();
                if (tab > 0) {
                    tab--;
                    pager.setCurrentItem(tab);
                } else if (tab == 0) {
                    pager.setCurrentItem(tab);
                }
            }
        });

        // Images right navigatin
        rightNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = pager.getCurrentItem();
                tab++;
                pager.setCurrentItem(tab);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_daily, menu);
        return true;
    }

    private void createSamplePrescriptions()
    {

        ArrayList<Prescription> l1 = new ArrayList<>();

        Medication med1 = new Medication("Aspirin",81,"mg", Color.BLUE);
        Schedule s1 = new Schedule(true,false,false,false,false,false,false,true,false,false,false,false);

        Prescription p1 = new Prescription("P1");
        p1.setSchedule(s1);
        p1.setMedication(med1);

        Medication med6 = new Medication("Bayer",81,"mg",Color.YELLOW);
        Schedule s2 = new Schedule(true,false,false,false,false,false,false,false,true,false,false,false);

        Prescription p6 = new Prescription("P6");
        p6.setMedication(med6);
        p6.setSchedule(s2);

        l1.add(p1);
        l1.add(p6);

        ArrayList<Prescription> l2 = new ArrayList<>();
        Medication med2 = new Medication("Tylenol",81,"mg",Color.GREEN);
        Schedule s3 = new Schedule(true,false,false,false,false,false,false,false,true,false,true,false);
        Prescription p2 = new Prescription("P2");
        p2.setMedication(med2);
        p2.setSchedule(s3);
        l1.add(p2);

        ArrayList<Prescription> l3 = new ArrayList<>();
        Medication med3 = new Medication("Motrin",81,"mg",Color.CYAN);
        Schedule s4 = new Schedule(true,false,false,false,false,false,false,false,true,false,true,true);
        Prescription p3 = new Prescription("P3");
        p3.setMedication(med3);
        p3.setSchedule(s4);
        l1.add(p3);

        ArrayList<Prescription> l4 = new ArrayList<>();
        Medication med4 = new Medication("Advil",81,"mg",Color.WHITE);
        Schedule s5 = new Schedule(true,false,false,false,false,false,false,false,true,true,false,false);
        Prescription p4 = new Prescription("P4");
        p4.setMedication(med4);
        p4.setSchedule(s5);
        l1.add(p4);

        ArrayList<Prescription> l5 = new ArrayList<>();
        Medication med5 = new Medication("Aleve",81,"mg",Color.CYAN);
        Schedule s6 = new Schedule(true,false,false,false,false,false,false,false,true,false,true,false);
        Prescription p5 = new Prescription("P5");
        p5.setMedication(med5);
        p5.setSchedule(s6);
        l1.add(p5);


        Prescription.setPrescriptionList(l1);

    }

    Prescription createRandomPrescription()
    {
        int prescriptionName = (new Random().nextInt() %10);

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        SecureRandom random = new SecureRandom();

        String medName =  new BigInteger(20, random).toString(16);

        Medication med5 = new Medication(medName,81,"mg",color);

        Schedule s1 = new Schedule(true,false,false,false,false,false,false,new Random().nextBoolean(),true,new Random().nextBoolean(),new Random().nextBoolean(),false);

        Prescription p5 = new Prescription("P"+ prescriptionName);
        p5.setMedication(med5);
        p5.setSchedule(s1);

        return p5;
    }

    public void onAddAction(MenuItem mi) {
        // handle click here

        ArrayList<Prescription> prescriptions = Prescription.getPrescriptionList();

        // Add a new contact
        prescriptions.add(createRandomPrescription());


        Prescription.setPrescriptionList(prescriptions);

        pager.getAdapter().notifyDataSetChanged();

// Notify the adapter that an item was inserted at position 0
       /* mAdapter.notifyItemInserted(0);

        Snackbar.make(rvContacts, R.string.snackbar_text, Snackbar.LENGTH_LONG)
                .setAction(R.string.snackbar_action, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        contacts.remove(0);
                        mAdapter.notifyItemRemoved(0);
                    }
                })  // action text on the right side
                .setActionTextColor(ContextCompat.getColor(ContactsActivity.this, R.color.accent))
                .setDuration(3000).show();*/



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
