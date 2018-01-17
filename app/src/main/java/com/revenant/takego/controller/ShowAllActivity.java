package com.revenant.takego.controller;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.revenant.takego.R;
import com.revenant.takego.model.backend.Constants;
import com.revenant.takego.model.backend.DBManagerFactory;
import com.revenant.takego.model.entities.Branch;
import com.revenant.takego.model.entities.CarModel;

import java.util.List;

public class ShowAllActivity extends Activity {
    ListView myListView;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        myListView = findViewById(R.id.myListViewId);
        extras= getIntent().getExtras();

        if(extras != null){
            String entityToShow = extras.getString(Constants.SHOW_ALL);

            switch (entityToShow){
                case Constants.BranchConst.BRANCH:
                    new AsyncTask<Void,Void,ListAdapter>(){
                        @Override
                        protected void onPostExecute(ListAdapter listAdapter) {
                            super.onPostExecute(listAdapter);
                            myListView.setAdapter(listAdapter);
                        }

                        @Override
                        protected ListAdapter doInBackground(Void... voids) {
                            List<Branch> allBranches = DBManagerFactory.getDB_List().returnAllBranches();
                            return new ArrayAdapter<Branch>(getBaseContext(),android.R.layout.simple_list_item_1,allBranches);
                        }
                    }.execute();
                    break;

                case Constants.CarModelConst.MODEL:
                    new AsyncTask<Void,Void,ListAdapter>(){

                        @Override
                        protected void onPostExecute(ListAdapter listAdapter) {
                            super.onPostExecute(listAdapter);
                            myListView.setAdapter(listAdapter);
                        }

                        @Override
                        protected ListAdapter doInBackground(Void... voids) {
                            List<CarModel> allCarModels = DBManagerFactory.getDB_List().returnAllCarModels();
                            return new ArrayAdapter<CarModel>(getBaseContext(),android.R.layout.simple_list_item_1,allCarModels);
                        }
                    }.execute();


            }
        }


    }
}
