package com.boylab.roomhelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.boylab.roomhelp.dao.LoginUserDao;
import com.boylab.roomhelp.model.AcceptUser;
import com.boylab.roomhelp.model.LoginUser;
import com.boylab.roomhelp.room.BoyRoom;
import com.boylab.roomhelp.utils.ThreadSwitch;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private LoginUserDao loginUserDao = null;

    private List<LoginUser> query = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginUserDao = BoyRoom.newInstance(MainActivity.this).loginUserDao();

        findViewById(R.id.btn_Insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        LoginUser loginUser = new LoginUser();
                        loginUser.setUser("boylab");
                        loginUser.setPwd("111111");
                        loginUser.setCreateTime(System.currentTimeMillis());

                        // TODO: 2019/7/30 第一次插入数据不报错，第二次插入数据会报错
                        try {
                            loginUserDao.insert(loginUser);
                        }catch (Exception e){
                            e.printStackTrace();
                            Log.i(">>>microape>>", ">>>数据重复！");
                        }
                        query = loginUserDao.query();
                    }

                    @Override
                    public void onPostResult() {
                        for (LoginUser loginUser2:query) {
                            Log.i(">>>microape>>", ">>>run: "+loginUser2.toString());
                        }
                    }
                });
            }
        });

        findViewById(R.id.btn_InsertOther).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        LoginUser loginUser = new LoginUser();
                        loginUser.setUser("boylab1");
                        loginUser.setPwd("123456");
                        loginUser.setCreateTime(System.currentTimeMillis());

                        // TODO: 2019/7/30 重复插入数据不报错，
                        loginUserDao.insertIgnore(loginUser);

                        query = loginUserDao.query();
                    }

                    @Override
                    public void onPostResult() {
                        for (LoginUser loginUser2:query) {
                            Log.i(">>>microape>>", ">>>run: "+loginUser2.toString());
                        }
                    }
                });
            }
        });

        findViewById(R.id.btn_InsertReplace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        LoginUser loginUser = new LoginUser();
                        loginUser.setUser("boylab2");
                        loginUser.setPwd("123456");
                        loginUser.setCreateTime(System.currentTimeMillis());

                        // TODO: 2019/7/30 重复插入数据不报错，覆盖数据
                        loginUserDao.insertReplace(loginUser);

                        query = loginUserDao.query();
                    }

                    @Override
                    public void onPostResult() {
                        for (LoginUser loginUser2:query) {
                            Log.i(">>>microape>>", ">>>run: "+loginUser2.toString());
                        }
                    }
                });
            }
        });

        findViewById(R.id.btn_Delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        query = loginUserDao.query();
                        Log.i(">>>microape>>", ">>>删除: "+query.get(0).toString());
                        loginUserDao.delete(query.get(0));

                        query = loginUserDao.query();
                    }

                    @Override
                    public void onPostResult() {
                        for (LoginUser loginUser2:query) {
                            Log.i(">>>microape>>", ">>>run: "+loginUser2.toString());
                        }
                    }
                });
            }
        });

        findViewById(R.id.btn_DeleteSome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        // TODO: 2019/8/1 联级删除

                        query = loginUserDao.query();
                    }

                    @Override
                    public void onPostResult() {
                        for (LoginUser loginUser2:query) {
                            Log.i(">>>microape>>", ">>>run:查询 "+loginUser2.toString());
                        }
                    }
                });

            }
        });

        findViewById(R.id.btn_Query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        query = loginUserDao.query();
                        for (LoginUser loginUser2:query) {
                            Log.i(">>>microape>>", ">>>run:查询 "+loginUser2.toString());
                        }
                    }

                    @Override
                    public void onPostResult() {

                    }
                });
            }
        });

        findViewById(R.id.btn_QueryByColumn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        query = loginUserDao.queryByUser("boylab");
                        for (LoginUser loginUser2:query) {
                            Log.i(">>>microape>>", ">>>run:查询 "+loginUser2.toString());
                        }
                    }

                    @Override
                    public void onPostResult() {

                    }
                });
            }
        });

        findViewById(R.id.btn_LikeQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        query = loginUserDao.queryLike();
                        for (LoginUser loginUser2:query) {
                            Log.i(">>>microape>>", ">>>run:查询 "+loginUser2.toString());
                        }
                    }

                    @Override
                    public void onPostResult() {

                    }
                });
            }
        });

        findViewById(R.id.btn_BetweenQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        query = loginUserDao.queryBetween();
                        for (LoginUser loginUser2:query) {
                            Log.i(">>>microape>>", ">>>run:查询 "+loginUser2.toString());
                        }
                    }

                    @Override
                    public void onPostResult() {

                    }
                });
            }
        });

        findViewById(R.id.btn_AvgQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        double queryAvg = loginUserDao.queryAvg();
                        Log.i(">>>microape>>", ">>>run: queryAvg = "+queryAvg);
                    }

                    @Override
                    public void onPostResult() {

                    }
                });
            }
        });

        findViewById(R.id.btn_AboveAvgQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        query = loginUserDao.queryAboveAvg();
                        for (LoginUser loginUser2:query) {
                            Log.i(">>>microape>>", ">>>aboveAvg: "+loginUser2.toString());
                        }
                    }

                    @Override
                    public void onPostResult() {

                    }
                });
            }
        });

        findViewById(R.id.btn_CountQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        long queryCount = loginUserDao.queryCount();
                        Log.i(">>>microape>>", ">>>run: queryCount = "+queryCount);
                    }

                    @Override
                    public void onPostResult() {

                    }
                });
            }
        });

        findViewById(R.id.btn_FirstQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        long queryFirst = loginUserDao.queryFitst();
                        Log.i(">>>microape>>", ">>>run: queryFirst = "+queryFirst);
                    }

                    @Override
                    public void onPostResult() {

                    }
                });
            }
        });

        findViewById(R.id.btn_LastQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        long queryLast = loginUserDao.queryLast();
                        Log.i(">>>microape>>", ">>>run: queryLast = "+queryLast);
                    }

                    @Override
                    public void onPostResult() {

                    }
                });
            }
        });

        findViewById(R.id.btn_MaxQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        long queryMax = loginUserDao.queryMax();
                        Log.i(">>>microape>>", ">>>run: queryMax = "+queryMax);
                    }

                    @Override
                    public void onPostResult() {

                    }
                });
            }
        });

        findViewById(R.id.btn_MinQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        long queryMin = loginUserDao.queryMin();
                        Log.i(">>>microape>>", ">>>run: queryMin = "+queryMin);
                    }

                    @Override
                    public void onPostResult() {

                    }
                });
            }
        });

        findViewById(R.id.btn_SumQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {
                        long querySum = loginUserDao.querySum();
                        Log.i(">>>microape>>", ">>>run: querySum = "+querySum);
                    }

                    @Override
                    public void onPostResult() {

                    }
                });
            }
        });

        findViewById(R.id.btn_GroupByQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThreadSwitch().onSwitch(new ThreadSwitch.ThreadListener() {
                    @Override
                    public void onBackground() {

                        // TODO: 2019/8/1 最后一个未成功 、待解决
                        List<AcceptUser> acceptUsers = loginUserDao.queryGroupBy();
                        for (AcceptUser acceptUser:acceptUsers) {
                            Log.i(">>>microape>>", ">>>run:查询 "+acceptUser.toString());
                        }
                        
                    }

                    @Override
                    public void onPostResult() {

                    }
                });
            }
        });

    }
}
