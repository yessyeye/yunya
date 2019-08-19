package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.GetSessionMessagesModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/22 5:17 PM
 */
public class GetSessionMessagesAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        GetSessionMessagesModel getSessionMessagesModel = new Gson().fromJson(responseJson, GetSessionMessagesModel.class);
        int code = getSessionMessagesModel.getResponseCode();
        assertEquals(code, 200);

    }
}
