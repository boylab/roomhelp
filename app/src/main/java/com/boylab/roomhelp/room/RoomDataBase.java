package com.boylab.roomhelp.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.boylab.roomhelp.model.LoginUser;

/**
 * Author pengle on 2019/7/25 15:26
 * Email  pengle609@163.com
 */
@Database(entities = {LoginUser.class}, version = 1, exportSchema = false)
public abstract class RoomDataBase extends RoomDatabase {

    private static final String DB_NAME = "RoomDataBase.db";
    private static volatile RoomDatabase instance;

    public static synchronized RoomDatabase newInstance(Context context){
        if (instance == null){
            instance  = create(context);
        }
        return instance;
    }

    private static RoomDatabase create(Context context) {
        RoomDatabase roomDatabase = Room.databaseBuilder(context, RoomDatabase.class, DB_NAME).build();
        return roomDatabase;
    }

}
