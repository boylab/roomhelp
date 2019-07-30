package com.boylab.roomhelp.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.boylab.roomhelp.model.LoginUser;
import com.boylab.roomhelp.model.Student;

import java.util.List;

/**
 * Author pengle on 2019/7/25 15:48
 * Email  pengle609@163.com
 */
@Dao
public interface LoginUserDao extends RoomDao<LoginUser> {

    @Override
    @Insert
    void insert(LoginUser... t);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertReplace(LoginUser... t);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertIgnore(LoginUser... t);

    @Override
    @Delete
    void delete(LoginUser... t);

    @Override
    @Query("select * from loginuser" )
    List<LoginUser> query();

    @Query("select * from loginuser where loginuser.user = :user" )
    List<LoginUser> queryByUser(String user);

    @Override
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(LoginUser... t);
}
