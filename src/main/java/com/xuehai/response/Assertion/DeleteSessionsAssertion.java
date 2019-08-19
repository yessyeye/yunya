package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.DeleteSessionsModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/29 4:01 PM
 */
public class DeleteSessionsAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        DeleteSessionsModel deleteSessionsModel = new Gson().fromJson(responseJson, DeleteSessionsModel.class);
        int code = deleteSessionsModel.getResponseCode();
        assertEquals(code, 204);
    }
}
