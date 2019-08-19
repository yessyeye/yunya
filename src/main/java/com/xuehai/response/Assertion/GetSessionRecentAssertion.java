package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.GetSessionRecentModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/22 4:18 PM
 */
public class GetSessionRecentAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        GetSessionRecentModel getSessionRecentModel = new Gson().fromJson(responseJson, GetSessionRecentModel.class);
        int code = getSessionRecentModel.getResponseCode();
        assertEquals(code, 200);
    }
}
