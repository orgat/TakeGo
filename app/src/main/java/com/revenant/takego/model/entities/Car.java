package com.revenant.takego.model.entities;

/**
 * Created by Or on 20-Dec-17.
 */

public class Car {
    private String model;
    private long defaultBranchNumber;
    private double mileage;
    private long carId;

    public Car(String model, long defaultBranchNumber, double mileage, long carId) {
        this.model = model;
        this.defaultBranchNumber = defaultBranchNumber;
        this.mileage = mileage;
        this.carId = carId;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getDefaultBranchNumber() {
        return defaultBranchNumber;
    }

    public void setDefaultBranchNumber(long defaultBranchNumber) {
        this.defaultBranchNumber = defaultBranchNumber;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        String car = "Car ID: " + carId + "\n"
                + "Model: " + model + "\n"
                + "Default branch number: " + defaultBranchNumber + "\n"
                + "Mileage: "+ mileage;
        return car;
    }
}
