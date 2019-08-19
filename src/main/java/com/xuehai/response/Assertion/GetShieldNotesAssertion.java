package com.xuehai.response.Assertion;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.GetShieldNotesModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/22 4:13 PM
 */
public class GetShieldNotesAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        JsonObject assertJson = (JsonObject) new JsonParser().parse(responseJson);
        GetShieldNotesModel getShieldNotesModel = new Gson().fromJson(assertJson, GetShieldNotesModel.class);
        int code = getShieldNotesModel.getResponseCode();
        assertEquals(code, 200);
    }
}
