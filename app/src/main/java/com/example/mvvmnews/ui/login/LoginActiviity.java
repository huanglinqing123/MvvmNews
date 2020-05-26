package com.example.mvvmnews.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.mvvmnews.MainActivity;
import com.example.mvvmnews.R;
import com.example.mvvmnews.bean.BaseReqData;
import com.example.mvvmnews.bean.login.UserBean;
import com.example.mvvmnews.config.HttpConfig;
import com.example.mvvmnews.databinding.ActivityLoginActiviityBinding;

/**
 * @author huanglinqing
 * @data 05.26
 * @desc 登录页面Activity
 */
public class LoginActiviity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    ActivityLoginActiviityBinding activityLoginActiviityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);


        activityLoginActiviityBinding
                = ActivityLoginActiviityBinding.inflate(LayoutInflater.from(this));
        setContentView(activityLoginActiviityBinding.getRoot());



        //登录点击事件
        activityLoginActiviityBinding.btnLongin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.login(getUserName(), getUserPass());
            }
        });

        loginViewModel.loginLiveData.observe(this, new Observer<BaseReqData<UserBean>>() {
            @Override
            public void onChanged(BaseReqData<UserBean> userBeanBaseReqData) {
                if (userBeanBaseReqData.getStatue().equals(HttpConfig.REQUEST_OK)) {
                    showToast(userBeanBaseReqData.getMsg());
                    Intent intent = new Intent(LoginActiviity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    showToast(userBeanBaseReqData.getMsg());
                }
            }
        });

    }

    /**
     * toast 提示
     *
     * @param message 提示内容
     */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取输入框的用户名
     *
     * @return
     */
    private String getUserName() {
        return activityLoginActiviityBinding.edAccunt.getText().toString().trim();
    }

    /**
     * 获取输入框的密码
     *
     * @return
     */
    private String getUserPass() {
        return activityLoginActiviityBinding.edPass.getText().toString().trim();
    }
}
