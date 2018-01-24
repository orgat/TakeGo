package com.revenant.takego.model.backend;

import android.content.Context;

import com.revenant.takego.model.datasource.DB_List;
import com.revenant.takego.model.datasource.DB_SQL;

/**
 * Created by Or on 30-Dec-17.
 */

public class DBManagerFactory {


    public static DB_Manager getDB_List() {
        return DB_List.getInstance();
    }
    public static DB_Manager getDB_SQL() {return DB_SQL.getInstance();}
}
