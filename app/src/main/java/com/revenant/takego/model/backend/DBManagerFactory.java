package com.revenant.takego.model.backend;

import com.revenant.takego.model.datasource.DB_List;

/**
 * Created by Or on 30-Dec-17.
 */

public class DBManagerFactory {


    public static DB_Manager getDB_List() {
        return DB_List.getInstance();
    }
}
