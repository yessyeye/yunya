package com.xuehai.response.Assertion;

import com.alibaba.fastjson.JSONObject;
import com.xuehai.base.AssertHandler;

import static org.testng.AssertJUnit.assertEquals;

public class PostPlatformLoginAssertion extends AssertHandler {

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
