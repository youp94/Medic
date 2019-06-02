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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.medic.Models.Constituant;
import com.medic.Models.Formula;
import com.medic.Models.Medic;
import com.medic.Models.MedicForm;
import com.medic.Models.MedicalClass;
import com.medic.Models.Process;
import com.medic.Models.Step;
import com.medic.R;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private DatabaseReference mDatabase;
    MainAdapter mainAdapter = null;
    ListView listView = null;

    /***********************  Medical class 1 ***************************************************************/

    MedicalClass medicalClass1 = null;
    ArrayList<MedicalClass> medicalClassArrayList = new ArrayList<>();
    ArrayList<Medic> medics = new ArrayList<>();

    /************************************** Medicament 1 ****************************************************/

    Medic medic1 = new Medic("", "Very long medic description text");
    ArrayList<MedicForm> medic1Forms = new ArrayList<>();

    /**************************************** Medicament 1 form 1 ************************************/

    MedicForm medic1Form1 = new MedicForm("", "Very long medic form description text");
    ArrayList<Process> processes11 = new ArrayList<>();

    /********************************************* Medicament 1 form 1 process 1 ********************************/

    Process process111 = new Process("", "Very long process description text");


    /********************************************** Medicament 1 form 1 process formula *********************************/
    Constituant constituant1111 = new Constituant(
            "",
            "",
            "",
            0,
            "",
            ""
    );
    ArrayList<Constituant> constituants111 = new ArrayList<>();

    Step step1111 = new Step("");
    ArrayList<Step> steps111 = new ArrayList<>();

    Formula formula111 = new Formula("", "", "", constituants111, steps111,
            "");

    /**********************************************************************************************************************/


    /**********************************************************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        /********************************** form 1 ***************************************/


        steps111.add(step1111);

        constituants111.add(constituant1111);

        process111.setFormula(formula111);

        processes11.add(process111);
        medic1Form1.setProcessArrayList(processes11);


        medic1Forms.add(medic1Form1);
        medic1.setMedicFormArrayList(medic1Forms);


        medics.add(medic1);


        Random rand = new Random();
        int n = rand.nextInt(50000000);
        medicalClass1 = new MedicalClass(String.valueOf(n), "", "Very long description text");

        medicalClass1.setMedicArrayList(medics);


        medicalClassArrayList.add(medicalClass1);


        mainAdapter = new MainAdapter(this, medicalClassArrayList);

        listView = findViewById(R.id.main_list);
        listView.setAdapter(mainAdapter);

        //mDatabase.child("Medical Classes").child(String.valueOf(medicalClass1.getId())).setValue(medicalClass1);
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
        button.setText("view drugs");

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
