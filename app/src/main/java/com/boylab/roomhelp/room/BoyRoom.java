package com.boylab.roomhelp.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.boylab.roomhelp.dao.LoginUserDao;
import com.boylab.roomhelp.dao.StudentDao;
import com.boylab.roomhelp.dao.TeacherDao;
import com.boylab.roomhelp.model.LoginUser;
import com.boylab.roomhelp.model.Student;
import com.boylab.roomhelp.model.Teacher;

/**
 * Author pengle on 2019/7/25 15:26
 * Email  pengle609@163.com
 */
@Database(entities = {LoginUser.class, Teacher.class, Student.class}, version = 2, exportSchema = false)
public abstract class BoyRoom extends RoomDatabase {

    private static final String DB_NAME = "BoyRoom.db";
    private static volatile BoyRoom instance;

    public static synchronized BoyRoom newInstance(Context context){
        if (instance == null){
            instance  = create(context);
        }
        return instance;
    }

    private static BoyRoom create(Context context) {
        BoyRoom roomDatabase = Room.databaseBuilder(context, BoyRoom.class, DB_NAME).build();
        return roomDatabase;
    }

    public abstract LoginUserDao loginUserDao();

    public abstract TeacherDao teacherDao();

    public abstract StudentDao studentDao();


}
