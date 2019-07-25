package com.boylab.roomhelp.dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.boylab.roomhelp.model.LoginUser;

/**
 * Author pengle on 2019/7/25 16:27
 * Email  pengle609@163.com
 */
public interface RoomDao<T> {

    void insert(T... t);

    void delete(T... t);

    void query();
    /*void queryByColumn();
    void queryCount();*/

    void update(T... t);

}
