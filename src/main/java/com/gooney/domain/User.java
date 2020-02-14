package com.gooney.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String pwd;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    private int sex;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date create_time;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", create_time=" + create_time +
                ", money=" + money +
                '}';
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }



    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    private float money;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }


}
