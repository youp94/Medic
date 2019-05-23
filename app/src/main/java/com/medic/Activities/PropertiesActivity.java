package com.medic.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
import com.medic.R;

import java.util.ArrayList;

public class PropertiesActivity extends AppCompatActivity {


    ArrayList<String> properties = null;

    PropertyAdapter propertyAdapter = null;
    ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties);

        properties = (ArrayList<String>) getIntent().getSerializableExtra("props");

        listView = findViewById(R.id.properties_list);
        propertyAdapter = new PropertyAdapter(this, properties);
        listView.setAdapter(propertyAdapter);
    }
}

class PropertyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> properties;

    PropertyAdapter(Context context, ArrayList<String> medicalClassArrayList) {
        this.context = context;
        this.properties = medicalClassArrayList;
    }

    @Override
    public int getCount() {
        return properties.size();
    }

    @Override
    public Object getItem(int position) {
        return properties.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        final String property = properties.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint({"ViewHolder", "InflateParams"}) View view = inflater.inflate(R.layout.properties_item,null, false);

        TextView gradText;
        gradText = view.findViewById(R.id.property_description);
        gradText.setText(property);

        return view;
    }
}
