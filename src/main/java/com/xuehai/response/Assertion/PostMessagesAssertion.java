package com.xuehai.response.Assertion;

import com.alibaba.fastjson.JSONObject;
import com.xuehai.base.AssertHandler;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/27 11:26 AM
 */
public class PostMessagesAssertion extends AssertHandler {
    public static String msgId;

    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        JSONObject assertJson = JSONObject.parseObject(responseJson);
        int code = assertJson.getIntValue("responseCode");
        assertEquals(code, 200);
        //取msgId，给其他方法调用
        JSONObject responseInfo = assertJson.getJSONObject("responseInfo");
        String msgId = responseInfo.getString("msgId");
        PostMessagesAssertion.msgId = msgId;

    }
}
