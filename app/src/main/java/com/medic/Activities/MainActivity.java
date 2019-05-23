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

    Process process = new Process("Direct compression", "Very long process description text");
    ArrayList<Process> processes = new ArrayList<>();

    ArrayList<String> props1 = new ArrayList<>();
    ArrayList<String> props2 = new ArrayList<>();
    ArrayList<String> props3 = new ArrayList<>();
    ArrayList<String> props4 = new ArrayList<>();
    ArrayList<String> props5 = new ArrayList<>();
    ArrayList<String> props6 = new ArrayList<>();
    Constituant constituant1 = new Constituant(
            "Acetamenophen",
            "DC 90 USP",
            new ArrayList<String>(),
            80.0,
            "Technical data sheet of: Compap™ (Paracetamol Ph Eur; USP 90%).  Mallinckrodt pharmaceuticals. Available on: http://www.mallinckrodt.com/products/active-pharmaceutical-ingredients/acetaminophenparacetamol/"
    );
    Constituant constituant2 = new Constituant(
            "Microcrystalline cellulose coprocessed 2% w/w colloidal silicon dioxide",
            "",
            new ArrayList<String>(),
            17.6,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Cellulose, Microcrystalline. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.129-133."
    );
    Constituant constituant3 = new Constituant(
            "Colloidal silicon dioxide (CSD)",
            "Cab-O-Sil PTG",
            new ArrayList<String>(),
            0.5,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Colloidal silicon dioxide. In Handbook of pharmaceutical excipients, 6e éd. London: The pharmaceutical press, 2009, p. 185-188.\n" +
                    "\n" +
                    "Technical data sheet of: Aerosil®200. Evonik Ressource Effeciency GmbH. Jan 2018. Availble on: https://products-re.evonik.com/www2/uploads/productfinder/AEROSIL-200-FR.pdf "
    );
    Constituant constituant4 = new Constituant(
            "Sodium starch glycolate (SSG)",
            "EXPLOTAB",
            new ArrayList<String>(),
            1.5,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Sodium Starch Glycolate. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.663-666."
    );
    Constituant constituant5 = new Constituant(
            "Sodium stearyl fumarate (SSF)",
            "PRUV",
            new ArrayList<String>(),
            0.4,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Sodium Stearyl Fumarate. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.667-669."
    );
    Constituant constituant6 = new Constituant(
            "Microcrystalline cellulose",
            "EMOCOCEL 90M",
            new ArrayList<String>(),
            0,
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

        props1.add("Crystal form: Orthorhombic type II.");
        props1.add("Granular form.");
        props1.add("Density: from 1 .29 to 1.32 g/cm3.");
        props1.add("Average particle size : 250-300 µm (cross sectional diameter).");
        props1.add("Moisture content : 0.6 – 1.5 %.");
        props2.add("pH: neutral.");
        props2.add("Average particle size: 40-60 µm.");
        props2.add("Tapped density: from 0.35 g/ml to 0.55 g/ml.");
        props2.add("Moisture content: from 3% to 5% by weight.");
        props3.add("Glidant.");
        props3.add("Density (Bulk): 3lb/ft3.");
        props3.add("Density (tapped): 50 g/l.");
        props3.add("Specific surface");
        props3.add("area: 200 m2/g. pH (4% aqueous slurry): 3.7-4.3.");
        props3.add("Refractive index: 1.46.");
        props3.add("%SiO2 > 99.8");
        props3.add("Average particle length: 0.2- 0.3 microns.");
        props3.add("44 microns mesh residue 0.02% max.");
        props4.add("Super disentegrant.");
        props4.add("Ph: 5.5 – 7.5.");
        props4.add("Density (Bulk): 0 .801 g/cm3.");
        props4.add("Density (tapped): 0 .97 g/cm3.");
        props4.add("Average particle size: 38µm and 42µm by microscopy and sieving respectively.");
        props5.add("Lubricant.");
        props5.add("pH : 8.3 for a 5% aqueous solution at 90°C.");
        props5.add("Density (bulk): 0 .2 – 0.35 g/cm3.");
        props5.add("Density (tapped): 0 .3 – 0.5 g/cm3.");
        props5.add("Density (true): 1.107 g/cm3.");
        props5.add("Specific surface area: 1.2 – 2 m²/g.");
        props5.add("Moisture content: <5.0%");
        props6.add("Diluent/ Binder.");
        props6.add("Density (bulk): 0.28 g/cm3.");
        props6.add("Density (tapped):0.43 g/cm3. ");
        props6.add("Density (true): from 1.512 to 1.668 g/cm3.");
        props6.add("Flowability: 1.41 g/s.");
        props6.add("Nominal mean particle size: 91µm.");
        props6.add("Average particle size by laser diffraction: 130 µm.");
        props6.add("Moisture content");

        constituant1.setProperties(props1);
        constituants.add(constituant1);
        constituant2.setProperties(props2);
        constituants.add(constituant2);
        constituant3.setProperties(props3);
        constituants.add(constituant3);
        constituant4.setProperties(props4);
        constituants.add(constituant4);
        constituant5.setProperties(props5);
        constituants.add(constituant5);
        constituant6.setProperties(props6);
        constituants.add(constituant6);

        process.setFormula(formula);

        processes.add(process);
        medicForm.setProcessArrayList(processes);
        /*medicForm2.setProcessArrayList(processes);
        medicForm3.setProcessArrayList(processes);
        medicForm4.setProcessArrayList(processes);
        medic2Form.setProcessArrayList(processes);*/

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
