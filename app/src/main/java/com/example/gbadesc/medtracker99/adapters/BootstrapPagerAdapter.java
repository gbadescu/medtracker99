package com.example.gbadesc.medtracker99.adapters;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.gbadesc.medtracker99.fragments.DailyFragment;

import java.util.Locale;
import java.util.TimeZone;

import hirondelle.date4j.DateTime;


public class BootstrapPagerAdapter extends FragmentPagerAdapter {

    /**
     * Create pager adapter
     *
     * @param resources
     * @param fragmentManager
     */
    public BootstrapPagerAdapter(Resources resources, FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return 10000;
    }
    @Override
    public int getItemPosition(Object object){
        return FragmentStatePagerAdapter.POSITION_NONE;
    }
    @Override
    public Fragment getItem(int position) {

        DateTime pagerdate = DateTime.now(TimeZone.getDefault());
        DateTime days = pagerdate.plusDays(position - 5000);



        Bundle bundle = new Bundle();
        bundle.putString("date", days.format("WWW, MMM DD",new Locale("US")));



        DailyFragment roosterFragment = new DailyFragment();
        roosterFragment.setArguments(bundle);

        return roosterFragment;
    }
}
