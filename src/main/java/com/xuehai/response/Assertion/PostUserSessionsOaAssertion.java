package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PostUserSessionsOaModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/11/28 1:28 PM
 */
public class PostUserSessionsOaAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        JsonObject assertJson = (JsonObject) new JsonParser().parse(responseJson);
        PostUserSessionsOaModel postUserSessionsOaModel = new Gson().fromJson(String.valueOf(assertJson), PostUserSessionsOaModel.class);
        assertEquals(postUserSessionsOaModel.getResponseCode(), 200);
    }
}
