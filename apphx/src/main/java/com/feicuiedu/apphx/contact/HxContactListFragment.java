package com.feicuiedu.apphx.contact;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.feicuiedu.apphx.chat.HxChatActivity;
import com.hyphenate.EMContactListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMContactManager;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.ui.EaseContactListFragment;
import com.hyphenate.exceptions.HyphenateException;

import java.util.HashMap;
import java.util.List;

/**
 * 联系人列表页面,基于EaseUI实现的
 * <p>
 * 作者：yuanchao on 2016/10/11 0011 16:42
 * 邮箱：yuanchao@feicuiedu.com
 */
public class HxContactListFragment extends EaseContactListFragment implements EMContactListener {
    private EMContactManager mEMContactManager; // 联系人管理APi
    private List<String> contacts; // 联系人集合(从环信服务器获取到的)

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        setContactListItemClickListener(new EaseContactListItemClickListener() {
            @Override public void onListItemClicked(EaseUser user) {
                HxChatActivity.open(getContext(),user.getUsername());
            }
        });
    }

    // EaseChatFragment 聊天
    // EaseConversationListFragment 会话
    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 自定制UI
        customUi();
        // 联系人监听
        mEMContactManager = EMClient.getInstance().contactManager();
        mEMContactManager.setContactListener(this);
        asyncGetContactsFromServer();
    }

    @Override public void onDestroy() {
        super.onDestroy();
        mEMContactManager.removeContactListener(this);
    }

    private void customUi() {
        super.hideTitleBar();
    }

    private void asyncGetContactsFromServer() {
        Runnable runnable = new Runnable() {
            @Override public void run() {
                try {
                    // 从环信服务器获取到所有联系人
                    contacts = mEMContactManager.getAllContactsFromServer();
                    // 刷新联系人
                    refreshContacts();
                } catch (HyphenateException e) {
                    Log.d("apphx", "asyncGetContactsFromServer! Exception");
                }
            }
        };
        new Thread(runnable).start();
    }

    private void refreshContacts() {
        HashMap<String, EaseUser> hashMap = new HashMap<>();
        for (String hxId : contacts) {
            EaseUser easeUser = new EaseUser(hxId);
            hashMap.put(hxId, easeUser);
        }
        // 设置当前视图上的联系人
        super.setContactsMap(hashMap);
        // 刷新当前视图上的联系人
        super.refresh();
    }

    // 联系人监听 start ----------------------------------------
    // 添加联系人
    @Override public void onContactAdded(String s) {
        contacts.add(s);
        refreshContacts();
    }

    // 删除联系人
    @Override public void onContactDeleted(String s) {
        contacts.remove(s);
        refreshContacts();
    }

    // 收到好友邀请
    @Override public void onContactInvited(String s, String s1) {
        // TODO: 2016/10/11 0011 显示好友邀请信息(同意，拒绝的交互按钮)
    }

    // 好友请求被同意
    @Override public void onContactAgreed(String s) {
        // TODO: 2016/10/11 0011 当对方同意你的好友申请, 显示对方已接受
    }

    // 好友请求被拒绝
    @Override public void onContactRefused(String s) {
        // TODO: 2016/10/11 0011 当对方拒绝你的好友申请，显示对方已拒绝(一般不做处理)
    }
    // 联系人监听 end ----------------------------------------
}
