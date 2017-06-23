package com.li.demo1;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Lee on 2017/6/23 0023.
 */

public class BaseApplication extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    //配置数据库
    private void setupDatabase(){
        //创建数据库shop.db
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"shop.db",null);
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取Dao对象管理者
         daoSession = daoMaster.newSession();

    }

    public static DaoSession getDaoInstance(){
        return daoSession;
    }
}
