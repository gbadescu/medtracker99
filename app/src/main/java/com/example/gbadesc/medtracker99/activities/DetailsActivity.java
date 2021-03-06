package com.example.gbadesc.medtracker99.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gbadesc.medtracker99.R;
import com.example.gbadesc.medtracker99.models.Contact;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    public static final String EXTRA_CONTACT = "EXTRA_CONTACT";
    private Contact mContact;
    private ImageView ivProfile;
    private TextView tvName;
    private TextView tvPhone;
    private View vPalette;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ivProfile = (ImageView) findViewById(R.id.ivProfile);
        tvName = (TextView) findViewById(R.id.tvName);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        vPalette = findViewById(R.id.vPalette);

        // Extract contact from bundle
        mContact = (Contact)getIntent().getExtras().getSerializable(EXTRA_CONTACT);

        // Fill views with data
        Picasso.with(DetailsActivity.this).load(mContact.getThumbnailDrawable()).fit().centerCrop().into(ivProfile);
        tvName.setText(mContact.getName());
        tvPhone.setText(mContact.getNumber());

        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "tel:" + mContact.getNumber();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case android.R.id.home:
                finishAfterTransition();
                return true;
        }

        return super.onOptionsItemSelected(item);

    }

}
