package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PatchMessagesRevokeModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/29 2:39 PM
 */
public class PatchMessagesRevokeAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        PatchMessagesRevokeModel patchMessagesRevokeModel = new Gson().fromJson(responseJson, PatchMessagesRevokeModel.class);
        int code = patchMessagesRevokeModel.getResponseCode();
        assertEquals(code, 200);
    }
}
