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

import com.medic.Models.Process;
import com.medic.R;

import java.util.ArrayList;

public class ProcessActivity extends AppCompatActivity {


    ArrayList<Process> medicArrayList = new ArrayList<>();

    ProcessAdapter mainAdapter = null;

    ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);


        listView = findViewById(R.id.process_list);

        medicArrayList = (ArrayList<Process>) getIntent().getSerializableExtra("medicList");

        mainAdapter = new ProcessAdapter(this, medicArrayList);

        listView.setAdapter(mainAdapter);
    }
}

class ProcessAdapter extends BaseAdapter{

    Context context;
    ArrayList<Process> processes;

    public ProcessAdapter(Context context, ArrayList<Process> processes) {
        this.context = context;
        this.processes = processes;
    }

    @Override
    public int getCount() {
        return processes.size();
    }

    @Override
    public Object getItem(int position) {
        return processes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        final Process medic = processes.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.simple_item,null, false);

        TextView titleText;
        TextView descText;
        Button button;

        titleText = view.findViewById(R.id.class_title);
        descText = view.findViewById(R.id.class_description);
        button = view.findViewById(R.id.class_button);
        button.setText("Voir Formule");

        titleText.setText(medic.getName());
        descText.setText(medic.getDescription());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (medic.getFormula() != null) {
                    Intent intent = new Intent(context, FormulaActivity.class);
                    intent.putExtra("formula", medic.getFormula());
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, "Page under construction", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}
