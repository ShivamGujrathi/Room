package com.example.room;

import android.content.Context;
import android.os.Build;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MainData.class},version=1,exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    private static RoomDB database;
    private static String DATABASE_NAME="databse";
    //creating the instance for room database
    public synchronized static RoomDB getInstance(Context context){
        //its checks databse is null then create the instance of ddatabase
        if(database==null)
        {
            database= Room.databaseBuilder(context.getApplicationContext(),
                    RoomDB.class,DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build();
        }
        //here if instance of the database does not  already exist then new will be created
        return database;//else use existing one
    }
    public abstract MainDao mainDao();
}
