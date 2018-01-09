package com.revenant.takego.model.entities;

/**
 * Created by Or on 20-Dec-17.
 */

public class Car {
    private String model;
    private long defaultBranchNumber;
    private double kilometersCount;
    private long carId;

    public Car(String model, long defaultBranchNumber, double kilometersCount, long carId) {
        this.model = model;
        this.defaultBranchNumber = defaultBranchNumber;
        this.kilometersCount = kilometersCount;
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

    public double getKilometersCount() {
        return kilometersCount;
    }

    public void setKilometersCount(double kilometersCount) {
        this.kilometersCount = kilometersCount;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }
}
