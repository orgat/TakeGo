package com.revenant.takego.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.revenant.takego.R;
import com.revenant.takego.model.backend.Constants;
import com.revenant.takego.model.backend.DBManagerFactory;
import com.revenant.takego.model.entities.Customer;

public class AddCustomerActivity extends Activity {
    private EditText id;
    private EditText name;
    private EditText lastName;
    private EditText phone;
    private EditText email;
    private EditText creditCard;
    private Button addCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        findViews();
        addCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCustomer();
                clear();
            }
        });
    }

    private void clear() {
        id.setText("");
        name.setText("");
        lastName.setText("");
        email.setText("");
        phone.setText("");
        creditCard.setText("");
    }

    private void addCustomer() {
        final ContentValues cv = new ContentValues();
        try {
            String idResult = id.getText().toString().replace(" ","");
            if(idResult.isEmpty()){
                cv.put(Constants.CustomerConst.ID,"");
            }else{
                cv.put(Constants.CustomerConst.ID,Long.valueOf(id.getText().toString()));
            }
            cv.put(Constants.CustomerConst.NAME, name.getText().toString());
            cv.put(Constants.CustomerConst.LAST_NAME, lastName.getText().toString());
            cv.put(Constants.CustomerConst.PHONE_NUMBER, phone.getText().toString());
            cv.put(Constants.CustomerConst.EMAIL , email.getText().toString());
            cv.put(Constants.CustomerConst.CREDIT_CARD , creditCard.getText().toString());
            Log.v("mySpace", id.getText().toString());

            new AsyncTask<Void, Void, Long>(){
                @Override
                protected void onPostExecute(Long aLong) {
                    Toast.makeText(getBaseContext(),"Customer: "+ aLong + " added!",Toast.LENGTH_SHORT).show();
                }

                @Override
                protected Long doInBackground(Void... voids) {
                    return DBManagerFactory.getDB_SQL().addCustomer(cv);
                }
            }.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void findViews() {
        id = findViewById(R.id.customerId);
        name = findViewById(R.id.nameId);
        lastName = findViewById(R.id.lastNameId);
        phone = findViewById(R.id.phoneId);
        email = findViewById(R.id.emailId);
        creditCard = findViewById(R.id.creditCardId);
        addCustomer = findViewById(R.id.addCustomerButtonId);
    }
}
