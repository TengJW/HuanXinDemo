package com.feicuiedu.hxdemo.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.feicuiedu.hxdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：yuanchao on 2016/10/11 0011 14:21
 * 邮箱：yuanchao@feicuiedu.com
 */

public class RegisterFragment extends DialogFragment{

    private Unbinder mUnbinder;

    @BindView(R.id.edit_username) EditText etUserName;
    @BindView(R.id.edit_password)EditText etPassword;
    @BindView(R.id.button_confirm) Button btnConfirm;
    @BindView(R.id.progress_bar)ProgressBar mProgressBar;

    // 用来create视图
    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 设置一下对话框是无标题模式
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return inflater.inflate(R.layout.fragment_register,container,false);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
