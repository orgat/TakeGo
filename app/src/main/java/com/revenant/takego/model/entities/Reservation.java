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

}
