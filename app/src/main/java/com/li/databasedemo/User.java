package com.li.databasedemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by Lee on 2017/6/23 0023.
 *
 * 创建bean之后编译一下既能自动生成get/set方法以及Dao类文件
 */

@Entity
public class User {
    @Id(autoincrement=true) //只能设置Long型主键，自增长模式
    private Long id;
    private String name;
    private int age;
    @Generated(hash = 1309193360)
    public User(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAnme() {
        return this.name;
    }
    public void setAnme(String anme) {
        this.name = anme;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
