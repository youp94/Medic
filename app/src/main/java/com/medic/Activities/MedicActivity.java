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

import com.medic.Models.Medic;
import com.medic.R;

import java.util.ArrayList;

public class MedicActivity extends AppCompatActivity {


    ArrayList<Medic> medicArrayList = new ArrayList<>();

    MedicAdapter mainAdapter = null;

    ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medic);


        listView = findViewById(R.id.medic_list);

        medicArrayList = (ArrayList<Medic>) getIntent().getSerializableExtra("medicList");

        mainAdapter = new MedicAdapter(this, medicArrayList);

        listView.setAdapter(mainAdapter);
    }
}

class MedicAdapter extends BaseAdapter{

    Context context;
    ArrayList<Medic> medicArrayList;

    public MedicAdapter(Context context, ArrayList<Medic> medicArrayList) {
        this.context = context;
        this.medicArrayList = medicArrayList;
    }

    @Override
    public int getCount() {
        return medicArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return medicArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        final Medic medic = medicArrayList.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.simple_item,null, false);

        TextView titleText;
        TextView descText;
        Button button;

        titleText = view.findViewById(R.id.class_title);
        button = view.findViewById(R.id.class_button);
        button.setText("view formes");

        titleText.setText(medic.getName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (medic.getMedicFormArrayList() != null) {
                    Intent intent = new Intent(context, MedicFormActivity.class);
                    intent.putExtra("medicList", medic.getMedicFormArrayList());
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, "Page under construction", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}
