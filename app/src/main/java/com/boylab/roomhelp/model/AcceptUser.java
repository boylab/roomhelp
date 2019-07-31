package com.boylab.roomhelp.model;

import android.arch.persistence.room.ColumnInfo;

/**
 * Author pengle on 2019/7/31 14:58
 * Email  pengle609@163.com
 */
public class AcceptUser {

    @ColumnInfo(name = "pwd")
    private String pwd;

    @ColumnInfo(name = "sum(loginuser.pwd)")
    private int sum;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
