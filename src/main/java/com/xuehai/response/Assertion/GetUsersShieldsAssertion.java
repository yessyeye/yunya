package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.GetUsersShieldsModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/22 4:07 PM
 */
public class GetUsersShieldsAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(responseJson);
        GetUsersShieldsModel getUsersShieldsModel = new Gson().fromJson(jsonObject, GetUsersShieldsModel.class);
        int code = getUsersShieldsModel.getResponseCode();
        assertEquals(code, 200);
    }
}
