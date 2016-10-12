package com.feicuiedu.apphx;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;

/**
 * 环信相关基础配置
 * 作者：yuanchao on 2016/10/11 0011 11:22
 * 邮箱：yuanchao@feicuiedu.com
 */
public class HxBaseApplication extends Application {

    // 用git管理当前项目，上传到github

    // 1. 去gitbub上新建一个..
    // 2. git管理自己的项目, 远程连接到github, 再push上去

    @Override public void onCreate() {
        super.onCreate();
        // 初始化环信sdk和easeui库
        initEaseUI();
    }

    private void initEaseUI() {
        EMOptions options = new EMOptions();
        options.setAutoLogin(false); // 关闭自动登录
        EaseUI.getInstance().init(this, options);
        // 关闭环信日志
        EMClient.getInstance().setDebugMode(false);
    }
}
