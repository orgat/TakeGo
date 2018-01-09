package com.revenant.takego.model.backend;

import android.content.ContentValues;

import com.revenant.takego.model.entities.*;

/**
 * Created by Or on 30-Dec-17.
 */

public class Constants {

    public static class BranchConst {
        public static final String ADDRESS = "address";
        public static final String PARKING_SPACES = "parkingSpaces";
        public static final String BRANCH_NUMBER = "branchNumber";
    }

    public static class CarConst {
        public static final String MODEL = "model";
        public static final String DEFAULT_BRANCH_NUMBER = "defualtBranchNumber";
        public static final String KILOMETERS_COUNT = "kilometersCount";
        public static final String ID = "_id";
    }

    public static class CarModelConst {
        public static final String MODEL_NUMBER = "modelNumber";
        public static final String BRAND = "brand";
        public static final String MODEL_NAME = "modelName";
        public static final String ENGINE_SIZE = "engineSize";
        public static final String GEAR_TYPE = "gearType";
        public static final String SEATS = "seats";
    }

    public static class CustomerConst {
        public static final String NAME = "name";
        public static final String LAST_NAME = "lastName";
        public static final String ID = "_id";
        public static final String PHONE_NUMBER = "phoneNumber";
        public static final String EMAIL = "email";
        public static final String CREDIT_CARD = "creditCard";
    }

    public static class ReservationConst {
        public static final String CUSTOMER_NUMBER = "customerNumber";
        public static final String IS_OPEN = "isOpen";
        public static final String NUMBER_OF_CARS = "numberOfCars";
        public static final String RENT_BEGINNING = "rentBeginning";
        public static final String RENT_END = "rentEnd";
        public static final String PRE_KM_COUNT = "preKMCount";
        public static final String POST_KM_COUNT = "postKMCount";
        public static final String WAS_REFUELED = "wasRefueled";
        public static final String LITERS_REFUELED = "litersRefueled";
    }

    public static ContentValues BranchToContentValues(Branch branch) {
        ContentValues cv = new ContentValues();
        cv.put(BranchConst.ADDRESS, branch.getAddress());
        cv.put(BranchConst.PARKING_SPACES, branch.getParkingSpaces());
        cv.put(BranchConst.BRANCH_NUMBER, branch.getBranchNumber());

        return cv;
    }

    public static ContentValues CarToContentValues(Car car) {
        ContentValues cv = new ContentValues();
        cv.put(CarConst.ID, car.getCarId());
        cv.put(CarConst.DEFAULT_BRANCH_NUMBER, car.getDefaultBranchNumber());
        cv.put(CarConst.KILOMETERS_COUNT, car.getKilometersCount());
        cv.put(CarConst.MODEL, car.getModel());

        return cv;
    }

    public static ContentValues CarModelToContentValues(CarModel carModel) {
        ContentValues cv = new ContentValues();
        cv.put(CarModelConst.GEAR_TYPE, carModel.getGearType().toString());
        cv.put(CarModelConst.BRAND, carModel.getBrand());
        cv.put(CarModelConst.ENGINE_SIZE, carModel.getEngineSize());
        cv.put(CarModelConst.MODEL_NAME, carModel.getModelName());
        cv.put(CarModelConst.MODEL_NUMBER, carModel.getModelNumber());
        cv.put(CarModelConst.SEATS, carModel.getSeats());
        return cv;
    }

    public static ContentValues CustomerToContentValues(Customer customer) {
        ContentValues cv = new ContentValues();
        cv.put(CustomerConst.ID, customer.getId());
        cv.put(CustomerConst.CREDIT_CARD, customer.getCreditCard());
        cv.put(CustomerConst.EMAIL, customer.getEmail());
        cv.put(CustomerConst.NAME, customer.getName());
        cv.put(CustomerConst.LAST_NAME, customer.getLastName());
        cv.put(CustomerConst.PHONE_NUMBER, customer.getPhoneNumber());
        return cv;
    }

    public static ContentValues ReservationToContentValues(Reservation reservation){
        ContentValues cv = new ContentValues();
        cv.put(ReservationConst.CUSTOMER_NUMBER,reservation.getCustomerNumber());
        cv.put(ReservationConst.IS_OPEN,reservation.isOpen());
        cv.put(ReservationConst.LITERS_REFUELED,reservation.getLitersRefueled());
        cv.put(ReservationConst.WAS_REFUELED,reservation.wasRefueled());
        cv.put(ReservationConst.PRE_KM_COUNT,reservation.getPreKMCount());
        cv.put(ReservationConst.POST_KM_COUNT,reservation.getPostKMCount());
        cv.put(ReservationConst.RENT_BEGINNING,reservation.getRentBeginning().toString());
        cv.put(ReservationConst.RENT_END,reservation.getRentEnd().toString());
    }

    public static CarModel ContentValuesToCarModel(ContentValues cv) {

        CarModel carModel = new CarModel();

        carModel.setGearType(CarModel.Gear.valueOf(cv.getAsString(CarModelConst.GEAR_TYPE)));

    }

}
