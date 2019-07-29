package com.boylab.roomhelp.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.lang.annotation.Inherited;

/**
 * Author pengle on 2019/7/25 15:33
 * Email  pengle609@163.com
 */
@Entity(indices = {@Index(value = {"user"}, unique = true)})
public class LoginUser {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @NonNull
    private String user;
    @NonNull
    private String pwd;
    private long createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
