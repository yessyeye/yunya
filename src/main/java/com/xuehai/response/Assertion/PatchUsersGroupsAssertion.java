package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PatchUsersGroupsModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/28 8:50 PM
 */
public class PatchUsersGroupsAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        PatchUsersGroupsModel patchUsersGroupsModel = new Gson().fromJson(responseJson, PatchUsersGroupsModel.class);
        int code = patchUsersGroupsModel.getResponseCode();
        assertEquals(code, 204);
    }
}
