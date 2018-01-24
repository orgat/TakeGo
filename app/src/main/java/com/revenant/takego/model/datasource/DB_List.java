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
        for(Customer customer : allCustomers){
            if(customer.getId()==id){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Car> returnAllFreeCars() {
        return null;
    }

    @Override
    public long updateCar(ContentValues newCar) {
        return 0;
    }

    @Override
    public long addCustomer(ContentValues newCustomer) {
        Customer customer = ContentValuesToCustomer(newCustomer);
        allCustomers.add(customer);

        return customer.getId();
    }

    @Override
    public long addModel(ContentValues newModel) {
        CarModel carModel = ContentValuesToCarModel(newModel);
        allCarModels.add(carModel);
        return carModel.getModelNumber();
    }

    @Override
    public long addCar(ContentValues newCar) {
        Car car = ContentValuesToCar(newCar);
        allCars.add(car);
        return car.getCarId();

    }

    @Override
    public long addBranch(ContentValues newBranch){
        Branch branch =ContentValuesToBranch(newBranch);
        allBranches.add(branch);
        return branch.getBranchNumber();
    }

    @Override
    public long addReservation(ContentValues newReservation){
        Reservation reservation = ContentValuesToReservation(newReservation);
        allReservations.add(reservation);
        return reservation.getReservationNumber();
    }


    @Override
    public List<Car> returnAllCars() {
        return allCars;
    }

    @Override
    public List<CarModel> returnAllCarModels() {
        return allCarModels;
    }

    @Override
    public List<Branch> returnAllBranches() {
        return allBranches;
    }

    @Override
    public List<Customer> returnAllCustomers() {
        return allCustomers;
    }

    @Override
    public List<Reservation> returnAllReservations() {return allReservations;}
}
