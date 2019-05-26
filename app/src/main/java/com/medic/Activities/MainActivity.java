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
    MedicForm medicForm3 = new MedicForm("Syrup", "Very long medic form description text");

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



    /********************************************* Medicament 1 form 2 process ********************************/

    Process process2 = new Process("", "Very long process description text");
    ArrayList<Process> processes2 = new ArrayList<>();


    /********************************************** Medicament 1 form 2 process formula *********************************/
    Constituant constituant21 = new Constituant(
            "Acetamenophen",
            "",
            "    • Crystal form: Monoclinic type I.\n" +
                    "    • Space group: P21/n.\n" +
                    "    • pH in an aqueous solution: 5 - 6.5.\n" +
                    "    • Solubility in water at 20°C: 1.4 g/100ml.",
            1,
            "N. Al-Zoubi, J.E. Koundourellis, S. Malamataris. FT-IR and Raman spectroscopic methods for identification and quantitation of orthorhombic and monoclinic paracetamol in powder mixes. «Journal of Pharmaceutical and Biomedical Analysis», 2002.\n" +
                    "\n" +
                    "G. L. Perlovich, Tatyana V. Volkova and Annette Bauer-Brandl. POLYMORPHISM OF PARACETAMOL: Relative stability of the monoclinic and orthorhombic phase revisited by sublimation and solution calorimetry. «Journal of Thermal Analysis and Calorimetry», September, 2007, vol.89.\n" +
                    "\n" +
                    "John F. Kauffman, Linda M. Batykefer, David D. Tuschel. Raman detected differential scanning calorimetry of polymorphic transformations in acetaminophen. «Journal of Pharmaceutical and Biomedical Analysis», 2008.",
            "g/100 ml"
    );
    Constituant constituant22 = new Constituant(
            "Monosodium phosphate dihydrate",
            "Injectable grade",
            "    • Buffering agent.\n",
            0.1002,
            "",
            "g/100 ml"
    );
    Constituant constituant23 = new Constituant(
            "Disodium phosphate dihydrate",
            "Injectable grade",
            "     • Buffering agent.\n",
            0.0785,
            "",
            "g/100 ml"
    );
    Constituant constituant24 = new Constituant(
            "Sodium chloride",
            "Injectable grade",
            "     • Isotonic agent.\n" +
                    "    • Density: 1.2 g/cm3 for a saturated aqueous solution.\n" +
                    "    • Density (bulk): 0.93 g/cm3.\n" +
                    "    • Density (tapped): 1.09 g/cm3.\n" +
                    "    • pH : 6.7-7.3 for a saturated aqueous solution.\n" +
                    "    • Solubility at 20°C in water: 1 in 2.8.\n" +
                    "    • Osmolarity: iso-osmotic with serum.",
            0.65,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Sodium chloride. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 637-640.",
            "g/100 ml"
    );
    Constituant constituant25 = new Constituant(
            "Water",
            "Injectable grade",
            "",
            100,
            "",
            "ml"
    );
    ArrayList<Constituant> constituants2 = new ArrayList<>();


    Step step21 = new Step(" Mixing :\n" +
            "    • Acetaminophen.\n" +
            "    • Ultrapurified water for injection.\n" +
            "    • Monosodium phosphate dihydrate and disodium phosphate dihydrate. \n" +
            "    • Sodium chloride.");
    Step step22 = new Step("Heating the mixture.");
    Step step23 = new Step("Filling of bottles.");
    Step step24 = new Step("Sterilizing bottles by therm.");
    ArrayList<Step> steps2 = new ArrayList<>();

    Formula formula2 = new Formula("","Injection", "Description", constituants2, steps2);

    /**********************************************************************************************************************/




    /********************************************* Medicament 1 form 3 process ********************************/

    Process process3 = new Process("", "Very long process description text");
    ArrayList<Process> processes3 = new ArrayList<>();


    /********************************************** Medicament 1 form 3 process formula *********************************/
    Constituant constituant31 = new Constituant(
            "Acetaminophen",
            "",
            "    • Crystal form: Monoclinic type I.\n" +
                    "    • Space group: P21/n.\n" +
                    "    • pH in an aqueous solution: 5 - 6.5.\n" +
                    "    • Solubility in water at 20°C: 1.4 g/100ml.",
            33.33,
            "N. Al-Zoubi, J.E. Koundourellis, S. Malamataris. FT-IR and Raman spectroscopic methods for identification and quantitation of orthorhombic and monoclinic paracetamol in powder mixes. «Journal of Pharmaceutical and Biomedical Analysis», 2002.\n" +
                    "\n" +
                    "G. L. Perlovich, Tatyana V. Volkova and Annette Bauer-Brandl. POLYMORPHISM OF PARACETAMOL: Relative stability of the monoclinic and orthorhombic phase revisited by sublimation and solution calorimetry. «Journal of Thermal Analysis and Calorimetry», September, 2007, vol.89.\n" +
                    "\n" +
                    "John F. Kauffman, Linda M. Batykefer, David D. Tuschel. Raman detected differential scanning calorimetry of polymorphic transformations in acetaminophen. «Journal of Pharmaceutical and Biomedical Analysis», 2008.",
            "mg"
    );
    Constituant constituant32 = new Constituant(
            "Acetaminophen/Guaifenesin",
            "",
            "    • Crystal form : orthorhombic.\n" +
                    "    • Space group : P 212121.\n" +
                    "    • Density : 1.2 ± 0.1 g/cm3.\n" +
                    "    • Solubility in water: 5g/100 ml at 25°C.",
            13.33,
            "Alexander A. Bredikhin, and all. Absolute configuration and crystal packing for three chiral drugs prone to spontaneous resolution: Guaifenesin, methocarbamol and mephenesin. «Journal of Molecular Structure», 2008.",
            "mg"
    );
    Constituant constituant33 = new Constituant(
            "Propylene glycol (PG)",
            "",
            "    • Solvant.\n" +
                    "    • Density: 1.038 g/cm3 at 20°C.\n" +
                    "    • Surface tension: 40.1 mN/m at 25°C.",
            125,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Propylene glycol. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 592-594.",
            "mg"
    );
    Constituant constituant34 = new Constituant(
            "Polyethylene glycol (PEG)",
            "PEG 600",
            "    • Solubilating agent.\n" +
                    "    • Average molecular weight: 570- 613 amu.\n" +
                    "    • Density: 1.08 g/cm3.\n" +
                    "    • Surface tension: 44mN/m.",
            350,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Polyethylene Glycol. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.517-522.",
            "mg"
    );
    Constituant constituant35 = new Constituant(
            "Sucrose",
            "60/200",
            "    • Sweetening agent.\n" +
                    "    • Crystalline form.\n" +
                    "    • Density (bulk): 0.93 g/cm3.\n" +
                    "    • Density (tapped): 1.03 g/cm3.\n" +
                    "    • Density (true): 1.6 g/cm3.\n" +
                    "    • Solubility in water at 20°C: 1 in 0.5.\n" +
                    "    • Median particle size: 540µm.\n" +
                    "    • Moisture content: it absorbs up to 1% water.",
            250,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Sucrose. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 703-707.",
            "mg"
    );
    Constituant constituant36 = new Constituant(
            "Sorbitol",
            "70/70",
            "    • Sweetening agent.\n" +
                    "    • Liquid (non crystalling).\n" +
                    "    • pH: 4.5 - 7 for a 10% w/v aqueous solution.\n" +
                    "    • Density (bulk): 0.448 g/cm3.\n" +
                    "    • Density (tapped): 0.400 g/cm3.\n" +
                    "    • Density (true): 1.507 g/cm3.\n" +
                    "    • Moisture content: >60% at 25°C.",
            125,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Sorbitol. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.679-682.",
            "mg"
    );
    Constituant constituant37 = new Constituant(
            "Sucralose",
            "",
            "    • Sweetening agent.\n" +
                    "    • pH: 5 – 6 for a 10% w/v aqueous solution at 20°C.\n" +
                    "    • Density (bulk): 0.35 g/cm3.\n" +
                    "    • Density (tapped): 0.62 g/cm3.\n" +
                    "    • Density (true): 1.63 g/cm3.\n" +
                    "    • Particle size distribution: 90%<12µm in size.\n" +
                    "    • Viscosity: 0.6 – 3.8 mPa.s.",
            5,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Sucralose. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 701-703.",
            "mg"
    );
    Constituant constituant38 = new Constituant(
            "Citric acid",
            "",
            "    • Preservative\n" +
                    "    • Density: 1.665 g/cm3.\n" +
                    "    • Solubility in water 133g/100ml at 20°C.\n" +
                    "    • Viscosity: 6.5 mPa.s for a 50% w/v aqueous solution at 25°C.",
            0.70,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Citric acid. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 181-183.",
            "mg"
    );
    Constituant constituant39 = new Constituant(
            "Sodium benzoate",
            "",
            "    • Antimicrobial preservative\n" +
                    "    • Density: 1.497- 1.527 g/cm3 at 24°C.\n" +
                    "    • Solubility in water at 20°C: 1 in 1.8.",
            2,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Sodium benzoate. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 627-629.",
            "mg"
    );
    Constituant constituant310 = new Constituant(
            "Sodium carboxy methylcellulose",
            "",
            "",
            2,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe.  Sodium carboxymethylcellulose. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p.118-121.",
            "mg"
    );
    Constituant constituant311 = new Constituant(
            "Natural peppermint flavor #104",
            "",
            "",
            2,
            "",
            "mg"
    );
    Constituant constituant312 = new Constituant(
            "FD&C Blue #1",
            "",
            "",
            0.1,
            "",
            "mg"
    );
    Constituant constituant313 = new Constituant(
            "Water",
            "Purified water",
            "In accordance with the pharmacopeia.",
            0,
            "",
            "QS"
    );
    ArrayList<Constituant> constituants3 = new ArrayList<>();


    Step step31 = new Step("A solution of liquid excipient was prepared using Polyethylene glycol and propylene glycol.");
    Step step32 = new Step("Acetaminophen was dissolved in a solution of liquid excipient base under stirring.");
    Step step33 = new Step("Guaifenesin was added to the acetaminophen solution obtained previously under stirring.");
    Step step34 = new Step("Sodium benzoate, sucralose, citric acid and sorbitol was added successively to 20% of purified water and stirred.");
    Step step35 = new Step("The solution of step 4 was added to the acetaminophen solution.");
    Step step36 = new Step("Sodium carboxy methylcellulose soaked in 5% of purified water was prepared then added and stirred.");
    Step step37 = new Step("Peppermint flavor, FD&C blue #1 was added to the mixture.");
    Step step38 = new Step("The volume was made with purified water and filtered.");
    Step step39 = new Step("The final solution was filled in bottles.");
    ArrayList<Step> steps3 = new ArrayList<>();

    Formula formula3 = new Formula("","Injection", "Description", constituants3, steps3);

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

        /********************************** form 1 ***************************************/

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

        /*************************************** form 2 **********************************************/

        steps2.add(step21);
        steps2.add(step22);
        steps2.add(step23);
        steps2.add(step24);

        constituants2.add(constituant21);
        constituants2.add(constituant22);
        constituants2.add(constituant23);
        constituants2.add(constituant24);
        constituants2.add(constituant25);

        process2.setFormula(formula2);

        processes2.add(process2);
        medicForm2.setProcessArrayList(processes2);

        /************************************************* form 3 ***********************************************/

        steps3.add(step31);
        steps3.add(step32);
        steps3.add(step33);
        steps3.add(step34);
        steps3.add(step35);
        steps3.add(step36);
        steps3.add(step37);
        steps3.add(step38);
        steps3.add(step39);

        constituants3.add(constituant31);
        constituants3.add(constituant32);
        constituants3.add(constituant33);
        constituants3.add(constituant34);
        constituants3.add(constituant35);
        constituants3.add(constituant36);
        constituants3.add(constituant37);
        constituants3.add(constituant38);
        constituants3.add(constituant39);
        constituants3.add(constituant310);
        constituants3.add(constituant311);
        constituants3.add(constituant312);
        constituants3.add(constituant313);

        process3.setFormula(formula3);

        processes3.add(process3);
        medicForm3.setProcessArrayList(processes3);




        medicForms.add(medicForm);
        medicForms.add(medicForm2);
        medicForms.add(medicForm3);
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
