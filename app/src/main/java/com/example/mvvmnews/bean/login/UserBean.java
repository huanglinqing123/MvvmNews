package com.example.mvvmnews.bean.login;

/**
 * @author huanglinqing
 * @project MvvmNews
 * @date 2020/5/26
 * @desc 用户数据
 */
public class UserBean {

    private String nickName;
    private String password;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
