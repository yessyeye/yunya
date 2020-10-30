package com.xuehai.response.Assertion.YunyaAssertion;

import com.alibaba.fastjson.JSONObject;
import com.xuehai.base.AssertHandler;

import static org.testng.Assert.assertEquals;

public class PostSystemMenuListAssertion extends AssertHandler {
    public static String token;

    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        JSONObject assertJson = JSONObject.parseObject(responseJson);
        int code = assertJson.getIntValue("responseCode");
        assertEquals(code, 200);

    }
}
