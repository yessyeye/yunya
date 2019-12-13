package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.GetFriendsJudgeModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/6/3 5:11 PM
 */
public class GetFriendsJudgeAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        JsonObject assertJson = (JsonObject) new JsonParser().parse(responseJson);
        GetFriendsJudgeModel getFriendsJudgeModel = new Gson().fromJson(String.valueOf(assertJson), GetFriendsJudgeModel.class);
        assertEquals(getFriendsJudgeModel.getResponseCode(), 200);
        assertEquals(Boolean.getBoolean(getFriendsJudgeModel.getResponseInfo()), false);

    }
}
