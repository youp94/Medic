package com.medic.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.medic.Models.Constituant;
import com.medic.R;
import com.squareup.picasso.Picasso;

public class PropertiesActivity extends AppCompatActivity {


    ImageView dsc;
    ImageView ftir;
    ImageView sem;
    ImageView xrd;

    Constituant constituant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties);

        constituant = (Constituant) getIntent().getSerializableExtra("const");

        dsc = findViewById(R.id.dsc);
        ftir = findViewById(R.id.ftir);
        sem = findViewById(R.id.sem);
        xrd = findViewById(R.id.xrd);

        if (!constituant.getDcs().equals("")) {
            Picasso.get().load(constituant.getDcs()).into(dsc);
        }

        if (!constituant.getFtir().equals("")) {
            Picasso.get().load(constituant.getFtir()).into(ftir);
        }

        if (!constituant.getSem().equals("")) {
            Picasso.get().load(constituant.getSem()).into(sem);
        }

        if (!constituant.getXrd().equals("")) {
            Picasso.get().load(constituant.getXrd()).into(xrd);
        }

    }
}