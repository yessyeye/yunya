package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PatchMessagesReadAckModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/27 11:06 AM
 */
public class PatchMessagesReadAckAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        PatchMessagesReadAckModel patchMessagesReadAckModel = new Gson().fromJson(responseJson, PatchMessagesReadAckModel.class);
        int code = patchMessagesReadAckModel.getResponseCode();
        assertEquals(code, 204);
    }
}
