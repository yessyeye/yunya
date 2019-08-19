package com.xuehai.response.Assertion;

import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.PostShieldNotesModel;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author slyart
 * @create 2019/5/29 10:44 AM
 */
public class PostShieldNotesAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        PostShieldNotesModel postShieldNotesModel = new Gson().fromJson(responseJson, PostShieldNotesModel.class);
        int code = postShieldNotesModel.getResponseCode();
        assertEquals(code, 204);
    }
}
