package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PostClientsModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/27 10:27 AM
 */
public class PostClientsAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        PostClientsModel postClientsModel = new Gson().fromJson(responseJson, PostClientsModel.class);
        int code = postClientsModel.getResponseCode();
        assertEquals(code, 200);
    }
}
