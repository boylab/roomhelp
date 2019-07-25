package com.boylab.roomhelp.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Author pengle on 2019/7/25 15:33
 * Email  pengle609@163.com
 */
@Entity
public class LoginUser {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String user;
    private String pwd;
    private long createTime;

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
}
