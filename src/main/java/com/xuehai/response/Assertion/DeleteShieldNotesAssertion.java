package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.DeleteShieldNotesModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/29 11:01 AM
 */
public class DeleteShieldNotesAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        DeleteShieldNotesModel deleteShieldNotesModel = new Gson().fromJson(responseJson, DeleteShieldNotesModel.class);
        int code = deleteShieldNotesModel.getResponseCode();
        assertEquals(code, 204);
    }
}
