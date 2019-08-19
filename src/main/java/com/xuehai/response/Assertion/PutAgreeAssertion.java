package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PutAgreeModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/6/3 5:12 PM
 */
public class PutAgreeAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(responseJson);
        PutAgreeModel putAgreeModel = new Gson().fromJson(jsonObject, PutAgreeModel.class);
        int code = putAgreeModel.getResponseCode();
        assertEquals(code, 200);
    }
}
