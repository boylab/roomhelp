package com.boylab.roomhelp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Ignore;

/**
 * Author pengle on 2019/7/31 14:58
 * Email  pengle609@163.com
 */
public class AcceptUser {

    @ColumnInfo(name = "pwd")
    private String pwd;

    @ColumnInfo(name = "SUM(loginuser.id)")
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

    @Override
    public String toString() {
        return "AcceptUser{" +
                "pwd='" + pwd + '\'' +
                ", sum=" + sum +
                '}';
    }
}
