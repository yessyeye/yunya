package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.GetFriendsRequestsModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/22 5:26 PM
 */
public class GetFriendsRequestsAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        GetFriendsRequestsModel getFriendsRequestsModel = new Gson().fromJson(responseJson, GetFriendsRequestsModel.class);
        int code = getFriendsRequestsModel.getResponseCode();
        assertEquals(code, 200);
    }
}
