package com.revenant.takego.model.datasource;

import android.content.ContentValues;

import com.revenant.takego.model.backend.DB_Manager;
import com.revenant.takego.model.entities.*;

import static com.revenant.takego.model.backend.Constants.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Or on 30-Dec-17.
 */

public class DB_List implements DB_Manager {

    static List<Branch> allBranches;
    static List<Car> allCars;
    static List<CarModel> allCarModels;
    static List<Customer> allCustomers;
    static List<Reservation> allReservations;

    private static DB_List instance;

    private DB_List() {
        allBranches = new ArrayList<>();
        allCars = new ArrayList<>();
        allCarModels = new ArrayList<>();
        allCustomers = new ArrayList<>();
        allReservations = new ArrayList<>();
    }

    public static DB_List getInstance() {
        if (instance == null) {
            instance = new DB_List();
        }
        return instance;
    }


    @Override
    public boolean customerExists(long id) {
        return false;
    }

    @Override
    public long addCustomer(ContentValues newCustomer) {
        return 0;
    }

    @Override
    public long addModel(ContentValues newModel) {
        return 0;
    }

    @Override
    public long addCar(ContentValues newCar) {
        return 0;
    }

    @Override
    public List<Car> returnAllCars() {
        return null;
    }

    @Override
    public List<CarModel> returnAllCarModels() {
        return null;
    }

    @Override
    public List<Branch> returnAllBranches() {
        return null;
    }

    @Override
    public List<Customer> returnAllCustomers() {
        return null;
    }
}
