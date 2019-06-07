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
import com.medic.Models.Equipment;
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

    Medic medic1 = new Medic("Cetrizine", "Very long medic description text");
    ArrayList<MedicForm> medic1Forms = new ArrayList<>();

    /**************************************** Medicament 1 form 1 ************************************/

    MedicForm medic1Form1 = new MedicForm("Tablet", "Very long medic form description text");
    ArrayList<Process> processes11 = new ArrayList<>();

    /********************************************* Medicament 1 form 1 process 1 ********************************/

    Process process111 = new Process("Direct compression", "Very long process description text");


    /********************************************** Medicament 1 form 1 process formula *********************************/
    Constituant constituant1111 = new Constituant(
            "Cetirizine dihydrochloride",
            "",
            "    • polymorphic form: form I: dextrorotatory dihydrochloride salt.\n" +
                    "    • Purity: ≥98%.",
            15,
            "JOGA Rajender, REDDY Manne satyanarayana, SRINIVASAN Thirumalai Rajan, UPPALA Venkata Bhaskara Rao, VADDADI Pattabhi Ramayya. Polymorphic forms of dihydrochloride salts of citrizine and processes for preparation thereof.  World Intellectual Property Organization. Brevet WO 2004/050647 A2, June 17, 2004.",
            "g"
    );
    Constituant constituant1112 = new Constituant(
            "Mannitol",
            "Pearlitol SD 200",
            "    • Sweetening agent.\n" +
                    "    • Density (bulk): 0.43 g/ cm 3.\n" +
                    "    • Density (tapped): 0.734 g/ cm 3.\n" +
                    "    • Density ( true): 1.514 g/ cm 3.\n" +
                    "    • Median size: 88 µm.\n" +
                    "    • Specific surface area: 0.37-0.39m2/g.",
            462.8,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Mannitol. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 424-428.",
            "g"
    );
    Constituant constituant1113 = new Constituant(
            "Crospovidone",
            "",
            "    • Disintegrant.( binder)\n" +
                    "    • PH: 5-8 for a 1% w/v aqueous slurry.\n" +
                    "    • Density (true): 1.22 g/ cm 3.\n" +
                    "    • Moisture content: <60%.",
            24,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe.Crospovidone. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.208-210.",
            "g"
    );
    Constituant constituant1114 = new Constituant(
            "Microcrystalline cellulose",
            "Avicel PH 102",
            "    • Diluents.\n" +
                    "    • Density (true): 1.42-1.46 g/ cm 3.\n" +
                    "    • Density (bulk) : 0 .28-0.33 g/ cm 3.\n" +
                    "    • Specific surface area: 1.21-1.3 m2/g.\n" +
                    "    • Moisture content: <5%.\n" +
                    "    • Mean particle size: 100 µm.\n" +
                    "    • Particle size distribution : \n" +
                    "-D10 : 15-55.\n" +
                    "-D50 : 80-140.\n" +
                    "               -D90 : 170-183.",
            45,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Cellulose, Microcrystalline. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.129-133.\n" +
                    "Techenical data sheet of: Microcystalline cellulose Avicel PH 102. FMC Corporation. Available on:\n" +
                    "http://www.signetchem.com/Content/Upload/z99iA7AvicelPH102NFspec.pdf",
            "g"
    );
    Constituant constituant1115 = new Constituant(
            "Acesulfame potassium",
            "",
            "    • Sweetening agent.\n" +
                    "    • PH: 5.5-7.5 for a 1% w/v aqueous solution.\n" +
                    "    • Density (bulk): 1.04 g/ cm 3.\n" +
                    "    • Density (tapped): 1.28 g/ cm 3.\n" +
                    "    • Flowability: 19% (carr compressibility index).",
            27,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Acesulfame Potassium. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 3-5.",
            "g"
    );
    Constituant constituant1116 = new Constituant(
            "Colloidal silicon dioxide",
            "",
            "    • Glidant.\n" +
                    "    • PH: 3.8-4.2 for a 4% w/v aqueous dispersion.\n" +
                    "    • Density (bulk): 0.029-0.042 g/ cm 3.\n" +
                    "    • Particle size distribution: primary particle size is 7-16µm.\n" +
                    "    • Specific surface area: 100-400 m2 /g.",
            3,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe.Colloidal silicon dioxide. In Handbook of pharmaceutical excipients,6e ed. London: The pharmaceutical press, 2009, p. 185-188.",
            "g"
    );
    Constituant constituant1117 = new Constituant(
            "Cooling flavor",
            "",
            "    • Flavoring agent.",
            0.8,
            "",
            "g"
    );
    Constituant constituant1118 = new Constituant(
            "Peppermint flavor",
            "",
            "    • Flavoring agent.",
            3,
            "",
            "g"
    );
    Constituant constituant1119 = new Constituant(
            "Talc",
            "",
            "    • Lubricant.\n" +
                    "    • PH: 7-10.\n" +
                    "    • Hardness (mohs): 1-1.5.!!\n" +
                    "    • Relative humidity: up to about 90% at 25°C.\n" +
                    "    • Specific surface area: 2.41-2.42 m2/g.",
            12,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Talc. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 728-731.",
            "g"
    );
    Constituant constituant11110 = new Constituant(
            "Magnesium stearate",
            "",
            "    • Lubricant.\n" +
                    "    • Density (bulk): 0.159 g/ cm 3.\n" +
                    "    • Density (tapped): 0.286 g/ cm 3.\n" +
                    "    • Density (true):1.092 g/ cm 3.\n" +
                    "    •  Speacific surface area: 1.6-14.8 m2/g.",
            7.5,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe.Magnesium stearate. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.404-407.",
            "g"
    );
    ArrayList<Constituant> constituants111 = new ArrayList<>();

    Equipment e1111 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2Fcetrizine.Tablet.Direct%20compression%2FStep1.gif?alt=media&token=02ec0aa8-d42d-4d21-a285-2ce1d0421814", "Aperture size:250µm");
    Step step1111 = new Step("Cetirizine dihydrochloride, Crospovidone, Microcrystalline cellulose, Cooling flavor, Peppermint flavor and Acesulfame potassium were sifted.", e1111);
    Equipment e1112 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2Fcetrizine.Tablet.Direct%20compression%2FStep2.gif?alt=media&token=56eaac22-c478-47d7-ae03-9c89910cc952", "Aperture size:400µm");
    Step step1112 = new Step("Mannitol and Colloidal silicon dioxide were sifted.", e1112);
    Equipment e1113 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2Fcetrizine.Tablet.Direct%20compression%2FStep3.gif?alt=media&token=e9d1425c-4028-43a6-9521-39a8f9be1d4b", "Mixing time: 20 min");
    Step step1113 = new Step("The sifted ingredients of step 1 and 2 were blended.", e1113);
    Equipment e1114 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2Fcetrizine.Tablet.Direct%20compression%2FStep4.gif?alt=media&token=f30e3547-11ad-4e03-a735-e5b8401f429d", "Aperture size: 250µm.");
    Step step1114 = new Step("Talc and Magnesium stearate were sifted.", e1114);
    Equipment e1115 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2Fcetrizine.Tablet.Direct%20compression%2FStep5.gif?alt=media&token=1b61f592-5113-4697-aa31-dcb95d6ddb1c", "Mixing time: 5 min");
    Step step1115 = new Step("Add the sifted ingredients of step 4 to the double cone blender, and blended.", e1115);
    Equipment e1116 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2Fcetrizine.Tablet.Direct%20compression%2FStep6.gif?alt=media&token=daaa387c-9e7f-4114-861a-71a5f939a830", "diameter of punches: 10mm");
    Step step1116 = new Step("The lubricated blend of step 4 was compressed into tablets. ", e1116);
    ArrayList<Step> steps111 = new ArrayList<>();

    Formula formula111 = new Formula("", "", "", constituants111, steps111,
            "Average weight:\n" +
                    "   401mg.\n" +
                    "Hardness:\n" +
                    "   6-7 Kp.\n" +
                    "Disintegration time:\n" +
                    "   18-25 s.\n" +
                    "Friability:\n" +
                    "   0.58%.\n");

    /**********************************************************************************************************************/


    /************************************** Medicament 2 ****************************************************/

    Medic medic2 = new Medic("Fexofenadine", "Very long medic description text");
    ArrayList<MedicForm> medic2Forms = new ArrayList<>();

    /**************************************** Medicament 2 form 1 ************************************/

    MedicForm medic2Form1 = new MedicForm("Tablet", "Very long medic form description text");
    ArrayList<Process> processes21 = new ArrayList<>();

    /********************************************* Medicament 2 form 1 process 1 ********************************/

    Process process211 = new Process("Wet granulation", "Very long process description text");


    /********************************************** Medicament 2 form 1 process formula *********************************/
    Constituant constituant2111 = new Constituant(
            "Fexofenadine ",
            "",
            "    • Fexofenadine hydrochloride.\n" +
                    "    • Particle size: 90% of particles are about 25µm of diameter.",
            30,
            "Dharmaraj Ramachandra Rao and al. FEXOFENADINE POLYMORPHS AND PROCESSES OF PREPARING THE SAME. United States Patent. Brevet US 8247434 B2, August 21, 2012.",
            "% w/w"
    );
    Constituant constituant2112 = new Constituant(
            "Xylitol ",
            "300",
            "    • Thermomelting binding agent.\n" +
                    "    • PH: 5-7 for a10% w/v aqueous solution.\n" +
                    "    • Density (true): 1.52 g/cm3.\n" +
                    "    • Relative humidity: 52%.\n" +
                    "    •  Moisture content: 0.1% w/w.",
            40,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Xylitol. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 786-789.",
            "% w/w"
    );
    Constituant constituant2113 = new Constituant(
            "Polyvinyl pyrrolidone",
            "PVP K30",
            "    • Binder.\n" +
                    "    • PH: 3-7 for a5% w/v aqueous  solution.\n" +
                    "    • Density (true): 1.18 g/cm3.\n" +
                    "    • Particle size distribution : 90%>50µm, 50%>100µm, 5%>20µm.\n" +
                    "    • Moisture content : ≤5%.\n" +
                    "    • Density (bulk) : 4-6 g/cm3.",
            1.66,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Povidone. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 581-585.",
            "% w/w"
    );
    Constituant constituant2114 = new Constituant(
            "Sodium lauryl sulfate",
            "",
            "    • Surfactant or weeting agent.\n" +
                    "    • PH: 7-9.5 for a 1% w/v aqueous solution.\n" +
                    "    • Density: 1.07 g/cm3 at 20°C.\n" +
                    "    • HLB: 40.\n" +
                    "    • Critical micelle concentration: 8.2 mmol/l at 20°C.\n" +
                    "    • Surface tension: 25.2 mN/m for a 0.05% w/v aqueous solution at 30°C.",
            0.66,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe.  Sodium Laury Sulfate. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 651-653.",
            "% w/w"
    );
    Constituant constituant2115 = new Constituant(
            "Microcrystalline cellulose",
            "Avicel PH 200",
            "    • Density (bulk): 0.337 g/cm3.\n" +
                    "    • Density (tapped) : 0.478 g/cm3.\n" +
                    "    • Density (true) : 1.512-1.668 g/cm3.\n" +
                    "    • Moisture content: ≤5%.\n" +
                    "    • Particle size distribution: 180 µm.\n" +
                    "    • Specific surface area: 0.78-1.18 m2/g.",
            20,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Cellulose, Microcrystalline. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.129-133.\n" +
                    "Techenical data sheet of: Microcystalline cellulose Avicel PH 200. FMC Corporation. Available on: http://www.signetchem.com/Content/Upload/9B97L9SpecificationAvicelPH200LM.PDF",
            "% w/w"
    );
    Constituant constituant2116 = new Constituant(
            "Colloidal silicon dioxide",
            "",
            "    • Dispersing agent.\n" +
                    "    • PH: 3.8-4.2 for 4% w/v aqueous dispresion.\n" +
                    "    • Density(bulk) : 0.029-0.042 g/cm3.\n" +
                    "    • Particle size distribution: primary particle size is 7-16µm.\n" +
                    "    • Specific surface area: 100-400 m2 /g.\n" +
                    "    • Moisture content: ≤1.5%. ",
            0.66,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe.Colloidal silicon dioxide. In Handbook of pharmaceutical excipients,6e ed. London: The pharmaceutical press, 2009, p. 185-188.",
            "% w/w"
    );
    Constituant constituant2117 = new Constituant(
            "Sodium starch glycolate",
            "",
            "     • Disintegrant.\n" +
                    "    • Particle size distribution: 100% of particle < 106µm.\n" +
                    "    • Viscosity (dynamic): ≤200mPa.s for a 4% w/v aqueous dispersion.",
            0.5,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe.  Sodium Starch Glycolate. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 663-666.",
            "% w/w"
    );
    Constituant constituant2118 = new Constituant(
            "Talce",
            "",
            "    • Lubricant.\n" +
                    "    • PH: 7-10 for a20% w/v aqueous dispersion.\n" +
                    "    • Relative humidity: Up to about 90% at 25%.\n" +
                    "    • Specific surface area: 2.41-2.42 m2/g.",
            4,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Talc. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 728-731.",
            "% w/w"
    );
    Constituant constituant2119 = new Constituant(
            "Magnesium stearate",
            "",
            "    • Lubricant.\n" +
                    "    • Density (bulk) : 0 .159 g/cm3.\n" +
                    "    • Density (tapped): 0 .286 g/cm3.\n" +
                    "    • Densit (true) : 1.092 g/cm3.\n" +
                    "    • Specific surface area: 1.6 – 14.8 m²/g.",
            1.5,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe.Magnesium stearate. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.404-407.",
            "% w/w"
    );
    ArrayList<Constituant> constituants211 = new ArrayList<>();

    Equipment e2111 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2FFexofenadine.Tablet.Wet%20granulation%2FStep1.gif?alt=media&token=3ea1914e-d1e0-4677-bb78-ca761ea28ddc", "Aperture size: 420µm");
    Step step2111 = new Step("Sieving the xylitol, pvp and sodium lauryl sulfate. ", e2111);
    Equipment e2112 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2FFexofenadine.Tablet.Wet%20granulation%2FStep2.gif?alt=media&token=03f8b5bb-7861-4c8d-b581-1a37b394122b", "");
    Step step2112 = new Step("Mixing the siefted ingredients.", e2112);
    Equipment e2113 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2FFexofenadine.Tablet.Wet%20granulation%2FStep3.gif?alt=media&token=85e562af-8252-488b-ba9b-7fda3063d016", "");
    Step step2113 = new Step("Mixing the blanded ingredients with fexofenadine hydrochloride.", e2113);
    Equipment e2114 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2FFexofenadine.Tablet.Wet%20granulation%2FStep4.png?alt=media&token=f5d16727-631f-4479-a512-308e1358bfd6", "Temperature: 75-85°C.");
    Step step2114 = new Step("Heating the blend using water bath.", e2114);
    Equipment e2115 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2FFexofenadine.Tablet.Wet%20granulation%2FStep5.gif?alt=media&token=64a8473c-22b1-463c-bd8a-0da139e7451d", "");
    Step step2115 = new Step("Mixing continuously the heated blend till a granular mass was obtained.", e2115);
    Equipment e2116 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2FFexofenadine.Tablet.Wet%20granulation%2FStep6.png?alt=media&token=6a42f197-1dc8-4df0-a357-c52607d33299", "Temperature: 70°C.");
    Step step2116 = new Step("Cooling hot granulated with stirring.", e2116);
    Equipment e2117 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2FFexofenadine.Tablet.Wet%20granulation%2FStep7.gif?alt=media&token=403369b1-11fc-4c30-a5bc-f979ba3a96ec", "Aperture size: 2380 µm.");
    Step step2117 = new Step("Sieving", e2117);
    Equipment e2118 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2FFexofenadine.Tablet.Wet%20granulation%2FStep8.png?alt=media&token=65b9a464-976e-4267-9bec-d35c3b9827df", "Cooling time: 7 hours");
    Step step2118 = new Step("Cooling the granules.", e2118);
    Equipment e2119 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2FFexofenadine.Tablet.Wet%20granulation%2FStep9.gif?alt=media&token=5a2e5c0a-fd7b-4d1f-937e-f1f3c3e49d03", "Aperture size: 841 µm.");
    Step step2119 = new Step("Sieving the cooled granules.", e2119);
    Equipment e21110 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2FFexofenadine.Tablet.Wet%20granulation%2FStep10.gif?alt=media&token=2ed9a41a-106e-4238-b1f6-c4ed15e15876", "");
    Step step21110 = new Step("Blending the granules with avicel PH 200, sodium lauryl sulfate, colloidal silicon dioxide, sodium starch glycolate and talc.", e21110);
    Equipment e21111 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2FFexofenadine.Tablet.Wet%20granulation%2FStep11.gif?alt=media&token=a164a3af-1d38-4a1d-81b0-e48406f27402", "");
    Step step21111 = new Step("Lubrification.", e21111);
    Equipment e21112 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e" +
            ".appspot.com/o/MedicalClasses%2FAllergology%2FFexofenadine.Tablet.Wet%20granulation%2FStep12.gif?alt=media&token=f7fcdd83-9ae5-463e-a65a-cef1084a7aee", "");
    Step step21112 = new Step("Compression", e21112);
    Equipment e21113 = new Equipment("https://firebasestorage.googleapis.com/v0/b/medic-ee57e." +
            "appspot.com/o/MedicalClasses%2FAllergology%2FFexofenadine.Tablet.Wet%20granulation%2FStep13.gif?alt=media&token=ddb14728-82c5-4b7e-981b-2dd411444557", "");
    Step step21113 = new Step("Coating the core tablets.", e21113);
    ArrayList<Step> steps211 = new ArrayList<>();

    Formula formula211 = new Formula("", "", "", constituants211, steps211,
            "");

    /**********************************************************************************************************************/


    /************************************** Medicament 3 ****************************************************/

    Medic medic3 = new Medic("Mometasone furoate", "Very long medic description text");
    ArrayList<MedicForm> medic3Forms = new ArrayList<>();

    /**************************************** Medicament 1 form 1 ************************************/

    MedicForm medic3Form1 = new MedicForm("Suspension", "Very long medic form description text");
    ArrayList<Process> processes31 = new ArrayList<>();

    /********************************************* Medicament 1 form 1 process 1 ********************************/

    Process process311 = new Process("", "Very long process description text");


    /********************************************** Medicament 1 form 1 process formula *********************************/
    Constituant constituant3111 = new Constituant(
            "Mometasone furoate",
            "",
            "    • Mometasone furoate Monohydrate\n" +
                    "    • Crystal form : triclinic.\n" +
                    "    • Space group : P1.",
            6.0,
            "YUEN, Pui-Ho and al. MOMETASONE FUROATE MONOHYDRATE, PROCESS FOR MAKING SAME AND PHARMACEUTICAL COMPOSITIONS. World Intellectual Property Organization, Patent WO92/04365 (A1), 19 March 1992.",
            "g/12.0 kg"
    );
    Constituant constituant3112 = new Constituant(
            "Avicel RC 591",
            "",
            "    • pH: 6-8.\n" +
                    "    • LOD: no more than 6%.\n" +
                    "    • Viscosity: in a solution of 1.2% solids: 39 – 91 cps.",
            240.0,
            "Techenical data sheet of: Microcystalline cellulose Avicel RC 591. FMC Corporation. Available on: WWW.FMCHEALTHANDNUTRITION.COM ",
            "g/12.0 kg"
    );
    Constituant constituant3113 = new Constituant(
            "Glycerin",
            "",
            "    • Density :\n" +
                    "1.2656g/cm3 at 15°C;\n" +
                    "1.2636g/cm3 at 20°C; 1.2620g/cm3 at 25°C.\n" +
                    "    • Surface tension: 63.4mN/m at 20°C.\n" +
                    "    • Viscosity of a 5 % w/w aqueous glycerin solution at 20°C: 1.143 mPa.s.",
            252.0,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Glycerin. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 283-286.",
            "g/12.0 kg"
    );
    Constituant constituant3114 = new Constituant(
            "Citric acid",
            "",
            "    • Density : 1.542g/cm3.\n" +
                    "    • Solubility: Soluble 1 in 1.5 parts of ethanol (95%)",
            24.0,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Citric acid. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 181-183.",
            "g/12.0 kg"
    );
    Constituant constituant3115 = new Constituant(
            "Sodium citrate ",
            "80",
            "    • pH = 6.0–8.0 for a 5% w/v aqueous solution.\n" +
                    "    • Viscosity: 425 mPa.s.\n" +
                    "    • Surface tension at 20°C: 42.5 mN/m.\n" +
                    "    • Moisture content: 3%",
            1.2,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Sodium citrate. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 640-642.",
            "g/12.0 kg"
    );
    Constituant constituant3116 = new Constituant(
            "Polysorbate",
            "",
            "    • pH = 6.0–8.0 for a 5% w/v aqueous solution.\n" +
                    "    • Viscosity: 425 mPa.s.\n" +
                    "    • Surface tension at 20°C: 42.5 mN/m.\n" +
                    "    • Moisture content: 3%",
            2.4,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Polysorbate. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 549-553.",
            "g/12.0 kg"
    );
    Constituant constituant3117 = new Constituant(
            "Benzalkonium chloride",
            "",
            "    • pH = 5–8 for a 10% w/v aqueous solution.\n" +
                    "    • Density ≈ 0.98g/cm3 at 20°C.",
            2.4,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Benzalkonium chloride. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.56-58.",
            "g/12.0 kg"
    );
    Constituant constituant3118 = new Constituant(
            "Phenyl ethyl alcohol",
            "",
            "Antimicrobial preservative.",
            30,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Phenylethyl alcohol. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.490-491.",
            "g/12.0 kg"
    );
    Constituant constituant3119 = new Constituant(
            "Water",
            "",
            "",
            12,
            "",
            "g/12.0 kg"
    );
    ArrayList<Constituant> constituants311 = new ArrayList<>();

    Step step3111 = new Step("Dispersing Avicel RC 591 in 6 kg of water.");
    Step step3112 = new Step("Adding glycerin.");
    Step step3113 = new Step("Dissolving in 240 ml of water the citric acid and sodium citrate.");
    Step step3114 = new Step("The solution of step 3 was added to the solution of step 1 under mixing.");
    Step step3115 = new Step("Separately, dissolving polysorbate 80 in approximately 400 ml of purified water with stirring.");
    Step step3116 = new Step("Dispersing Mometasone furoate in the aqueous polysorbate solution.");
    Step step3117 = new Step("Adding the slurry of step 6 to the avicel- glycerin- citric acid mixture.");
    Step step3118 = new Step("Dissolving benzalkonium chloride and phenylethyl alcohol in purified water.");
    Step step3119 = new Step("Add the solution of step 8 to the suspension mixture with stirring.");
    Step step31110 = new Step("The suspension was brought to 12 kg with purified water with mixing.");
    ArrayList<Step> steps311 = new ArrayList<>();

    Formula formula311 = new Formula("", "", "", constituants311, steps311,
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
        steps111.add(step1112);
        steps111.add(step1113);
        steps111.add(step1114);
        steps111.add(step1115);
        steps111.add(step1116);

        constituants111.add(constituant1111);
        constituants111.add(constituant1112);
        constituants111.add(constituant1113);
        constituants111.add(constituant1114);
        constituants111.add(constituant1115);
        constituants111.add(constituant1116);
        constituants111.add(constituant1117);
        constituants111.add(constituant1118);
        constituants111.add(constituant1119);
        constituants111.add(constituant11110);

        process111.setFormula(formula111);

        processes11.add(process111);
        processes11.add(new Process("Wet granulation"));
        processes11.add(new Process("Dry granulation"));
        processes11.add(new Process("Others"));
        medic1Form1.setProcessArrayList(processes11);


        medic1Forms.add(medic1Form1);
        medic1Forms.add(new MedicForm("Capsules"));
        medic1Forms.add(new MedicForm("Granules"));
        medic1Forms.add(new MedicForm("Powder"));
        medic1Forms.add(new MedicForm("Solution"));
        medic1Forms.add(new MedicForm("Suspension"));
        medic1Forms.add(new MedicForm("Syrup"));
        medic1Forms.add(new MedicForm("Emulsion"));
        medic1Forms.add(new MedicForm("Drop"));
        medic1Forms.add(new MedicForm("Cream"));
        medic1Forms.add(new MedicForm("Gel"));
        medic1Forms.add(new MedicForm("Suppository"));
        medic1Forms.add(new MedicForm("Injection"));
        medic1.setMedicFormArrayList(medic1Forms);

        /********************************** form 1 ***************************************/


        steps211.add(step2111);
        steps211.add(step2112);
        steps211.add(step2113);
        steps211.add(step2114);
        steps211.add(step2115);
        steps211.add(step2116);
        steps211.add(step2117);
        steps211.add(step2118);
        steps211.add(step2119);
        steps211.add(step21110);
        steps211.add(step21111);
        steps211.add(step21112);
        steps211.add(step21113);

        constituants211.add(constituant2111);
        constituants211.add(constituant2112);
        constituants211.add(constituant2113);
        constituants211.add(constituant2114);
        constituants211.add(constituant2115);
        constituants211.add(constituant2116);
        constituants211.add(constituant2117);
        constituants211.add(constituant2118);
        constituants211.add(constituant2119);

        process211.setFormula(formula211);

        processes21.add(process211);
        processes21.add(new Process("Dry granulation"));
        processes21.add(new Process("Direct compression"));
        processes21.add(new Process("Others"));
        medic2Form1.setProcessArrayList(processes21);


        medic2Forms.add(medic2Form1);
        medic2Forms.add(new MedicForm("Capsules"));
        medic2Forms.add(new MedicForm("Granules"));
        medic2Forms.add(new MedicForm("Powder"));
        medic2Forms.add(new MedicForm("Solution"));
        medic2Forms.add(new MedicForm("Suspension"));
        medic2Forms.add(new MedicForm("Syrup"));
        medic2Forms.add(new MedicForm("Emulsion"));
        medic2Forms.add(new MedicForm("Drop"));
        medic2Forms.add(new MedicForm("Cream"));
        medic2Forms.add(new MedicForm("Gel"));
        medic2Forms.add(new MedicForm("Suppository"));
        medic2Forms.add(new MedicForm("Injection"));
        medic2.setMedicFormArrayList(medic2Forms);


        /********************************** form 1 ***************************************/


        steps311.add(step3111);
        steps311.add(step3112);
        steps311.add(step3113);
        steps311.add(step3114);
        steps311.add(step3115);
        steps311.add(step3116);
        steps311.add(step3117);
        steps311.add(step3118);
        steps311.add(step3119);
        steps311.add(step31110);

        constituants311.add(constituant3111);
        constituants311.add(constituant3112);
        constituants311.add(constituant3113);
        constituants311.add(constituant3114);
        constituants311.add(constituant3115);
        constituants311.add(constituant3116);
        constituants311.add(constituant3117);
        constituants311.add(constituant3118);
        constituants311.add(constituant3119);


        process311.setFormula(formula311);

        processes31.add(process311);
        medic3Form1.setProcessArrayList(processes31);


        medic3Forms.add(medic3Form1);
        medic3Forms.add(new MedicForm("Capsules"));
        medic3Forms.add(new MedicForm("Granules"));
        medic3Forms.add(new MedicForm("Powder"));
        medic3Forms.add(new MedicForm("Solution"));
        medic3Forms.add(new MedicForm("Tablet"));
        medic3Forms.add(new MedicForm("Syrup"));
        medic3Forms.add(new MedicForm("Emulsion"));
        medic3Forms.add(new MedicForm("Drop"));
        medic3Forms.add(new MedicForm("Cream"));
        medic3Forms.add(new MedicForm("Gel"));
        medic3Forms.add(new MedicForm("Suppository"));
        medic3Forms.add(new MedicForm("Injection"));
        medic3.setMedicFormArrayList(medic3Forms);


        medics.add(medic1);
        medics.add(medic2);
        medics.add(medic3);


        Random rand = new Random();
        int n = rand.nextInt(50000000);
        medicalClass1 = new MedicalClass(String.valueOf(n), "Allergology", "Very long description text");

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
