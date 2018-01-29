package com.revenant.takego.controller;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.revenant.takego.R;
import com.revenant.takego.model.backend.Constants;
import com.revenant.takego.model.backend.DBManagerFactory;

import java.util.Calendar;

public class AddReservationActivity extends Activity {

    private EditText customerNumber;
    private TextView rentBegining;
    private TextView rentEnd;
    private EditText preMileage;
    private EditText carNumber;
    private EditText postMileage;
    private EditText litersRefueled;
    private EditText id;
    private RadioGroup status;
    private RadioGroup fuel;
    private Button addReservation;
    private boolean wasRefueled;
    private boolean isOpen;
    private String selectedDate;
    private DatePickerDialog.OnDateSetListener mDateEndSetListener;
    private DatePickerDialog.OnDateSetListener mDateBeginningSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reservation);
        findViews();


        rentEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year= cal.get(Calendar.YEAR);
                int month= cal.get(Calendar.MONTH);
                int day= cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddReservationActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateEndSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });

        rentBegining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year= cal.get(Calendar.YEAR);
                int month= cal.get(Calendar.MONTH);
                int day= cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddReservationActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateBeginningSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateBeginningSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month= month+1;
                String monthString= (month<10) ? ("0"+month) : (""+month);
                String dayString= (day<10) ? ("0"+day) : (""+day);
                selectedDate= ""+year+"-"+monthString+"-"+dayString;
                rentBegining.setText(selectedDate);
            }
        };



        mDateEndSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month= month+1;
                String monthString= (month<10) ? ("0"+month) : (""+month);
                String dayString= (day<10) ? ("0"+day) : (""+day);
                selectedDate= ""+year+"-"+monthString+"-"+dayString;
                rentEnd.setText(selectedDate);
            }
        };



        status.check(R.id.openId);
        isOpen=true;
        status.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.openId:
                        isOpen = true;
                        break;
                    case R.id.closedId:
                        isOpen = false;
                        break;
                }
            }
        });

        fuel.check(R.id.noId);
        litersRefueled.setEnabled(false);
        litersRefueled.setText("0");
        fuel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.yesId:
                        wasRefueled=true;
                        litersRefueled.setEnabled(true);
                        litersRefueled.setText("");
                        break;
                    case R.id.noId:
                        wasRefueled=false;
                        litersRefueled.setEnabled(false);
                        litersRefueled.setText("0");
                        break;
                }
            }
        });
        addReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addReservation();
                clear();
            }
        });
    }

    private void clear() {
    }
    private void addReservation(){
        final ContentValues cv = new ContentValues();
        try{
            if(id.getText().toString().isEmpty())
                cv.put(Constants.ReservationConst.RESERVATION_NUMBER,"");
            else{
                cv.put(Constants.ReservationConst.RESERVATION_NUMBER, Long.valueOf(id.getText().toString()));
            }
            cv.put(Constants.ReservationConst.CUSTOMER_NUMBER, Long.valueOf(customerNumber.getText().toString()));
            cv.put(Constants.ReservationConst.RENT_BEGINNING, rentBegining.getText().toString());
            cv.put(Constants.ReservationConst.RENT_END, rentEnd.getText().toString());

            double preKM= Double.valueOf(preMileage.getText().toString());
            cv.put(Constants.ReservationConst.PRE_KM_COUNT, preKM );

            double postKM = Double.valueOf(postMileage.getText().toString());
            cv.put(Constants.ReservationConst.POST_KM_COUNT,postKM );

            cv.put(Constants.ReservationConst.IS_OPEN, isOpen);
            cv.put(Constants.ReservationConst.WAS_REFUELED, wasRefueled);

            double liters=  Double.valueOf(litersRefueled.getText().toString());
            cv.put(Constants.ReservationConst.LITERS_REFUELED,liters);
            cv.put(Constants.ReservationConst.CAR_NUMBER, Long.valueOf(carNumber.getText().toString()));
            cv.put(Constants.ReservationConst.TOTAL_PRICE, (10*(postKM-preKM)-liters));


            new AsyncTask<Void,Void,Long>(){
                @Override
                protected void onPostExecute(Long aLong) {
                    super.onPostExecute(aLong);
                    Toast.makeText(getBaseContext(),"Reservation: "+aLong+" added!",Toast.LENGTH_SHORT).show();
                }

                @Override
                protected Long doInBackground(Void... voids) {
                    return DBManagerFactory.getDB_SQL().addReservation(cv);

                }
            }.execute();
        } catch (Exception e){
            e.printStackTrace();
        }



    }

    private void findViews() {
        id = findViewById(R.id.resNumberId);
        carNumber = findViewById(R.id.resCarNumberId);
        customerNumber = findViewById(R.id.customerNumberId);
        rentBegining = findViewById(R.id.rentBeginningId);
        rentEnd = findViewById(R.id.rentEndId);
        preMileage = findViewById(R.id.preMileageId);
        postMileage = findViewById(R.id.postMileageId);
        litersRefueled = findViewById(R.id.litersRefueledId);
        status = findViewById(R.id.statusGroupId);
        fuel = findViewById(R.id.fuelGroupId);
        addReservation = findViewById(R.id.addReservationButtonId);

    }
}
