package com.feicuiedu.apphx.conversation;

import android.os.Bundle;

import com.hyphenate.easeui.ui.EaseConversationListFragment;

/**
 * 作者：yuanchao on 2016/10/12 0012 10:31
 * 邮箱：yuanchao@feicuiedu.com
 */

public class HxConversationListFragment extends EaseConversationListFragment{

    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        customUi();
    }

    private void customUi() {
        hideTitleBar();
    }
}
