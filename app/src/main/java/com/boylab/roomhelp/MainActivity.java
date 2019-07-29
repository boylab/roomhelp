package com.boylab.roomhelp;

import android.arch.persistence.room.RoomDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.boylab.roomhelp.dao.LoginUserDao;
import com.boylab.roomhelp.model.LoginUser;
import com.boylab.roomhelp.room.BoyRoom;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_Insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LoginUserDao loginUserDao = BoyRoom.newInstance(MainActivity.this).loginUserDao();

                        List<LoginUser> query = loginUserDao.query();
                        for (LoginUser loginUser2:query) {
                            Log.i(">>>microape>>", ">>>run: "+loginUser2.toString());
                        }

                        for (LoginUser loginUser2:query) {
                            loginUser2.setId(loginUser2.getId()*2);
                            loginUser2.setUser("Hello"+(int)(Math.random()*1000));
                        }

                        LoginUser[] loginUsers = query.toArray(new LoginUser[0]);
                        Log.i(">>>microape>>", ">>>>123>>>>: "+loginUsers.length);
                        //= (LoginUser[]) query.toArray(); m
                        loginUserDao.insert(loginUsers);

                        query = loginUserDao.query();
                        for (LoginUser loginUser2:query) {
                            Log.i(">>>microape>>", ">>>run: "+loginUser2.toString());
                        }




                    }
                }).start();
            }
        });

        findViewById(R.id.btn_InsertOther).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        findViewById(R.id.btn_Delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        findViewById(R.id.btn_DeleteSome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        findViewById(R.id.btn_Query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        findViewById(R.id.btn_QueryByColumn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.empty()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .observeOn(new )
            }
        });

        findViewById(R.id.btn_QueryCount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }
}
