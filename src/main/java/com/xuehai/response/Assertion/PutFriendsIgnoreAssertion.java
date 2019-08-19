package com.xuehai.response.Assertion;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PutFriendsIgnoreModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/6/3 3:48 PM
 */
public class PutFriendsIgnoreAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        JsonElement assertJson = new JsonParser().parse(responseJson);
        PutFriendsIgnoreModel putFriendsIgnoreModel = new Gson().fromJson(assertJson, PutFriendsIgnoreModel.class);
        int code = putFriendsIgnoreModel.getResponseCode();
        assertEquals(code, 204);
    }
}
