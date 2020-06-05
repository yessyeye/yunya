package com.xuehai.response.Assertion;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.xuehai.base.AssertHandler;

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
        JSONObject assertJson = JSONObject.parseObject(responseJson);
        int code = assertJson.getIntValue("responseCode");
        assertEquals(code, 200);
        JSONArray responseInfo = assertJson.getJSONArray("responseInfo");
        JSONObject response = (JSONObject) responseInfo.get(0);
        String id = response.getString("id");
        PostFriendsRequestsAssertion.Id = id;
    }
}
