package com.example.mvvmnews.bean.login;

/**
 * @author huanglinqing
 * @project MvvmNews
 * @date 2020/5/26
 * @desc 请求数据实体
 */
public class Reqbean {

    private String userName;

    private String userPass;

    public Reqbean(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }
}
