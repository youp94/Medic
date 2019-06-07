package com.medic.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.medic.Models.MedicalClass;
import com.medic.R;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {


    private DatabaseReference mDatabase;

    ArrayList<MedicalClass> medicalClassArrayList = new ArrayList<>();

    /**********************************************************************************************************************/


    MainAdapter mainAdapter = null;

    ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mainAdapter = new MainAdapter(this, medicalClassArrayList);

        listView = findViewById(R.id.main_list);
        listView.setAdapter(mainAdapter);

        mDatabase.child("Medical Classes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> i = dataSnapshot.getChildren().iterator();
                while (i.hasNext()) {
                    MedicalClass medicalClass = i.next().getValue(MedicalClass.class);
                    Toast.makeText(MainActivity.this, medicalClass.getName(), Toast.LENGTH_LONG).show();
                    medicalClassArrayList.add(medicalClass);
                    medicalClassArrayList.get(0).getId();
                }
                mainAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

class MainAdapter extends BaseAdapter{

    Context context;
    ArrayList<MedicalClass> medicalClassArrayList;

    public MainAdapter(Context context, ArrayList<MedicalClass> medicalClassArrayList) {
        this.context = context;
        this.medicalClassArrayList = medicalClassArrayList;
    }

    @Override
    public int getCount() {
        return medicalClassArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return medicalClassArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        final MedicalClass medicalClass = medicalClassArrayList.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.simple_item,null, false);

        TextView titleText;
        TextView descText;
        Button button;

        titleText = view.findViewById(R.id.class_title);
        button = view.findViewById(R.id.class_button);
        button.setText("Voir Médicaments");

        titleText.setText(medicalClass.getName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (medicalClass.getMedicArrayList() != null) {
                    Intent intent = new Intent(context, MedicActivity.class);
                    intent.putExtra("medicList", medicalClass.getMedicArrayList());
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, "Page under construction", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}
