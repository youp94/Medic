package com.medic.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.medic.Models.Constituant;
import com.medic.Models.Formula;
import com.medic.Models.Medic;
import com.medic.Models.MedicForm;
import com.medic.Models.MedicalClass;
import com.medic.Models.Process;
import com.medic.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    MedicalClass medicalClass1 = new MedicalClass("Analgesics- antipyretics – antispasmodics", "Very long description text");
    ArrayList<MedicalClass> medicalClassArrayList = new ArrayList<>();

    ArrayList<Medic> medics = new ArrayList<>();

    Medic medic = new Medic("Acetaminophen", "Very long medic description text");

    MedicForm medicForm = new MedicForm("Direct compression", "Very long medic form description text");
    MedicForm medicForm2 = new MedicForm("Injectable", "Very long medic form description text");
    MedicForm medicForm3 = new MedicForm("Sugar free", "Very long medic form description text");
    MedicForm medicForm4 = new MedicForm("Syrop", "Very long medic form description text");

    ArrayList<MedicForm> medicForms = new ArrayList<>();

    Medic medic2 = new Medic("Ibuprofen", "Very long medic description text");

    MedicForm medic2Form = new MedicForm("Tablet", "Very long medic form description text");

    ArrayList<MedicForm> medic2Forms = new ArrayList<>();

    Process process = new Process("Process name", "Very long process description text");
    ArrayList<Process> processes = new ArrayList<>();

    Constituant constituant1 = new Constituant(
            "Acetamenophen",
            "DC 90 USP",
            new ArrayList<String>(),
            80.0,
            ""
    );
    Constituant constituant2 = new Constituant(
            "Microcrystalline cellulose coprocessed 2% w/w colloidal silicon dioxide",
            "",
            new ArrayList<String>(),
            17.6,
            ""
    );
    Constituant constituant3 = new Constituant(
            "Colloidal silicon dioxide (CSD)",
            "Cab-O-Sil PTG",
            new ArrayList<String>(),
            0.5,
            ""
    );
    Constituant constituant4 = new Constituant(
            "Sodium starch glycolate (SSG)",
            "EXPLOTAB",
            new ArrayList<String>(),
            1.5,
            ""
    );
    Constituant constituant5 = new Constituant(
            "Sodium stearyl fumarate (SSF)",
            "PRUV",
            new ArrayList<String>(),
            0.4,
            ""
    );
    Constituant constituant6 = new Constituant(
            "Sodium stearyl fumarate (SSF)",
            "PRUV",
            new ArrayList<String>(),
            0.4,
            ""
    );
    ArrayList<Constituant> constituants = new ArrayList<>();

    Formula formula = new Formula("Direct compression", "Description", constituants);


    MainAdapter mainAdapter = new MainAdapter(this, medicalClassArrayList);

    ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constituants.add(constituant1);
        constituants.add(constituant2);
        constituants.add(constituant3);
        constituants.add(constituant4);
        constituants.add(constituant5);
        constituants.add(constituant6);

        process.setFormula(formula);

        processes.add(process);
        medicForm.setProcessArrayList(processes);
        medicForm2.setProcessArrayList(processes);
        medicForm3.setProcessArrayList(processes);
        medicForm4.setProcessArrayList(processes);
        medic2Form.setProcessArrayList(processes);

        medicForms.add(medicForm);
        medicForms.add(medicForm2);
        medicForms.add(medicForm3);
        medicForms.add(medicForm4);
        medic.setMedicFormArrayList(medicForms);

        medic2Forms.add(medic2Form);
        medic2.setMedicFormArrayList(medic2Forms);

        medics.add(medic);
        medics.add(medic2);
        medicalClass1.setMedicArrayList(medics);

        medicalClassArrayList.add(medicalClass1);



        listView = findViewById(R.id.main_list);
        listView.setAdapter(mainAdapter);
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
        descText = view.findViewById(R.id.class_description);
        button = view.findViewById(R.id.class_button);
        button.setText("Voir Médicaments");

        titleText.setText(medicalClass.getName());
        descText.setText(medicalClass.getDescription());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MedicActivity.class);
                intent.putExtra("medicList", medicalClass.getMedicArrayList());
                context.startActivity(intent);
            }
        });

        return view;
    }
}
