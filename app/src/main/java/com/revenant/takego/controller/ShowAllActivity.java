package com.revenant.takego.controller;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.revenant.takego.R;
import com.revenant.takego.model.backend.Constants;
import com.revenant.takego.model.backend.DBManagerFactory;
import com.revenant.takego.model.datasource.DB_SQL;
import com.revenant.takego.model.entities.Branch;
import com.revenant.takego.model.entities.Car;
import com.revenant.takego.model.entities.CarModel;
import com.revenant.takego.model.entities.Customer;
import com.revenant.takego.model.entities.Reservation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShowAllActivity extends Activity {
    ListView myListView;
    Bundle extras;
    RequestQueue queue;
    private List<Customer> allCustomers;
    private List<Car> cars;
    private List<Reservation> reservations;
    private final String WEB_URL = "http://ogat.vlab.jct.ac.il/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        myListView = findViewById(R.id.myListViewId);
        extras= getIntent().getExtras();

        allCustomers = new ArrayList<>();


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
                            List<Branch> allBranches = DBManagerFactory.getDB_SQL().returnAllBranches();
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
                            List<CarModel> allCarModels = DBManagerFactory.getDB_SQL().returnAllCarModels();
                            return new ArrayAdapter<CarModel>(getBaseContext(),android.R.layout.simple_list_item_1,allCarModels);
                        }
                    }.execute();
                    break;

                case Constants.CarConst.CAR:
                    new AsyncTask<Void,Void,List<Car>>(){

                        @Override
                        protected void onPostExecute(List<Car> cars) {
                            super.onPostExecute(cars);
                            ArrayAdapter<Car> adapter = new ArrayAdapter<Car>(getBaseContext(), android.R.layout.simple_list_item_1, cars);
                            myListView.setAdapter(adapter);
                        }

                        @Override
                        protected List<Car> doInBackground(Void... voids) {
                            return DBManagerFactory.getDB_SQL().returnAllFreeCars();
                        }
                    }.execute();
                    break;

                case Constants.CustomerConst.CUSTOMER:
                    new AsyncTask<Void,Void,ListAdapter>(){
                        @Override
                        protected void onPostExecute(ListAdapter listAdapter) {
                            super.onPostExecute(listAdapter);
                            myListView.setAdapter(listAdapter);
                        }

                        @Override
                        protected ListAdapter doInBackground(Void... voids) {
                            List<Customer> allCustomers= DBManagerFactory.getDB_SQL().returnAllCustomers();
                            return new ArrayAdapter<Customer>(getBaseContext(),android.R.layout.simple_list_item_1,allCustomers);
                        }
                    }.execute();
                    break;

                case Constants.ReservationConst.RESERVATION:
                    new AsyncTask<Void,Void,ListAdapter>(){
                        @Override
                        protected void onPostExecute(ListAdapter listAdapter) {
                            super.onPostExecute(listAdapter);
                            myListView.setAdapter(listAdapter);

                        }

                        @Override
                        protected ListAdapter doInBackground(Void... voids) {
                            List<Reservation> allReservations= DBManagerFactory.getDB_SQL().returnAllReservations();
                            return new ArrayAdapter<Reservation>(getBaseContext(),android.R.layout.simple_list_item_1, allReservations);
                        }
                    }.execute();
                    break;
            }
        }


    }

    public void getAllCustomers() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "http://ogat.vlab.jct.ac.il/allCustomers.php", new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray clientArray = response.getJSONArray("customers");

                    for (int i = 0; i < clientArray.length(); i++) {
                        JSONObject jsonObject = clientArray.getJSONObject(i);
                        Customer customer = new Customer();
                        customer.setId(jsonObject.getInt("_id"));
                        customer.setName(jsonObject.getString("name"));
                        customer.setLastName(jsonObject.getString("lastName"));
                        customer.setCreditCard(jsonObject.getString("creditCard"));
                        customer.setEmail(jsonObject.getString("email"));
                        Log.v("Tag","This is: "+customer);
                        allCustomers.add(customer);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);

    }

}

