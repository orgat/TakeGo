package com.revenant.takego.controller;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.revenant.takego.R;
import com.revenant.takego.model.backend.DBManagerFactory;
import com.revenant.takego.model.backend.DB_Manager;
import com.revenant.takego.model.entities.*;
import com.revenant.takego.model.backend.Constants;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button addBranch;
    private Button addCarModel;
    private Button showAllBranches;
    private Button showAllModels;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();



    }

    private void findViews() {
        addBranch = findViewById(R.id.addBranchMainId);
        addBranch.setOnClickListener(this);

        addCarModel = findViewById(R.id.addCarModelMainId);
        addCarModel.setOnClickListener(this);

        showAllBranches = findViewById(R.id.displayAllBranchesMainId);
        showAllBranches.setOnClickListener(this);

        showAllModels = findViewById(R.id.displayAllModelsMainId);
        showAllModels.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.addBranchMainId:
                intent = new Intent(MainActivity.this, AddBranchActivity.class);
                startActivity(intent);
                break;

            case R.id.displayAllBranchesMainId:
                intent = new Intent(MainActivity.this,ShowAllActivity.class);
                intent.putExtra(Constants.SHOW_ALL,Constants.BranchConst.BRANCH);
                startActivity(intent);
                break;


            case R.id.addCarModelMainId:
                intent = new Intent(MainActivity.this, AddModelActivity.class);
                startActivity(intent);
                break;

            case R.id.displayAllModelsMainId:
                intent = new Intent(MainActivity.this, ShowAllActivity.class);
                intent.putExtra(Constants.SHOW_ALL, Constants.CarModelConst.MODEL);
                startActivity(intent);
                break;

        }
    }
}
