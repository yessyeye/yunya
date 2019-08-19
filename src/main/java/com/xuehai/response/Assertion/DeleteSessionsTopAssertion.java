package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.DeleteSessionsTopModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/29 1:45 PM
 */
public class DeleteSessionsTopAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        DeleteSessionsTopModel deleteSessionsTopModel = new Gson().fromJson(responseJson, DeleteSessionsTopModel.class);
        int code = deleteSessionsTopModel.getResponseCode();
        assertEquals(code, 204);
    }
}
