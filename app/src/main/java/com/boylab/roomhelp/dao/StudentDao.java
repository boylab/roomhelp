package com.boylab.roomhelp.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.boylab.roomhelp.model.Student;

import java.util.List;

/**
 * Author pengle on 2019/7/29 10:45
 * Email  pengle609@163.com
 */
@Dao
public interface StudentDao extends RoomDao<Student>{
    @Override
    @Insert
    void insert(Student... t);

    @Override
    @Delete
    void delete(Student... t);

    @Override
    @Query("select * from student")
    List<Student> query();

    @Override
    @Update
    void update(Student... t);
}
