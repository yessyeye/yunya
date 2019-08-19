package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PostGroupsModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/28 8:40 PM
 */
public class PostGroupsAssertion extends AssertHandler {
    public static String Id;

    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        PostGroupsModel postGroupsModel = new Gson().fromJson(responseJson, PostGroupsModel.class);
        int code = postGroupsModel.getResponseCode();
        String id = String.valueOf(postGroupsModel.getResponseInfo().getId());
        PostGroupsAssertion.Id = id;
        assertEquals(code, 200);


    }
}
