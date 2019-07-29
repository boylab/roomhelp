package com.boylab.roomhelp.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.boylab.roomhelp.model.Student;
import com.boylab.roomhelp.model.Teacher;

import java.util.List;

/**
 * Author pengle on 2019/7/29 10:45
 * Email  pengle609@163.com
 */
@Dao
public interface TeacherDao extends RoomDao<Teacher>{
    @Override
    @Insert
    void insert(Teacher... t);

    @Override
    @Delete
    void delete(Teacher... t);

    @Override
    @Query("select * from teacher")
    List<Teacher> query();

    @Override
    @Update
    void update(Teacher... t);
}
