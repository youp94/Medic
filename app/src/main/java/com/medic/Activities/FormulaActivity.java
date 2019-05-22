package com.medic.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.medic.Models.Formula;
import com.medic.R;

public class FormulaActivity extends AppCompatActivity {

    Formula formula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);

        formula = (Formula) getIntent().getSerializableExtra("formula");

    }
}
