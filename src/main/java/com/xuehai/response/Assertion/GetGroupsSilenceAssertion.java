package com.xuehai.response.Assertion;

import com.alibaba.fastjson.JSONObject;
import com.xuehai.base.AssertHandler;

import static org.testng.AssertJUnit.assertEquals;


/**
 * @Author slyart
 * @create 2020/6/10 1:59 PM
 */
public class GetGroupsSilenceAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        JSONObject assertJson = JSONObject.parseObject(responseJson);
        int code = assertJson.getInteger("responseCode");
        assertEquals(code, 200);

    }
}
