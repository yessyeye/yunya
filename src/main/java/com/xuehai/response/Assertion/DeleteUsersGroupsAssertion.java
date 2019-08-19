package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.DeleteUsersGroupsModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/28 9:00 PM
 */
public class DeleteUsersGroupsAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        DeleteUsersGroupsModel deleteUsersGroupsModel = new Gson().fromJson(responseJson, DeleteUsersGroupsModel.class);
        int code = deleteUsersGroupsModel.getResponseCode();
        assertEquals(code, 204);
    }
}
