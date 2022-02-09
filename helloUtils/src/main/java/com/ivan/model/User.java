package com.ivan.model;

import com.alibaba.fastjson.JSON;

/**
 * @author hylu.ivan
 * @date 2022/2/9 下午9:35
 * @description
 */
public class User implements java.io.Serializable{

    // setting -> editor -> Inspection -> java -> serialization issues -> serializable class without "serialVersionUID" 设置提示，然后alt + enter自动生成
    private static final long serialVersionUID = -7888646945608498424L;
    private String username;
    private String password;
    // 被transient修饰的属性不会参加序列化也不会被objectOutputStream记录
//    private transient String phonenum;
    private String phonenum;

    public User() {
    }

    public User(String username, String password, String phonenum) {
        this.username = username;
        this.password = password;
        this.phonenum = phonenum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

