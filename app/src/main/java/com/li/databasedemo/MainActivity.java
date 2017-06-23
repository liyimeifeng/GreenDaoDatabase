package com.li.databasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBManager dbManager = DBManager.getInstance(this);
        for (int i = 0;i < 5;i ++){
            User user = new User();
//            user.setId((long)i);
            user.setAge(i *3);
            user.setAnme("第" + i + "人");
            dbManager.insertUser(user);
        }

        List<User> userList = dbManager.queryUserList();
        for (User user : userList){
            Log.e(TAG, "queryUserList---before---id>"  + user.getId() + "--age--" + user.getAge() + "--name--" + user.getAnme() );
            if (user.getId() == 0){
                dbManager.deleteUser(user);
            }

            if (user.getAge() ==3){
                user.setAge(10);
                dbManager.updateUser(user);
            }
        }
        
        userList = dbManager.queryUserList();
        for (User user : userList){
            Log.e(TAG, "queryUserList-- after-->" + user.getId() + "--age--" + user.getAge() +"--name--" + user.getAnme() );
        }

    }
}
