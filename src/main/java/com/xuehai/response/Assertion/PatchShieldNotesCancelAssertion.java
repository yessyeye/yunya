package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PatchShieldNotesCancelModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/30 8:08 PM
 */
public class PatchShieldNotesCancelAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        PatchShieldNotesCancelModel patchShieldNotesCancelModel = new Gson().fromJson(responseJson, PatchShieldNotesCancelModel.class);
        int code = patchShieldNotesCancelModel.getResponseCode();
        assertEquals(code, 204);
    }
}
