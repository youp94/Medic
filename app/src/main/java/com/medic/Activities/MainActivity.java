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
import com.medic.Models.Step;
import com.medic.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /***********************  Medical class 1 ***************************************************************/
    MedicalClass medicalClass1 = new MedicalClass("Analgesics- antipyretics – antispasmodics", "Very long description text");
    ArrayList<MedicalClass> medicalClassArrayList = new ArrayList<>();

    ArrayList<Medic> medics = new ArrayList<>();

    /************************************** Medicament 1 ****************************************************/

    Medic medic = new Medic("Acetaminophen", "Very long medic description text");

    /**************************************** Medicament 1 forms ************************************/

    MedicForm medicForm = new MedicForm("Tablet", "Very long medic form description text");
    MedicForm medicForm2 = new MedicForm("Injectable", "Very long medic form description text");
    MedicForm medicForm4 = new MedicForm("Syrup", "Very long medic form description text");

    ArrayList<MedicForm> medicForms = new ArrayList<>();


    ArrayList<MedicForm> medic2Forms = new ArrayList<>();

    /********************************************* Medicament 1 form 1 process ********************************/

    Process process = new Process("Direct compression", "Very long process description text");
    ArrayList<Process> processes = new ArrayList<>();


    /********************************************** Medicament 1 form 1 process formula *********************************/
    Constituant constituant1 = new Constituant(
            "Acetamenophen",
            "DC 90 USP",
            "    • Crystal form: Orthorhombic type II.\n" +
                    "    • Granular form.\n" +
                    "    • Density: from 1 .29 to 1.32 g/cm3.\n" +
                    "    • Average particle size : 250-300 µm (cross sectional diameter).\n" +
                    "    • Moisture content : 0.6 – 1.5 %.",
            80.0,
            "Technical data sheet of: Compap™ (Paracetamol Ph Eur; USP 90%).  Mallinckrodt pharmaceuticals. Available on: " +
                    "http://www.mallinckrodt.com/products/active-pharmaceutical-ingredients/acetaminophenparacetamol/",
            "%"
    );
    Constituant constituant2 = new Constituant(
            "Microcrystalline cellulose coprocessed 2% w/w colloidal silicon dioxide",
            "",
            "    • pH: neutral.\n" +
                    "    • Average particle size: 40-60 µm.\n" +
                    "    • Tapped density: from 0.35 g/ml to 0.55 g/ml.\n" +
                    "    • Moisture content: from 3% to 5% by weight.",
            17.6,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Cellulose, Microcrystalline. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.129-133.",
            "%"
    );
    Constituant constituant3 = new Constituant(
            "Colloidal silicon dioxide (CSD)",
            "Cab-O-Sil PTG",
            "    • Glidant.\n" +
                    "    • Density (Bulk): 3lb/ft3.\n" +
                    "    • Density (tapped): 50 g/l.\n" +
                    "    • Specific surface area: 200 m2/g.\n" +
                    "    • pH (4% aqueous slurry): 3.7-4.3.\n" +
                    "    • Refractive index: 1.46.\n" +
                    "    • %SiO2 > 99.8\n" +
                    "    • Average particle length: 0.2- 0.3 microns.\n" +
                    "    • 44 microns mesh residue 0.02% max.",
            0.5,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Colloidal silicon dioxide. In Handbook of pharmaceutical excipients, 6e éd. London: The pharmaceutical press, 2009, p. 185-188.\n" +
                    "\n" +
                    "Technical data sheet of: Aerosil®200. Evonik Ressource Effeciency GmbH. Jan 2018. Availble on: https://products-re.evonik.com/www2/uploads/productfinder/AEROSIL-200-FR.pdf ",
            "%"
    );
    Constituant constituant4 = new Constituant(
            "Sodium starch glycolate (SSG)",
            "EXPLOTAB",
            "    • Super disentegrant.\n" +
                    "    • Ph: 5.5 – 7.5.\n" +
                    "    •  Density (Bulk): 0 .801 g/cm3.\n" +
                    "    • Density (tapped): 0 .97 g/cm3.\n" +
                    "    • Average particle size: 38µm and 42µm by microscopy and sieving respectively.",
            1.5,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Sodium Starch Glycolate. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.663-666.",
            "%"
    );
    Constituant constituant5 = new Constituant(
            "Sodium stearyl fumarate (SSF)",
            "PRUV",
            "    • Lubricant.\n" +
                    "    • pH : 8.3 for a 5% aqueous solution at 90°C.\n" +
                    "    • Density (bulk): 0 .2 – 0.35 g/cm3.\n" +
                    "    • Density (tapped): 0 .3 – 0.5 g/cm3.\n" +
                    "    • Density (true): 1.107 g/cm3.\n" +
                    "    • Specific surface area: 1.2 – 2 m²/g.\n" +
                    "    • Moisture content: <5.0%",
            0.4,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Sodium Stearyl Fumarate. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.667-669.",
            "%"
    );
    Constituant constituant6 = new Constituant(
            "Microcrystalline cellulose",
            "EMOCOCEL 90M",
            "    • Diluent/ Binder.\n" +
                    "    • Density (bulk): 0.28 g/cm3.\n" +
                    "    • Density (tapped):0.43 g/cm3. \n" +
                    "    • Density (true): from 1.512 to 1.668 g/cm3.\n" +
                    "    • Flowability: 1.41 g/s.",
            0,
            "",
            "%"
    );
    ArrayList<Constituant> constituants = new ArrayList<>();

    Step step1 = new Step("MCC-SiO2 product 2%w/w SiO2:\n" +
            "    • Combination of 6.2 kg of microcrystalline cellulose with 5.2 kg of water in a mix tank to form a slurry containing about 15% solids.\n" +
            "    • The pH was adjusted to neutral with about 3 ml of ammonium hydroxide. \n" +
            "    • Mixing the slurry for about 15 minutes then, combined with 2% W/W colloidal silicon dioxide.\n" +
            "    • The slurry was spray dried.");

    Step step2 = new Step("    • Addition of the coprocessed MCC to the high shear granulator along with the acetaminophen, CDS and SSG.\n" +
            "    • Mixing the ingredients dry,high shear conditions.");
    Step step3 = new Step("Addition of sodium stearyl fumarate and mixing was continued.");
    Step step4 = new Step("Direct compression");
    Step step5 = new Step("Coating (in option) using EUDRAGIT L100-500 and/or HPMC Opadry colorcon.");
    ArrayList<Step> steps = new ArrayList<>();

    Formula formula = new Formula("","Direct compression", "Description", constituants, steps);

    /**********************************************************************************************************************/



    /************************************ Medicament 2 *************************************************************/

    Medic medic2 = new Medic("Ibuprofen", "Very long medic description text");

    /*************************************** Medicament 2 forms *******************************************************/
    MedicForm medic2Form = new MedicForm("Tablet", "Very long medic form description text");


    MainAdapter mainAdapter = new MainAdapter(this, medicalClassArrayList);

    ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        steps.add(step1);
        steps.add(step2);
        steps.add(step3);
        steps.add(step4);
        steps.add(step5);

        constituants.add(constituant1);
        constituants.add(constituant2);
        constituants.add(constituant3);
        constituants.add(constituant4);
        constituants.add(constituant5);
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
