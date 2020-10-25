package com.market.domain;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private int sex;
    private int age;
    private String work_unit;
    private String phone;
    private String create_date;
    private int user_exp;
    private int level;

    public User(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWork_unit() {
        return work_unit;
    }

    public void setWork_unit(String work_unit) {
        this.work_unit = work_unit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public int getUser_exp() {
        return user_exp;
    }

    public void setUser_exp(int user_exp) {
        this.user_exp = user_exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", work_unit='" + work_unit + '\'' +
                ", phone='" + phone + '\'' +
                ", create_date='" + create_date + '\'' +
                ", user_exp=" + user_exp +
                ", level=" + level +
                '}';
    }
}
