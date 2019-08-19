package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.DeleteFriendsModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/6/3 2:22 PM
 */
public class DeleteFriendsAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        JsonElement assertJson = new JsonParser().parse(responseJson);
        DeleteFriendsModel deleteFriendsModel = new Gson().fromJson(assertJson, DeleteFriendsModel.class);
        int code = deleteFriendsModel.getResponseCode();
        assertEquals(code, 204);

    }
}
