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

    /***********************  Medical class 1 ***************************************************************/


    MedicalClass medicalClass1 = null;

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

    /********************************************* Medicament 1 form 1 process 1 ********************************/

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

    Formula formula = new Formula("", "Direct compression", "Description", constituants, steps,
            "-Acetamenophen:\n" +
                    "  75% by weight\n" +
                    "-Average tablet hardness:\n" +
                    "  6.5 Kp\n" +
                    "-Dissolution time: ( 900 ml phosphate buffer pH=5.8 USP23)\n" +
                    "  30 min\n");

    /**********************************************************************************************************************/


    /********************************************* Medicament 1 form 2 process 1 ********************************/

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

    Formula formula2 = new Formula("", "", "Description", constituants2, steps2, "");

    /**********************************************************************************************************************/


    /********************************************* Medicament 1 form 3 process 1 ********************************/

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

    Formula formula3 = new Formula("", "", "Description", constituants3, steps3,
            "-pH of the liquid excipient base: \n" +
                    "  4.5 - 6.5\n" +
                    "-Viscosity at 25±3°C: (Measured with Brookfield viscometer spindle N°1 (LV1) at 40 RPM )\n" +
                    "  80- 140 cPs\n");

    /**********************************************************************************************************************/



    /************************************ Medicament 2 *************************************************************/

    Medic medic2 = new Medic("Ibuprofen", "Very long medic description text");

    /*************************************** Medicament 2 forms *******************************************************/
    MedicForm medic2Form = new MedicForm("Tablet", "Very long medic form description text");


    /********************************************* Medicament 2 form 1 process ********************************/

    Process process21 = new Process("Wet granulation", "Very long process description text");


    Process process22 = new Process("Direct compression", "Very long process description text");

    Process process23 = new Process("Dry granulation", "Very long process description text");

    Process process24 = new Process("Others", "Very long process description text");
    ArrayList<Process> processes21 = new ArrayList<>();


    /********************************************** Medicament 2 form 1 process formula *********************************/
    Constituant constituant211 = new Constituant(
            "S –(+) – ibuprofen",
            "In accordance with BP 1988 and BP Add.89.",
            "    • Crystal form: monoclinic\n" +
                    "    • Space group: P21/c .\n" +
                    "    • Density: 1.098 g/cm3.",
            51,
            "Günther, Leising. Physical Aspects of Dexibuprofen and\n" +
                    "Racemic Ibuprofen. Roland Resel, Franz Stelzer, Stefan Tasch, Arthur Lanziner, and Gerhard Hantich. «The Journal of Clinical Pharmacology», January, 1997.",
            "%"
    );
    Constituant constituant212 = new Constituant(
            "Potato starch",
            "In accordance with Ph.Eur. , 2nd Ed.",
            "    • Density (bulk): between 0 .56 and 0.82 g/cm3.\n" +
                    "    • Density (tapped): between 0 .8 and 0.9 g/cm3.\n" +
                    "    • Moisture content : 18%.\n" +
                    "    • Particle average size : 46 µm.",
            6,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Starch. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.685-691.",
            "%"
    );
    Constituant constituant213 = new Constituant(
            "Lactose",
            "",
            "In accordance with Ph.Eur. , 2nd Ed.",
            6.8,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Lactose, Monohydrate. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 364-369.",
            "%"
    );
    Constituant constituant214 = new Constituant(
            "Microcrystalline cellulose",
            "AVICEL PH 101",
            "    • Diluent.\n" +
                    "    •  Density (Bulk): 0 .32 g/cm3.\n" +
                    "    • Density (tapped): 0 .45 g/cm3.\n" +
                    "    • Density (true): between 1.512 and 1.668 g/cm 3.\n" +
                    "    • Specific surface area: 1.06 – 1.12 m²/g.\n" +
                    "    • Particule size : 50µm.\n" +
                    "    • Moisture content ≤5.0%.",
            6.83,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Cellulose, Microcrystalline. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.129-133.",
            "%"
    );
    Constituant constituant215 = new Constituant(
            "Croscarmellose sodium",
            "AC-Di-Sol",
            "    • Desintegrant.\n" +
                    "    • Density (bulk): 0 .529 g/cm3.\n" +
                    "    • Density (tapped) : 0 .819 g/cm3.\n" +
                    "    • Density (true): 1.543 g/cm3.\n" +
                    "    • Specific surface area: 0.81 – 0.83 m²/g.\n" +
                    "    • Particle size distribution: no more than 2% retained on a 73.7 µm mesh and no more than 10% retained on a 44.5 µm mesh.",
            1,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Croscarmellose Sodium. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 206-208.",
            "%"
    );
    Constituant constituant216 = new Constituant(
            "Gelatin",
            "In accordance with Ph.Eur. , 2nd Ed.",
            "    • Binder.\n" +
                    "    • Moisture content : 9-11%.",
            1,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Gelatin. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.278-281.",
            "%"
    );
    Constituant constituant217 = new Constituant(
            "Microcrystalline cellulose",
            "AVICEL PH 102",
            "    • Diluent.\n" +
                    "    • Density (true): between 1.420 and 1.460 g/cm3.\n" +
                    "    • Specific surface area: 1.21 – 1.30 m²/g.\n" +
                    "    • Particule size : 100µm.\n" +
                    "    • Moisture content ≤5.0%.",
            25.97,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Cellulose, Microcrystalline. In Handbook of pharmaceutical excipients, 6e ed. London: The Pharmaceutical Press, 2009, p.129-133.\n" +
                    "Techenical data sheet of: Microcystalline cellulose Avicel PH 102. FMC Corporation. Available on:\n" +
                    "http://www.signetchem.com/Content/Upload/z99iA7AvicelPH102NFspec.pdf",
            "%"
    );
    Constituant constituant218 = new Constituant(
            "Croscarmellose sodium",
            "AC-Di-Sol",
            "    • Disintegrant.\n" +
                    "    • Density (bulk): 0 .529 g/cm3.\n" +
                    "    • Density (tapped) : 0 .819 g/cm3.\n" +
                    "    • Density (true): 1.543 g/cm3.\n" +
                    "    • Specific surface area: 0.81 – 0.83 m²/g.\n" +
                    "    • Particle size distribution: no more than 2% retained on a 73.7 µm mesh and no more than 10% retained on a 44.5 µm mesh.",
            1,
            "",
            "%"
    );
    Constituant constituant219 = new Constituant(
            "Colloidal silica",
            "AEROSIL 200",
            "    • Lubricant or glidant.\n" +
                    "    • Specific surface area: 200 ±25 m2 /g.\n" +
                    "    • Density (bulk): 0.029- 0.042 g/cm3.\n" +
                    "    • Density (tapped):0.05 g/cm3.\n" +
                    "    • Moisture content: ≤1.5%. ",
            0.085,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Colloidal Silicon Dioxide. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 185-188.",
            "%"
    );
    Constituant constituant2110 = new Constituant(
            "Hydroxypropyl-methylcellulose",
            "Methocel E5 Premium LV",
            "    • Density (bulk): 0 .341 g/cm3.\n" +
                    "    • Density (tapped) : 0 .557 g/cm3.\n" +
                    "    • Density (true): 1.326 g/cm3.\n" +
                    "    • Nominal viscosity: 5 mPa.s",
            5,
            "Marian E Quinn, Paul J Sheskey Raymond C Rowe. Hypromellose. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 326-329.",
            "%"
    );
    Constituant constituant2111 = new Constituant(
            "Purified water",
            "",
            "n accordance with the Pharmacopea.",
            95,
            "",
            "%"
    );
    ArrayList<Constituant> constituants21 = new ArrayList<>();


    Step step211 = new Step("Mixture of the constituents of:\n" +
            "    • S -(+)- ibuprofen\n" +
            "    • Potato starch\n" +
            "    • Lactose\n" +
            "    • 6.83 % w/w Microcrystalline cellulose Avicel PH 101 \n" +
            "    • 1% w/w Croscarmellose sodium.");
    Step step212 = new Step("Addition of the aqueous solution of “gelatin” to the mixture.");
    Step step213 = new Step("Granulation.");
    Step step214 = new Step("Sieving (sieve aperture size 1.6mm).");
    Step step215 = new Step("Drying");
    Step step216 = new Step("Addition of the constituents of:\n" +
            "    • 25.97% w/w Microcrystalline cellulose Avicel PH 102\n" +
            "    • 1% w/w Croscarmellose sodium \n" +
            "    • Colloidal silica.\n" +
            "With sieved and dried granules.");
    Step step217 = new Step("Sieving\n" +
            " (Sieve aperture size 1 mm).");
    Step step218 = new Step("Compression");
    Step step219 = new Step("Coating");
    ArrayList<Step> steps21 = new ArrayList<>();

    Formula formula21 = new Formula("", "", "Description", constituants21, steps21, "");

    /**********************************************************************************************************************/


    /************************************ Medicament 3 *************************************************************/

    Medic medic3 = new Medic("Diclofenac", "Very long medic description text");

    /*************************************** Medicament 3 form 1 *******************************************************/
    MedicForm medic3Form = new MedicForm("Granul", "Very long medic form description text");

    ArrayList<MedicForm> medic3Forms = new ArrayList<>();


    /********************************************* Medicament 3 form 1 process ********************************/

    Process process311 = new Process("Wet granulation", "Very long process description text");
    ArrayList<Process> processes311 = new ArrayList<>();


    /********************************************** Medicament 3 form 1 process formula *********************************/
    Constituant constituant3111 = new Constituant(
            "Diclofenac",
            "",
            "    • Diclofenac potassium.\n" +
                    "    • Average particle size : 170-220µm.\n" +
                    "    • Solubility: Sparingly soluble in water, soluble in ethanol (96 per cent).",
            5.556,
            "ARSHAD S and al.FORMULATION AND EVALUATION OF GASTRO RETENTIVE NONEFFERVACENTFLOATING TABLET OF DICLOFENAC POTASSIUM, «International Journalof biology, Pharmacy and Allied Sciences», November 2016, vol. 5, No. 11, p. 2967- 2985.\n" +
                    "\n" +
                    "\n" +
                    "Yong K. Han and al. Physicochemical Characterization of Physical Mixture and Solid Dispersion of Diclofenac Potassium with Mannitol, « Journal of Applied Pharmaceutical Science », January 2017, \n" +
                    " Vol. 7, No. 1, p. 204-208.  ",
            "%"
    );
    Constituant constituant3112 = new Constituant(
            "Glycerol dibehenate",
            "",
            "    • Lubricant.\n" +
                    "    • Storage temperature : <35°C.\n" +
                    "    • HLB : 2.",
            0.222,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Glyceryl Behenate. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 286-288.",
            "%"
    );
    Constituant constituant3113 = new Constituant(
            "Saccharin sodium",
            "",
            "    • Sweetening agent, flavoring enhancer.\n" +
                    "    • PH: 6.6 for a 10% w/v aqueous solution.\n" +
                    "    • Density (bulk): 0.68 g/Cm3 (84% saccharin sodium).\n" +
                    "    • Density (particle): 1.7 g/Cm3 (84% saccharin sodium).\n" +
                    "    • Density (tapped):  0.96 g/Cm3 (84% saccharin sodium).\n" +
                    "    • Moisture content:  contains 5.5% water (84% saccharin sodium).\n" +
                    "    • Specific surface area: 0.25m2/g.\n" +
                    "    • Solubility in water: 10g/100ml.",
            0.556,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Saccharin Sodium. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 608-610.",
            "%"
    );
    Constituant constituant3114 = new Constituant(
            "Anise flavor",
            "",
            "    • Flavoring agent.\n" +
                    "\n",
            1.667,
            "",
            "%"
    );
    Constituant constituant3115 = new Constituant(
            "Potassium hydrogen carbonate",
            "",
            "    • Buffering agent.\n" +
                    "    • Soluble in water.\n" +
                    "    • PH: 8.2 for a 0.1M aqueous solution.",
            2.444,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Sodium Chloride. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 637-640.",
            "%"
    );
    Constituant constituant3116 = new Constituant(
            "Mint flavor",
            "",
            "    • Flavoring agent.\n    • Flavoring agent.\n",
            3.889,
            "",
            "%"
    );
    Constituant constituant3117 = new Constituant(
            "Aspartame",
            "",
            "    • Sweetening agent, flavoring enhancer.\n" +
                    "    • Flowability:44%\n" +
                    "    • Density (true): 1.347 g/cm3.",
            5.558,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Aspartame. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 48-50.",
            "%"
    );
    Constituant constituant3118 = new Constituant(
            "Mannitol",
            "fine quality",
            "    • Diluent.\n" +
                    "    • Density(bulk) : 0.43 g/cm3.\n" +
                    "    • Density(tapped) : 0.734 g/cm3.\n" +
                    "    • Density( true) : 1.514 g/cm3.\n" +
                    "    • Specific surface area : 0.37-0.39 m2/g. ",
            8.111,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Mannitol. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 424-428.",
            "%"
    );
    Constituant constituant3119 = new Constituant(
            "Mannitol",
            "coarse quality",
            "    • Diluent.\n" +
                    "    • Density (bulk) : 0.7g/cm3.\n" +
                    "    • Density (tapped) : 0.8 g/cm3.\n" +
                    "    • Density( true) : 1.514 g/cm3.\n" +
                    "    • Specific surface area : 0.37-0.39 m2/g.",
            72.022,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Mannitol. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 424-428.",
            "%"
    );
    Constituant constituant31110 = new Constituant(
            "Ethyl alcohol",
            "",
            "    • Solubilizing and preservative agent.\n" +
                    "    • Density: 0.7893 g/cm3.\n" +
                    "    • Viscosity : 1.2 mPa.\n" +
                    "    • Solubilty in water: miscible.\n" +
                    "    • molecular diameter: 0.469nm ",
            1.916,
            "",
            "%"
    );
    ArrayList<Constituant> constituants311 = new ArrayList<>();


    Step step3111 = new Step("Mixture of:\n" +
            "    • 16.2kg of mannitol(coarse quality),11.25 kg of diclofenac,4.95 of potassium hydrogen  biacarbonte, 1.125 of saccharin sodium and 11.25 of aspartame.");
    Step step3112 = new Step("     • Addition of the ethyl alcohol.");
    Step step3113 = new Step("Sieve the following excipients: \n" +
            "    • 129.475 kg of mannitol (coarse quality).\n" +
            "    • 16.425kg of mannitol(fine quality).\n" +
            "    • 0.45kg of Glycerol dibehenate.\n" +
            "    • 7.875kg of mint flavors.\n" +
            "    • 3.375kg of anise flavor. ");
    Step step3114 = new Step("Mixture of:\n" +
            "    • Granulate obtained in step1.\n" +
            "    • 129.475 kg of mannitol (coarse quality).\n" +
            "    • 16.425kg of mannitol(fine quality).\n" +
            "    • 0.45kg of Glycerol dibehenate.\n" +
            "    • 7.875kg of mint flavors.\n" +
            "    • 3.375kg of anise flavor.\n" +
            "NB: The addition of the excipients was in order.");
    Step step3115 = new Step("Fill the final mixture into sachets.");
    ArrayList<Step> steps311 = new ArrayList<>();

    Formula formula311 = new Formula("", "", "Description", constituants311, steps311, "");

    /**********************************************************************************************************************/


    /*************************************** Medicament 3 form 2 *******************************************************/
    MedicForm medic3Form2 = new MedicForm("Powder", "Very long medic form description text");


    /********************************************* Medicament 3 form 2 process ********************************/

    Process process321 = new Process("", "Very long process description text");
    ArrayList<Process> processes321 = new ArrayList<>();


    /********************************************** Medicament 3 form 2 process formula *********************************/
    Constituant constituant3211 = new Constituant(
            "Diclofenac",
            "",
            "    • Diclofenac potassium.\n" +
                    "    • Average particle size : 170-220µm.\n" +
                    "    • Solubility: Sparingly soluble in water, soluble in ethanol (96 per cent).",
            33.15,
            "ARSHAD S and al.FORMULATION AND EVALUATION OF GASTRO RETENTIVE NONEFFERVACENTFLOATING TABLET OF DICLOFENAC POTASSIUM, «International Journalof biology, Pharmacy and Allied Sciences», November 2016, vol. 5, No. 11, p. 2967- 2985.\n" +
                    "\n" +
                    "\n" +
                    "Yong K. Han and al. Physicochemical Characterization of Physical Mixture and Solid Dispersion of Diclofenac Potassium with Mannitol, « Journal of Applied Pharmaceutical Science », January 2017, \n" +
                    " Vol. 7, No. 1, p. 204-208.  ",
            "kg"
    );
    Constituant constituant3212 = new Constituant(
            "Glycerol dibehenate",
            "",
            "    • Lubricant.\n" +
                    "    • Storage temperature : <35°C.\n" +
                    "    • HLB : 2.",
            2.6,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Glyceryl Behenate. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 286-288.",
            "kg"
    );
    Constituant constituant3213 = new Constituant(
            "Saccharin sodium",
            "",
            "    • Sweetening agent, flavoring enhancer.\n" +
                    "    • PH: 6.6 for a 10% w/v aqueous solution.\n" +
                    "    • Density (bulk): 0.68 g/Cm3 (84% saccharin sodium).\n" +
                    "    • Density (particle): 1.7 g/Cm3 (84% saccharin sodium).\n" +
                    "    • Density (tapped):  0.96 g/Cm3 (84% saccharin sodium).\n" +
                    "    • Moisture content:  contains 5.5% water (84% saccharin sodium).\n" +
                    "    • Specific surface area: 0.25m2/g.\n" +
                    "    • Solubility in water: 10g/100ml.",
            6.5,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Saccharin Sodium. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 608-610.",
            "kg"
    );
    Constituant constituant3214 = new Constituant(
            "Anise flavor",
            "",
            "    • Flavoring agent.\n" +
                    "\n",
            19.5,
            "",
            "kg"
    );
    Constituant constituant3215 = new Constituant(
            "Potassium hydrogen carbonate",
            "",
            "    • Buffering agent.\n" +
                    "    • Soluble in water.\n" +
                    "    • PH: 8.2 for a 0.1M aqueous solution.",
            28.6,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Sodium Chloride. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 637-640.",
            "kg"
    );
    Constituant constituant3216 = new Constituant(
            "Mint flavor",
            "",
            "    • Flavoring agent.",
            45.5,
            "",
            "kg"
    );
    Constituant constituant3217 = new Constituant(
            "Aspartame",
            "",
            "    • Sweetening agent, flavoring enhancer.\n" +
                    "    • Flowability:44%\n" +
                    "    • Density (true): 1.347 g/cm3.",
            65,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Aspartame. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 48-50.",
            "kg"
    );
    Constituant constituant3218 = new Constituant(
            "Mannitol",
            "Fine quality",
            "    • Diluent.\n" +
                    "    • Density(bulk) : 0.43 g/cm3.\n" +
                    "    • Density(tapped) : 0.734 g/cm3.\n" +
                    "    • Density( true) : 1.514 g/cm3.\n" +
                    "    • Specific surface area : 0.37-0.39 m2/g. ",
            47.45,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Mannitol. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 424-428.",
            "kg"
    );
    Constituant constituant3219 = new Constituant(
            "Mannitol",
            "Coarse quality",
            "    • Diluent.\n" +
                    "    • Density (bulk) : 0.7g/cm3.\n" +
                    "    • Density (tapped) : 0.8 g/cm3.\n" +
                    "    • Density( true) : 1.514 g/cm3.\n" +
                    "    • Specific surface area : 0.37-0.39 m2/g.",
            842.4,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Mannitol. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 424-428.",
            "kg"
    );
    ArrayList<Constituant> constituants321 = new ArrayList<>();


    Step step3211 = new Step("Sieving 47.45 kg of mannitol (fine quality) and 33.15Kg of Diclofenac potassium.");
    Step step3212 = new Step("Mixing the mannitol (fine quality) with Diclofenac.");
    Step step3213 = new Step("Sieving the excipients: \n" +
            "    • 520Kg mannitol(coarse quality).\n" +
            "    • 28.6Kg of potassium hydrogen carbonate.\n" +
            "    • 65Kg of Aspartame.\n" +
            "    • 6.5Kg of saccharin sodium.");
    Step step3214 = new Step("Mixture of:\n" +
            "    • 120Kg of mannitol(croase quality).\n" +
            "    • The mixture obtained from step 1.\n" +
            "    • 100Kg of mannitol(croase quality).\n" +
            "    • 28.6Kg of potassium hydrogen carbonate.\n" +
            "    • 100Kg of mannitol(croase quality).\n" +
            "    • 65Kg of Aspartame.\n" +
            "    • 100Kg of mannitol(croase quality).\n" +
            "    • 6.5Kg of saccharin sodium.\n" +
            "    • 100Kg of mannitol(croase quality).\n" +
            "NB: The addition of the excipients was in order.");
    Step step3215 = new Step("Sieving the excipients:\n" +
            "    • 322.4kg of mannitol(croase quality).\n" +
            "    • 2.6Kg of glyceryl       dibehenate.\n" +
            "    • 45.5Kg of mint flavor.\n" +
            "    • 19.5Kg of anise flavor.");
    Step step3216 = new Step("Mixing the excipients:\n" +
            "    • 72.4Kg mannitol(croase quality).\n" +
            "    • 52.6Kg og glidant pre-mexture consisting of:\n" +
            "    A. 2.6Kg of glyceryl       dibehenate.\n" +
            "    B. 50Kg of mannitol (croase quality).\n" +
            "    • 45.5Kg of mint flavor.\n" +
            "    • 100Kg of mannitol (croase quality).\n" +
            "    • 19.5Kg of anise flavor.\n" +
            "    • 100Kg of mannitol (croase quality).\n" +
            "NB: The addition of the excipients was in order.");
    Step step3217 = new Step("Filling the final mixture into sachets.");
    ArrayList<Step> steps321 = new ArrayList<>();

    Formula formula321 = new Formula("", "", "Description", constituants321, steps321, "");

    /**********************************************************************************************************************/

    /*************************************** Medicament 3 form 3 *******************************************************/
    MedicForm medic3Form3 = new MedicForm("Solution", "Very long medic form description text");


    /********************************************* Medicament 3 form 3 process ********************************/

    Process process331 = new Process("", "Very long process description text");
    ArrayList<Process> processes331 = new ArrayList<>();


    /********************************************** Medicament 3 form 3 process formula *********************************/
    Constituant constituant3311 = new Constituant(
            "Diclofenac potassium",
            "",
            "    • Diclofenac potassium.\n" +
                    "    • Average particle size : 170-220µm.\n" +
                    "    • Solubility: Sparingly soluble in water, soluble in ethanol (96 per cent).",
            13.5,
            "ARSHAD S and al.FORMULATION AND EVALUATION OF GASTRO RETENTIVE NONEFFERVACENTFLOATING TABLET OF DICLOFENAC POTASSIUM, «International Journalof biology, Pharmacy and Allied Sciences», November 2016, vol. 5, No. 11, p. 2967- 2985.\n" +
                    "\n" +
                    "\n" +
                    "Yong K. Han and al. Physicochemical Characterization of Physical Mixture and Solid Dispersion of Diclofenac Potassium with Mannitol, « Journal of Applied Pharmaceutical Science », January 2017, \n" +
                    " Vol. 7, No. 1, p. 204-208.  ",
            "kg"
    );
    Constituant constituant3312 = new Constituant(
            "Ethyl alcohol",
            "96%",
            "    • Solubilizing and preservative agent.\n" +
                    "    • Density: 0.7893 g/cm3.\n" +
                    "    • Viscosity : 1.2 mPa.\n" +
                    "    • Solubilty in water: miscible.\n" +
                    "    • molecular diameter: 0.469nm",
            75,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Alcohol. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 17-19.\n" +
                    "\n" +
                    "Leroy G.Wade, 2019. Alcohol. In: Britannica Encyclopedia [En ligne]. Available on : https://www.britannica.com/science/alcohol/Reactions-of-alcohols",
            "kg"
    );
    Constituant constituant3313 = new Constituant(
            "Glycerol",
            "",
            "    • Solubilizing agent.\n" +
                    "    • Density: 1.2656 g/cm3 at 15°C.\n" +
                    "                1.2636 g/cm3 at 20°C.\n" +
                    "                               1.2620g/cm3 at 25°C.\n" +
                    "    • Surface tension: 63.4 mN/m",
            50,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Glycerin. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 283-286.",
            "kg"
    );
    Constituant constituant3314 = new Constituant(
            "Potassium hydrogen carbonate",
            "",
            "    • Buffering agent.\n" +
                    "    • Soluble in water.\n" +
                    "    • PH: 8.2 for a 0.1M aqueous solution.",
            6.25,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Potassium Bicarbonate. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 570-571.",
            "kg"
    );
    Constituant constituant3315 = new Constituant(
            "Saccharin sodium",
            "",
            "    • PH: 6.6 for a 10% w/v aqueous solution.\n" +
                    "    • Density (bulk): 0.68 g/Cm3 (84% saccharin sodium).\n" +
                    "    • Density (particle): 1.7 g/Cm3 (84% saccharin sodium).\n" +
                    "    • Density (tapped):  0.96 g/Cm3 (84% saccharin sodium).\n" +
                    "    • Moisture content:  contains 5.5% water (84% saccharin sodium).\n" +
                    "    • Specific surface area: 0.25m2/g.\n" +
                    "    • Solubility in water: 10g/100ml.",
            3.75,
            "Marian E Quinn, Paul J Sheskey, Raymond C Rowe. Saccharin Sodium. In Handbook of pharmaceutical excipients, 6e ed. London: The pharmaceutical press, 2009, p. 608-610.",
            "kg"
    );
    Constituant constituant3316 = new Constituant(
            "Caramel E150a",
            "",
            "    • Colouring agent.",
            0.625,
            "E150a",
            "kg"
    );
    Constituant constituant3317 = new Constituant(
            "Purfied water",
            "",
            "    • Diluent agent.",
            107.25,
            "",
            "kg"
    );
    ArrayList<Constituant> constituants331 = new ArrayList<>();


    Step step3311 = new Step("Adding the ethyl alcohol 96%   into a vessel and then, under stirring adding the active ingredient.");
    Step step3312 = new Step("After stirring, adding the glycerol into a vessel.");
    Step step3313 = new Step("While stirring, adding 76Kg of purified water to the mixture and stirred until a complete clear solution is obtained.");
    Step step3314 = new Step("The 31.25Kg of purified water into separate mixing vessel and under stirring, adding the remaining excipients (Potassium, Saccharin,Caramel E150a). The mixture is stirred.");
    Step step3315 = new Step("While stirring, adding the mixture obtained from step 1 to the mixture obtained from step 2 and the resultant mixture stirred until a complete clear brown solution is obtained.");
    Step step3316 = new Step("Under mixing, the volume was made up with purified water (250 liters of solution).");
    Step step3317 = new Step("The solution is particle-free filtrated.");
    ArrayList<Step> steps331 = new ArrayList<>();

    Formula formula331 = new Formula("", "", "Description", constituants331, steps331,
            "-Relative density of the solution:\n" +
                    "  1.0215 g/cm3.\n");

    /**********************************************************************************************************************/


    MainAdapter mainAdapter = new MainAdapter(this, medicalClassArrayList);

    ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

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



        /*************************************************  Medic 2 form 1 ***********************************************/

        steps21.add(step211);
        steps21.add(step212);
        steps21.add(step213);
        steps21.add(step214);
        steps21.add(step215);
        steps21.add(step216);
        steps21.add(step217);
        steps21.add(step218);
        steps21.add(step219);

        constituants21.add(constituant211);
        constituants21.add(constituant212);
        constituants21.add(constituant213);
        constituants21.add(constituant214);
        constituants21.add(constituant215);
        constituants21.add(constituant216);
        constituants21.add(constituant217);
        constituants21.add(constituant218);
        constituants21.add(constituant219);
        constituants21.add(constituant2110);
        constituants21.add(constituant2111);

        process21.setFormula(formula21);

        processes21.add(process21);
        processes21.add(process22);
        processes21.add(process23);
        processes21.add(process24);
        medic2Form.setProcessArrayList(processes21);


        /**************************************************** Medic 3 form 1 ************************************************************/


        steps311.add(step3111);
        steps311.add(step3112);
        steps311.add(step3113);
        steps311.add(step3114);
        steps311.add(step3115);

        constituants311.add(constituant3111);
        constituants311.add(constituant3112);
        constituants311.add(constituant3113);
        constituants311.add(constituant3114);
        constituants311.add(constituant3115);
        constituants311.add(constituant3116);
        constituants311.add(constituant3117);
        constituants311.add(constituant3118);
        constituants311.add(constituant3119);
        constituants311.add(constituant31110);

        process311.setFormula(formula311);

        processes311.add(process311);
        medic3Form.setProcessArrayList(processes311);


        /**************************************************** Medic 3 form 2 ****************************************************************/


        steps321.add(step3211);
        steps321.add(step3212);
        steps321.add(step3213);
        steps321.add(step3214);
        steps321.add(step3215);
        steps321.add(step3216);
        steps321.add(step3217);

        constituants321.add(constituant3211);
        constituants321.add(constituant3212);
        constituants321.add(constituant3213);
        constituants321.add(constituant3214);
        constituants321.add(constituant3215);
        constituants321.add(constituant3216);
        constituants321.add(constituant3217);
        constituants321.add(constituant3218);
        constituants321.add(constituant3219);

        process321.setFormula(formula321);

        processes321.add(process321);
        medic3Form2.setProcessArrayList(processes321);


        /*************************************************** Medic 3 form 3 ****************************************************************/


        steps331.add(step3311);
        steps331.add(step3312);
        steps331.add(step3313);
        steps331.add(step3314);
        steps331.add(step3315);
        steps331.add(step3316);
        steps331.add(step3317);

        constituants331.add(constituant3311);
        constituants331.add(constituant3312);
        constituants331.add(constituant3313);
        constituants331.add(constituant3314);
        constituants331.add(constituant3315);
        constituants331.add(constituant3316);
        constituants331.add(constituant3317);

        process331.setFormula(formula331);

        processes331.add(process331);
        medic3Form3.setProcessArrayList(processes331);


        medic3Forms.add(medic3Form);
        medic3Forms.add(medic3Form2);
        medic3Forms.add(medic3Form3);
        medic3.setMedicFormArrayList(medic3Forms);


        medic2Forms.add(medic2Form);
        medic2.setMedicFormArrayList(medic2Forms);

        medics.add(medic);
        medics.add(medic2);
        medics.add(medic3);


        Random rand = new Random();
        int n = rand.nextInt(50000000);
        medicalClass1 = new MedicalClass(String.valueOf(n), "Analgesics- antipyretics – antispasmodics", "Very long description text");

        medicalClass1.setMedicArrayList(medics);

        medicalClassArrayList.add(medicalClass1);



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
