package com.medic.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.medic.Models.Constituant;
import com.medic.Models.Step;
import com.medic.R;

import java.util.ArrayList;

public class FormulaProcessActivity extends AppCompatActivity {

    ArrayList<Step> steps = null;
    StepsAdapter stepsAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula_process);

        steps = (ArrayList<Step>) getIntent().getSerializableExtra("steps");

        ListView viewPager = findViewById(R.id.steps_list);

        //Toast.makeText(this, steps.get(0).getDesc(),Toast.LENGTH_LONG).show();

        stepsAdapter = new StepsAdapter(this, steps);
        viewPager.setAdapter(stepsAdapter);
    }
}

class StepsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Step> constituants;

    StepsAdapter(Context context, ArrayList<Step> medicalClassArrayList) {
        this.context = context;
        this.constituants = medicalClassArrayList;
    }

    @Override
    public int getCount() {
        return constituants.size();
    }

    @Override
    public Object getItem(int position) {
        return constituants.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        final Step constituant = constituants.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint({"ViewHolder", "InflateParams"}) View view = inflater.inflate(R.layout.step_page,null, false);

        TextView titleText;
        TextView gradText;

        titleText = view.findViewById(R.id.page_title);
        gradText = view.findViewById(R.id.page_description);

        titleText.setText("Step: "+String.valueOf(position+1));
        String grade = "Description: \n" + constituant.getDesc();
        gradText.setText(grade);

        return view;
    }
}
