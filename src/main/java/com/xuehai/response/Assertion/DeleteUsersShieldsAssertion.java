package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.DeleteUsersShieldsModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/8/18 1:58 PM
 */
public class DeleteUsersShieldsAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        DeleteUsersShieldsModel deleteUsersShieldsModel = new Gson().fromJson(responseJson, DeleteUsersShieldsModel.class);
        int code = deleteUsersShieldsModel.getResponseCode();
        assertEquals(code, 204);
    }
}
