package com.arnold.www.pojo;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description: 用户实体
 * @Author Arnold
 * @Date 2020/4/19
 * @Version V2.0
 **/
public class User implements Serializable {
    private String id;
    private String name;
    private String sex;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}