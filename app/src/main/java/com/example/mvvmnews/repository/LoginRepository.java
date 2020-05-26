package com.example.mvvmnews.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmnews.bean.BaseReqData;
import com.example.mvvmnews.bean.login.UserBean;
import com.example.mvvmnews.config.HttpConfig;
import com.example.mvvmnews.config.UserConfig;

/**
 * @author huanglinqing
 * @project MvvmNews
 * @date 2020/5/26
 * @desc 登录 仓库 这里模拟网络请求获取的数据
 */
public class LoginRepository {

    public static MutableLiveData<BaseReqData<UserBean>> login(String username, String password) {
        BaseReqData baseReqData = new BaseReqData();
        if (username.equals(UserConfig.USER_NAME) && password.equals(UserConfig.USER_PASS)) {
            UserBean userBean = new UserBean();
            userBean.setNickName(username);
            userBean.setPassword(password);
            baseReqData.setBody(userBean);
            baseReqData.setMsg("登录成功");
            baseReqData.setStatue(HttpConfig.REQUEST_OK);
        } else {
            baseReqData.setMsg("用户名或密码不正确");
            baseReqData.setStatue(HttpConfig.REQUEST_FAILED);
        }
        MutableLiveData<BaseReqData<UserBean>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(baseReqData);
        return mutableLiveData;
    }
}
