package com.boylab.roomhelp.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.boylab.roomhelp.model.AcceptUser;
import com.boylab.roomhelp.model.LoginUser;

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

    @Query("select * from loginuser where loginuser.user like 'label%'" )
    List<LoginUser> queryLike();

    @Query("select * from loginuser where loginuser.user between \"lable\" AND \"label2\" ")
    List<LoginUser> queryBetween();

    @Query("select avg(loginuser.createTime) as OrderAverage from loginuser " )
    long queryAvg();

    @Query("select * from loginuser where loginuser.createTime > (select avg(loginuser.createTime) from loginuser) " )
    List<LoginUser> queryAboveAvg();

    @Query("select count(loginuser.pwd) from loginuser where loginuser.pwd = \"123456\"" )
    int queryCount();

    @Query("select loginuser.id from loginuser where loginuser.id = (select min(loginuser.createTime) from loginuser)" )
    long queryFitst();

    @Query("select loginuser.id from loginuser where loginuser.id = (select max(loginuser.createTime) from loginuser) " )
    long queryLast();

    @Query("select max(loginuser.createTime) from loginuser " )
    long queryMax();

    @Query("select min(loginuser.createTime) from loginuser " )
    long queryMin();

    @Query("select sum(loginuser.id) from loginuser " )
    int querySum();

    @Query("select loginuser.pwd, sum(loginuser.pwd) from loginuser group by loginuser.pwd" )
     List<AcceptUser> queryGroupBy();

    @Override
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(LoginUser... t);
}
