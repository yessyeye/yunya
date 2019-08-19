package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.GetMessagesUnreadModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/27 10:59 AM
 */
public class GetMessagesUnreadAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        GetMessagesUnreadModel getMessagesUnreadModel=new Gson().fromJson(responseJson,GetMessagesUnreadModel.class);
        int code = getMessagesUnreadModel.getResponseCode();
        assertEquals(code, 200);
    }
}
