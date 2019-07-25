package com.boylab.roomhelp.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.boylab.roomhelp.model.LoginUser;

/**
 * Author pengle on 2019/7/25 15:48
 * Email  pengle609@163.com
 */
@Dao
public interface LoginUserDao extends RoomDao<LoginUser> {

    @Override
    @Insert
    void insert(LoginUser... t);

    @Override
    @Delete
    void delete(LoginUser... t);

    @Override
    @Query("select * from loginuser" )
    void query();

    @Override
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(LoginUser... t);
}
