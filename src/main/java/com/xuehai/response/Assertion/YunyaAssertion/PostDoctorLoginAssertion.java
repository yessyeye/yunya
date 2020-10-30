package com.xuehai.response.Assertion.YunyaAssertion;

import com.alibaba.fastjson.JSONObject;
import com.xuehai.base.AssertHandler;

import static org.testng.Assert.assertEquals;

public class PostDoctorLoginAssertion extends AssertHandler {
    public static String token;

    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        //断言code，取token存到变量
        JSONObject assertJson = JSONObject.parseObject(responseJson);
        int code = assertJson.getIntValue("responseCode");
        assertEquals(code, 200);
        JSONObject responseInfo = assertJson.getJSONObject("responseInfo");
        JSONObject data = responseInfo.getJSONObject("data");
        String token = data.getString("token");
        PostDoctorLoginAssertion.token = token;

    }
}
