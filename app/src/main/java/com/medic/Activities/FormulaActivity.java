package com.medic.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.medic.Models.Constituant;
import com.medic.Models.Formula;
import com.medic.R;

import java.util.ArrayList;

public class FormulaActivity extends AppCompatActivity {

    Formula formula;

    ConstituantsAdapter mainAdapter = null;
    ListView listView = null;

    Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);

        formula = (Formula) getIntent().getSerializableExtra("formula");

        listView = findViewById(R.id.constituant_list);
        mainAdapter = new ConstituantsAdapter(this, formula.getConstituants());
        listView.setAdapter(mainAdapter);

        button = findViewById(R.id.formula_process);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (formula.getSteps() != null) {
                    Intent intent = new Intent(FormulaActivity.this, FormulaProcessActivity.class);
                    intent.putExtra("steps", formula.getSteps());
                    intent.putExtra("characs", formula.getCharacs());
                    startActivity(intent);
                } else {
                    Toast.makeText(FormulaActivity.this, "Page under construction", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}


class ConstituantsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Constituant> constituants;

    ConstituantsAdapter(Context context, ArrayList<Constituant> medicalClassArrayList) {
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
        final Constituant constituant = constituants.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint({"ViewHolder", "InflateParams"}) View view = inflater.inflate(R.layout.constituant_item,null, false);

        TextView titleText;
        TextView gradText;
        TextView quanText;
        Button refButton;
        Button propsButton;

        titleText = view.findViewById(R.id.constituant_title);
        gradText = view.findViewById(R.id.constituant_grade);
        quanText = view.findViewById(R.id.constituant_quantity);
        refButton = view.findViewById(R.id.constituant_ref);
        propsButton = view.findViewById(R.id.constituant_prop);

        titleText.setText(constituant.getName());
        String grade = "Grade: " + constituant.getGrade();
        gradText.setText(grade);
        String quantity = "Quantity: " + constituant.getQuantity()+" "+constituant.getUnit();
        quanText.setText(quantity);
        refButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Reference")
                        .setMessage(constituant.getRef())
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Continue with delete operation
                            }
                        }).show();
            }
        });

        propsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Properties")
                        .setMessage(constituant.getProperties())
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Continue with delete operation
                            }
                        }).show();
            }
        });

        return view;
    }
}