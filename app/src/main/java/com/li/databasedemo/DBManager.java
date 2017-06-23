package com.li.databasedemo;

import android.app.DownloadManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Lee on 2017/6/23 0023.
 * 声明一个数据库管理者单例
 */

public class DBManager {
    private final static String dbName = "test.db";
    private static volatile DBManager mInstance;
    private static Context context;
    private DaoMaster.DevOpenHelper openHelper;

    public DBManager(Context context){
        this.context = context;
        openHelper = new DaoMaster.DevOpenHelper(context,dbName);
    }

    /**
     * 获取单例应用
     * @param context
     * @return
     */
    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 定义一个私有的内部类，在第一次用这个嵌套类时，会创建一个实例。而类型为Instance的类，
     * 只有在Instance.getInstance()中调用，由于私有的属性，他人无法使用Instance，不调用Instance.getInstance()就不会创建实例。
     */
    private static final class Instance{
        private static DBManager instance = new DBManager(context);

    }

    //静态内部类创建单例模式
    public static DBManager getInstance(){
        return Instance.instance;
    }


    /**
     * 获取可读数据
     * @return
     */
    public SQLiteDatabase getReadableDatabase(){
        if (openHelper == null){
            openHelper = new DaoMaster.DevOpenHelper(context,dbName);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;

    }

    /**
     * 可写数据
     * @return
     */
    public SQLiteDatabase getWritabledatabase(){
        if (openHelper == null){
            openHelper = new DaoMaster.DevOpenHelper(context,dbName);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
         return db;
    }


    public void insertUser(User user){
        DaoMaster daoMaster = new DaoMaster(getWritabledatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.insert(user);
    }

    public void insertUserList(List<User> users){
        if (users ==null || users.isEmpty())return ;
        DaoMaster daoMaster = new DaoMaster(getWritabledatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.insertInTx(users);
    }

    public void deleteUser(User user){
        DaoMaster daoMaster = new DaoMaster(getWritabledatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.delete(user);
    }

    public void updateUser(User user){
        DaoMaster daoMaster = new DaoMaster(getWritabledatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao =daoSession.getUserDao();
        userDao.update(user);
    }

    /**
     * 查用户列表
     * @return
     */
    public List<User> queryUserList(){
        DaoMaster daoMaster =new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> qb = userDao.queryBuilder();
        List<User> list = qb.list();
        return list;
    }

    /**
     * 指定条件查询用户
     * @param age
     * @return
     */
    public  List<User> queryUserList(int age){
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> qb = userDao.queryBuilder();
        qb.where(UserDao.Properties.Age.gt(age)).orderAsc(UserDao.Properties.Age);
        List<User> list = qb.list();
        return list;
    }
}
