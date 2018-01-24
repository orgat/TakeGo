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
import com.revenant.takego.model.backend.DB_Manager;

public class AddBranchActivity extends Activity {
    private EditText addressText;
    private EditText branchNumberText;
    private EditText parkingSpacesText;
    private Button addBranch;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch);

        findViews();

        addBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBranch();
                clear();
            }
        });
    }

    private void clear() {
        addressText.setText("");
        branchNumberText.setText("");
        parkingSpacesText.setText("");
    }

    private void findViews() {
        addressText= findViewById(R.id.branchAddressId);
        branchNumberText=findViewById(R.id.branchNumberId);
        parkingSpacesText=findViewById(R.id.parkingSpacesId);
        addBranch=findViewById(R.id.addBranchButtonId);


    }

    private void addBranch() {
        final ContentValues cv=  new ContentValues();
        try{
            if(branchNumberText.getText().toString().isEmpty()){
                cv.put(Constants.BranchConst.BRANCH_NUMBER,"");
            } else {
                cv.put(Constants.BranchConst.BRANCH_NUMBER, Long.valueOf(branchNumberText.getText().toString()));
            }
            cv.put(Constants.BranchConst.ADDRESS,addressText.getText().toString());

            cv.put(Constants.BranchConst.PARKING_SPACES,Integer.valueOf(parkingSpacesText.getText().toString()));

            new AsyncTask<Void, Void, Long>(){
                @Override
                protected void onPostExecute(Long id) {
                    super.onPostExecute(id);
                    Toast.makeText(AddBranchActivity.this,"Branch: "+id+" added!",Toast.LENGTH_SHORT).show();
                }

                @Override
                protected Long doInBackground(Void... voids) {
                   return DBManagerFactory.getDB_SQL().addBranch(cv);

                }
            }.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
