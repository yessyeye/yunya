package com.xuehai.response.Assertion;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.GetShieldStudentNotesModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/6/3 1:37 PM
 */
public class GetShieldStudentNotesAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        JsonObject assertJson = (JsonObject) new JsonParser().parse(responseJson);
        GetShieldStudentNotesModel getShieldStudentNotesModel = new Gson().fromJson(assertJson, GetShieldStudentNotesModel.class);
        int code = getShieldStudentNotesModel.getResponseCode();
        assertEquals(code, 200);

    }
}
