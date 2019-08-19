package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PatchSessionsTopModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/28 9:12 AM
 */
public class PatchSessionsTopAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        PatchSessionsTopModel patchSessionsTopModel = new Gson().fromJson(responseJson, PatchSessionsTopModel.class);
        int code = patchSessionsTopModel.getResponseCode();
        assertEquals(code, 200);
    }
}
