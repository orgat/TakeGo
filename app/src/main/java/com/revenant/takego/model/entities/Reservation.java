package com.revenant.takego.model.entities;

import java.util.Date;

/**
 * Created by Or on 20-Dec-17.
 */

public class Reservation {
    private long customerNumber;
    private boolean isOpen;
    private int numberOfCars;
    private Date rentBeginning;
    private Date rentEnd;
    private double preKMCount;
    private double postKMCount;
    private boolean wasRefueled;
    private double litersRefueled;

    public Reservation() {
    }

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public Date getRentBeginning() {
        return rentBeginning;
    }

    public void setRentBeginning(Date rentBeginning) {
        this.rentBeginning = rentBeginning;
    }

    public Date getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(Date rentEnd) {
        this.rentEnd = rentEnd;
    }

    public double getPreKMCount() {
        return preKMCount;
    }

    public void setPreKMCount(double preKMCount) {
        this.preKMCount = preKMCount;
    }

    public double getPostKMCount() {
        return postKMCount;
    }

    public void setPostKMCount(double postKMCount) {
        this.postKMCount = postKMCount;
    }

    public boolean wasRefueled() {
        return wasRefueled;
    }

    public void setWasRefueled(boolean wasRefueled) {
        this.wasRefueled = wasRefueled;
    }

    public double getLitersRefueled() {
        return litersRefueled;
    }

    public void setLitersRefueled(double litersRefueled) {
        this.litersRefueled = litersRefueled;
    }
}
