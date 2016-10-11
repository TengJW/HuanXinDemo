package com.feicuiedu.hxdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    // 做一个Splash页面  (启动页面)
    // 1. 注册Button  -->   RegisterFragment (DialogFragment)
    // 2. 登录Button  -->   LoginFragment    (DialogFragment)
    // 成功进入HomeActivity
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // 注册
        // EMClient.getInstance().createAccount();
        // 登录
        // EMClient.getInstance().login();
    }
}
