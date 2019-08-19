package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PostGroupsbatchModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/22 4:03 PM
 */
public class PostGroupsbatchAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        PostGroupsbatchModel postGroupsbatchModel = new Gson().fromJson(responseJson, PostGroupsbatchModel.class);
        int code = postGroupsbatchModel.getResponseCode();
        assertEquals(code, 200);

    }
}
