package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PatchShieldsCancelModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/30 7:56 PM
 */
public class PatchShieldsCancelAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        PatchShieldsCancelModel patchShieldsCancelModel = new Gson().fromJson(responseJson, PatchShieldsCancelModel.class);
        int code = patchShieldsCancelModel.getResponseCode();
        assertEquals(code, 204);
    }
}
