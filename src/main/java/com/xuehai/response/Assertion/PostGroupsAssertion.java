package com.xuehai.response.Assertion;

import com.alibaba.fastjson.JSONObject;
import com.xuehai.base.AssertHandler;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/28 8:40 PM
 */
public class PostGroupsAssertion extends AssertHandler {
    public static String Id;

    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        JSONObject assertJson = JSONObject.parseObject(responseJson);
        int code = assertJson.getIntValue("responseCode");
        JSONObject responseInfo = assertJson.getJSONObject("responseInfo");
        String id = responseInfo.getString("id");
        PostGroupsAssertion.Id = id;
        assertEquals(code, 200);
    }
}
