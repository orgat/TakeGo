package com.revenant.takego.model.backend;

import android.content.ContentValues;
import java.util.List;
import com.revenant.takego.model.entities.Branch;
import com.revenant.takego.model.entities.Car;
import com.revenant.takego.model.entities.CarModel;
import com.revenant.takego.model.entities.Customer;
import com.revenant.takego.model.entities.Reservation;


/**
 * Created by Or on 30-Dec-17.
 */

public interface DB_Manager {

    boolean customerExists(long id);
    long addCustomer(ContentValues newCustomer);
    long addModel(ContentValues newModel);
    long addCar(ContentValues newCar);
    long addBranch(ContentValues newBranch);
    long addReservation(ContentValues newReservation);
    long updateCar(ContentValues newCar);

    List<Car> returnAllCars();
    List<CarModel> returnAllCarModels();
    List<Branch> returnAllBranches();
    List<Customer> returnAllCustomers();
    List<Reservation> returnAllReservations();
    List<Car> returnAllFreeCars();




}
