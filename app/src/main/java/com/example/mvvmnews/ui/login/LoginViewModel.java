package com.example.mvvmnews.ui.login;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.mvvmnews.bean.BaseReqData;
import com.example.mvvmnews.bean.login.Reqbean;
import com.example.mvvmnews.bean.login.UserBean;
import com.example.mvvmnews.repository.LoginRepository;

/**
 * @author huanglinqing
 * @project MvvmNews
 * @date 2020/5/26
 * @desc
 */
public class LoginViewModel extends ViewModel {


    private MutableLiveData<Reqbean> reqbeanMutableLiveData = new MutableLiveData<>();


    public LiveData<BaseReqData<UserBean>> loginLiveData = Transformations.switchMap(reqbeanMutableLiveData,
            new Function<Reqbean, LiveData<BaseReqData<UserBean>>>() {
                @Override
                public LiveData<BaseReqData<UserBean>> apply(Reqbean input) {
                    return LoginRepository.login(input.getUserName(), input.getUserPass());
                }
            });


    /**
     * 登录方法
     *
     * @param userName
     * @param userPass
     */
    public void login(String userName, String userPass) {
        Reqbean reqbean = new Reqbean(userName, userPass);
        reqbeanMutableLiveData.setValue(reqbean);
    }


}
