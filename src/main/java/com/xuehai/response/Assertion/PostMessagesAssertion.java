package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PostMessagesModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/27 11:26 AM
 */
public class PostMessagesAssertion extends AssertHandler {
    public static String msgId;

    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        PostMessagesModel postMessagesModel = new Gson().fromJson(responseJson, PostMessagesModel.class);
        int code = postMessagesModel.getResponseCode();
        assertEquals(code, 200);
        //取msgId，给其他方法调用
        String msgId = String.valueOf(postMessagesModel.getResponseInfo().getMsgId());
        PostMessagesAssertion.msgId = msgId;

    }
}
