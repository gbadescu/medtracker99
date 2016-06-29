package com.example.gbadesc.medtracker99.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.gbadesc.medtracker99.R;
import com.example.gbadesc.medtracker99.adapters.BootstrapPagerAdapter;

public class DailyMedsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_meds);

        final ViewPager pager = (ViewPager) findViewById(R.id.vpPager);

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

    public void onAddAction(MenuItem mi) {
        // handle click here

/*
        // Add a new contact
        contacts.add(0, Contact.getRandomContact(this));
// Notify the adapter that an item was inserted at position 0
        mAdapter.notifyItemInserted(0);

        Snackbar.make(rvContacts, R.string.snackbar_text, Snackbar.LENGTH_LONG)
                .setAction(R.string.snackbar_action, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        contacts.remove(0);
                        mAdapter.notifyItemRemoved(0);
                    }
                })  // action text on the right side
                .setActionTextColor(ContextCompat.getColor(ContactsActivity.this, R.color.accent))
                .setDuration(3000).show();

               */

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
