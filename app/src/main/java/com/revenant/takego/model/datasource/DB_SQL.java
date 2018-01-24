package com.revenant.takego.model.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.revenant.takego.controller.MainActivity;
import com.revenant.takego.controller.ShowAllActivity;
import com.revenant.takego.model.backend.Constants;
import com.revenant.takego.model.backend.DB_Manager;
import com.revenant.takego.model.entities.Branch;
import com.revenant.takego.model.entities.Car;
import com.revenant.takego.model.entities.CarModel;
import com.revenant.takego.model.entities.Customer;
import com.revenant.takego.model.entities.Reservation;
import com.revenant.takego.util.PHPTools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Or on 21-Jan-18.
 */

public class DB_SQL implements DB_Manager {
    private final String WEB_URL = "http://ogat.vlab.jct.ac.il/";
    private static DB_SQL instance;


    private DB_SQL() {
    }

    public static DB_SQL getInstance() {
        if (instance == null) {
            instance = new DB_SQL();
        }
        return instance;
    }

    @Override
    public boolean customerExists(long id) {
        return false;
    }

    @Override
    public long addCustomer(ContentValues newCustomer) {
        try {
            String result = PHPTools.POST(WEB_URL + "addCustomer.php", newCustomer);
            long id = Long.parseLong(result.replace(" ", ""));
            return id;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }


    @Override
    public long addModel(ContentValues newModel) {
        try {
            String result = PHPTools.POST(WEB_URL + "addCarModel.php", newModel);
            long id = Long.parseLong(result.replace(" ", ""));
            return id;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public long addCar(ContentValues newCar) {
        try {
            String result = PHPTools.POST(WEB_URL + "addCar.php", newCar);
            long id = Long.parseLong(result.replace(" ", ""));
            return id;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public long updateCar(ContentValues newCar) {
        try {
            String result = PHPTools.POST(WEB_URL + "updateCar.php", newCar);
            long id = Long.parseLong(result.replace(" ", ""));
            return id;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public long addBranch(ContentValues newBranch) {
        try {
            String result = PHPTools.POST(WEB_URL + "addBranch.php", newBranch);
            long id = Long.parseLong(result.replace(" ", ""));
            return id;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public long addReservation(ContentValues newReservation) {
        try {
            String result = PHPTools.POST(WEB_URL + "addReservation.php", newReservation);
            long id = Long.parseLong(result.replace(" ", ""));
            return id;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Car> returnAllCars() {
        List<Car> allCars = new ArrayList<>();
        try {
            String str = PHPTools.GET(WEB_URL + "allCars.php");
            JSONArray jsonArray = new JSONObject(str).getJSONArray("cars");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Car car = new Car();
                car.setCarId(jsonObject.getLong(Constants.CarConst.ID));
                car.setModelNumber(jsonObject.getLong(Constants.CarConst.MODEL_NUMBER));
                car.setDefaultBranchNumber(jsonObject.getLong(Constants.CarConst.DEFAULT_BRANCH_NUMBER));
                car.setMileage(jsonObject.getDouble(Constants.CarConst.MILEAGE));
                allCars.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allCars;
    }

    @Override
    public List<CarModel> returnAllCarModels() {
        List<CarModel> allCarModels = new ArrayList<>();
        try {
            String str = PHPTools.GET(WEB_URL + "allCarModels.php");
            JSONArray jsonArray = new JSONObject(str).getJSONArray("carModels");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                CarModel carModel = new CarModel();
                carModel.setModelNumber(jsonObject.getLong(Constants.CarModelConst.MODEL_NUMBER));
                carModel.setModelName(jsonObject.getString(Constants.CarModelConst.MODEL_NAME));
                carModel.setBrand(jsonObject.getString(Constants.CarModelConst.BRAND));
                carModel.setEngineSize(jsonObject.getInt(Constants.CarModelConst.ENGINE_SIZE));
                carModel.setSeats(jsonObject.getInt(Constants.CarModelConst.SEATS));
                carModel.setGearType(CarModel.Gear.valueOf(jsonObject.getString(Constants.CarModelConst.GEAR_TYPE)));

                allCarModels.add(carModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allCarModels;
    }

    @Override
    public List<Branch> returnAllBranches() {
        List<Branch> allBranches = new ArrayList<>();
        try {
            String str = PHPTools.GET(WEB_URL + "allBranches.php");
            JSONArray jsonArray = new JSONObject(str).getJSONArray("branches");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Branch branch = new Branch();
                branch.setBranchNumber(jsonObject.getLong(Constants.BranchConst.BRANCH_NUMBER));
                branch.setAddress(jsonObject.getString(Constants.BranchConst.ADDRESS));
                branch.setParkingSpaces(jsonObject.getInt(Constants.BranchConst.PARKING_SPACES));

                allBranches.add(branch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allBranches;
    }


    @Override
    public List<Customer> returnAllCustomers() {
        List<Customer> allCustomers = new ArrayList<>();
        try {
            String str = PHPTools.GET(WEB_URL + "allCustomers.php");
            JSONArray jsonArray = new JSONObject(str).getJSONArray("customers");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Customer customer = new Customer();
                customer.setId(jsonObject.getLong(Constants.CustomerConst.ID));
                customer.setName(jsonObject.getString(Constants.CustomerConst.NAME));
                customer.setLastName(jsonObject.getString(Constants.CustomerConst.LAST_NAME));
                customer.setEmail(jsonObject.getString(Constants.CustomerConst.EMAIL));
                customer.setCreditCard(jsonObject.getString(Constants.CustomerConst.CREDIT_CARD));
                allCustomers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allCustomers;
    }


    @Override
    public List<Reservation> returnAllReservations() {
        List<Reservation> allReservations = new ArrayList<>();
        try {
            String str = PHPTools.GET(WEB_URL + "allReservations.php");
            JSONArray jsonArray = new JSONObject(str).getJSONArray("reservations");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Reservation reservation = new Reservation();
                reservation.setReservationNumber(jsonObject.getLong(Constants.ReservationConst.RESERVATION_NUMBER));
                reservation.setCustomerNumber(jsonObject.getLong(Constants.ReservationConst.CUSTOMER_NUMBER));
                reservation.setCarNumber(jsonObject.getLong(Constants.ReservationConst.CAR_NUMBER));
                reservation.setOpen(jsonObject.getBoolean(Constants.ReservationConst.IS_OPEN));
                reservation.setWasRefueled(jsonObject.getBoolean(Constants.ReservationConst.WAS_REFUELED));
                reservation.setPreKMCount(jsonObject.getDouble(Constants.ReservationConst.PRE_KM_COUNT));
                reservation.setPostKMCount(jsonObject.getDouble(Constants.ReservationConst.POST_KM_COUNT));
                reservation.setLitersRefueled(jsonObject.getDouble(Constants.ReservationConst.LITERS_REFUELED));
                reservation.setRentBeginning(jsonObject.getString(Constants.ReservationConst.RENT_BEGINNING));
                reservation.setRentEnd(jsonObject.getString(Constants.ReservationConst.RENT_END));
                reservation.setPrice(jsonObject.getDouble(Constants.ReservationConst.TOTAL_PRICE));
                allReservations.add(reservation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allReservations;
    }

    @Override
    public List<Car> returnAllFreeCars() {
        List<Car> allCars= returnAllCars();
        List<Reservation> allReservations= returnAllReservations();
        for(int i=0;i<allCars.size(); i++){
            for(int j=0;j<allReservations.size(); j++){
                if(allCars.get(i).getCarId()==allReservations.get(j).getCarNumber()){
                    allCars.remove(i);
                }
            }
        }
        return allCars;
    }
}
