package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PostFriendsRequestsAssertionModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/28 4:28 PM
 */
public class PostFriendsRequestsAssertion extends AssertHandler {
    public static String Id;

    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        JsonObject assertJson = (JsonObject) new JsonParser().parse(responseJson);
        PostFriendsRequestsAssertionModel postFriendsRequestsAssertionModel = new Gson().fromJson(String.valueOf(assertJson), PostFriendsRequestsAssertionModel.class);
        int code = postFriendsRequestsAssertionModel.getResponseCode();
        assertEquals(code, 200);
        String id = String.valueOf(postFriendsRequestsAssertionModel.getResponseInfo().get(0).getId());
        PostFriendsRequestsAssertion.Id = id;
    }
}
