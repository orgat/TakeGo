package com.revenant.takego.model.backend;

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



}
