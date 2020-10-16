package com.example.proiect;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;




@Database(entities = {CartiDatab.class}, version = 1, exportSchema = false)
public abstract class CartiDatabase extends RoomDatabase {

    public final static String DB_NAME = "imprumutate.db";
    private static CartiDatabase bookDB;

    public static CartiDatabase getInstance(Context context) {
        if (bookDB == null) {
            bookDB = Room.databaseBuilder(context, CartiDatabase.class, DB_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return bookDB;
    }
    public abstract CartiDAO getCartiDao();

}
