package com.revenant.takego.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.revenant.takego.R;
import com.revenant.takego.model.backend.Constants;
import com.revenant.takego.model.backend.DBManagerFactory;

public class AddCarActivity extends Activity {
    private EditText id;
    private EditText defualtBranch;
    private EditText model;
    private EditText mileage;
    private Button addCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        findViews();

        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCar();
                clear();
            }
        });
    }

    private void addCar() {
        final ContentValues cv = new ContentValues();
        try{
            cv.put(Constants.CarConst.ID,Long.valueOf(id.getText().toString()));
            cv.put(Constants.CarConst.DEFAULT_BRANCH_NUMBER,Long.valueOf(defualtBranch.getText().toString()));
            cv.put(Constants.CarConst.MODEL,model.getText().toString());
            cv.put(Constants.CarConst.MILEAGE,Double.valueOf(mileage.getText().toString()));

            new AsyncTask<Void,Void,Long>(){
                @Override
                protected void onPostExecute(Long aLong) {
                    super.onPostExecute(aLong);
                    Toast.makeText(AddCarActivity.this,"Car: "+aLong+" added!",Toast.LENGTH_SHORT).show();
                }

                @Override
                protected Long doInBackground(Void... voids) {
                    return DBManagerFactory.getDB_List().addCar(cv);
                }
            }.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void clear(){
        id.setText("");
        defualtBranch.setText("");
        model.setText("");
        mileage.setText("");
    }

    private void findViews() {
        id = findViewById(R.id.carIDId);
        defualtBranch = findViewById(R.id.defaultBranchId);
        model = findViewById(R.id.modelID);
        mileage = findViewById(R.id.mileageId);
        addCar = findViewById(R.id.addCarButtonId);
    }
}
