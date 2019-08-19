package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PostUsersShieldsModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/29 11:25 AM
 */
public class PostUsersShieldsAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        PostUsersShieldsModel postUsersShieldsModel = new Gson().fromJson(responseJson, PostUsersShieldsModel.class);
        int code = postUsersShieldsModel.getResponseCode();
        assertEquals(code, 204);
    }
}
