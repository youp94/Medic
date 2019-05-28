package com.medic.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.medic.Models.MedicForm;
import com.medic.R;

import java.util.ArrayList;

public class MedicFormActivity extends AppCompatActivity {


    ArrayList<MedicForm> medicArrayList = new ArrayList<>();

    MedicFormAdapter mainAdapter = null;

    ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medic_form);


        listView = findViewById(R.id.medic_form_list);

        medicArrayList = (ArrayList<MedicForm>) getIntent().getSerializableExtra("medicList");

        mainAdapter = new MedicFormAdapter(this, medicArrayList);

        listView.setAdapter(mainAdapter);
    }
}

class MedicFormAdapter extends BaseAdapter{

    Context context;
    ArrayList<MedicForm> medicForms;

    public MedicFormAdapter(Context context, ArrayList<MedicForm> medicForms) {
        this.context = context;
        this.medicForms = medicForms;
    }

    @Override
    public int getCount() {
        return medicForms.size();
    }

    @Override
    public Object getItem(int position) {
        return medicForms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        final MedicForm medic = medicForms.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.simple_item,null, false);

        TextView titleText;
        TextView descText;
        Button button;

        titleText = view.findViewById(R.id.class_title);
        button = view.findViewById(R.id.class_button);
        button.setText("Voir Precess");

        titleText.setText(medic.getName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(medic.getProcessArrayList() != null) {
                    if (medic.getName().equals("Tablet") || medic.getName().equals("Granul")) {
                        Intent intent = new Intent(context, ProcessActivity.class);
                        intent.putExtra("medicList", medic.getProcessArrayList());
                        context.startActivity(intent);
                    }else{
                        Intent intent = new Intent(context, FormulaActivity.class);
                        intent.putExtra("formula", medic.getProcessArrayList().get(0).getFormula());
                        context.startActivity(intent);
                    }
                }else{
                    Toast.makeText(context, "Page under construction", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}
