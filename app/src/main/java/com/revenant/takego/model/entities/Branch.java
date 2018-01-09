package com.revenant.takego.model.entities;

/**
 * Created by Or on 20-Dec-17.
 */

public class Branch {
    private String address;
    private int parkingSpaces;
    private long branchNumber;

    public Branch(String address, int parkingSpaces, long branchNumber) {
        this.address = address;
        this.parkingSpaces = parkingSpaces;
        this.branchNumber = branchNumber;
    }

    public Branch() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(int parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public long getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(long branchNumber) {
        this.branchNumber = branchNumber;
    }



}
