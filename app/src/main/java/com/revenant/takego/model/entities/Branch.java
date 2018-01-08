package com.revenant.takego.model.entities;

/**
 * Created by Or on 20-Dec-17.
 */

public class Branch {
    private Branch.Address address;
    private int parkingSpaces;
    private long branchNumber;

    public Branch(Address address, int parkingSpaces, long branchNumber) {
        this.address = address;
        this.parkingSpaces = parkingSpaces;
        this.branchNumber = branchNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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

    public class Address {
        private String city;
        private String street;
        private long houseNumber;

        public Address(String city, String street, long houseNumber) {
            this.city = city;
            this.street = street;
            this.houseNumber = houseNumber;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public long getHouseNumber() {
            return houseNumber;
        }

        public void setHouseNumber(long houseNumber) {
            this.houseNumber = houseNumber;
        }
    }
}
