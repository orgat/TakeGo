package com.revenant.takego.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.revenant.takego.R;
import com.revenant.takego.model.backend.Constants;
import com.revenant.takego.model.backend.DBManagerFactory;
import com.revenant.takego.model.entities.CarModel;

public class AddModelActivity extends Activity {
    private EditText modelNumber;
    private EditText brand;
    private EditText modelName;
    private EditText seats;
    private EditText engineSize;
    private Spinner gear;
    private Button addModel;
    private String selectedGearType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_model);
        findViews();
        final ArrayAdapter adapter = new ArrayAdapter<CarModel.Gear>(getBaseContext(), android.R.layout.simple_spinner_item, CarModel.Gear.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gear.setAdapter(adapter);

        gear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedGearType = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        addModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedGearType==null){
                    Toast.makeText(AddModelActivity.this,"Please select a gear type.", Toast.LENGTH_LONG).show();
                }
                else {
                    addModel();
                    clear();
                }
            }
        });

    }

    private void clear() {
        modelNumber.setText("");
        modelName.setText("");
        brand.setText("");
        seats.setText("");
        engineSize.setText("");
        selectedGearType=null;
    }

    private void addModel() {
        final ContentValues cv = new ContentValues();
        try{
            if(modelNumber.getText().toString().isEmpty()){
                cv.put(Constants.CarModelConst.MODEL_NUMBER,"");
            } else {
                cv.put(Constants.CarModelConst.MODEL_NUMBER, Long.valueOf(modelNumber.getText().toString()));
            }
            cv.put(Constants.CarModelConst.MODEL_NAME,modelName.getText().toString());
            cv.put(Constants.CarModelConst.BRAND,brand.getText().toString());
            cv.put(Constants.CarModelConst.ENGINE_SIZE, Integer.valueOf(engineSize.getText().toString()));
            cv.put(Constants.CarModelConst.GEAR_TYPE,selectedGearType);
            cv.put(Constants.CarModelConst.SEATS,Integer.valueOf(seats.getText().toString()));

            new AsyncTask<Void,Void,Long>(){
                @Override
                protected void onPostExecute(Long aLong) {
                    super.onPostExecute(aLong);
                    Toast.makeText(AddModelActivity.this, "Car model: "+ aLong+ " added!",Toast.LENGTH_SHORT).show();
                }

                @Override
                protected Long doInBackground(Void... voids) {
                    return DBManagerFactory.getDB_SQL().addModel(cv);
                }
            }.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void findViews() {
        modelNumber = findViewById(R.id.modelNumberId);
        modelName = findViewById(R.id.modelNameId);
        brand = findViewById(R.id.brandId);
        seats = findViewById(R.id.seatsId);
        engineSize = findViewById(R.id.engineSizeId);
        gear = findViewById(R.id.gearSpinnerId);
        addModel = findViewById(R.id.addCarModelButtonId);
    }
}
