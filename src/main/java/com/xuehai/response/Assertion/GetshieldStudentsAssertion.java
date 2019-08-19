package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.GetshieldStudentsModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/6/4 10:46 AM
 */
public class GetshieldStudentsAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(responseJson);
        GetshieldStudentsModel getshieldStudentsModel = new Gson().fromJson(jsonObject, GetshieldStudentsModel.class);
        int code = getshieldStudentsModel.getResponseCode();
        assertEquals(code, 200);
    }
}
