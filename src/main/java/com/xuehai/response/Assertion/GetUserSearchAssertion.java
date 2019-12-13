package com.xuehai.response.Assertion;


import com.google.gson.Gson;
import com.xuehai.base.AssertHandler;
import com.xuehai.response.AssertionModel.GetUserSearchModel;
import com.xuehai.util.SQLUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


/**
 * @Author slyart
 * @create 2019/9/3 3:57 PM
 */
public class GetUserSearchAssertion extends AssertHandler {
    @Override
    public String getExpectResult() {
        return null;
    }

    @Override
    public void execAssertion(String responseJson) {
        GetUserSearchModel getUserSearchModel = new Gson().fromJson(responseJson, GetUserSearchModel.class);
        int code = getUserSearchModel.getResponseCode();
        assertEquals(code, 200);
        List<GetUserSearchModel.ResponseInfoBean.ContentBean> content = getUserSearchModel.getResponseInfo().getContent();
        // sql语句
        String sql = "SELECT iUserId  ,sRoles ,sUserName  FROM XHSys_User WHERE sUserName LIKE '%佳%' ORDER BY LENGTH(sUserName) -LENGTH(REPLACE(sUserName,'佳','')) DESC , LENGTH(REPLACE(sUserName,'佳','')),iUserId DESC LIMIT 10";
        // 获取到连接
        Connection conn = SQLUtils.getCon();
        PreparedStatement pst = null;
        //定义一个data接收查询数据
        try {
            pst = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ArrayList<String> list = new ArrayList<String>();
                int id = rs.getInt("iUserId");
                String roles = rs.getString("sRoles");
                String name = rs.getString("sUserName");
                list.add(id + "," + roles + "," + name);
                System.out.println(list);
            }
        } catch (Exception e) {

        }
        System.out.println(content.get(0).getId());
    }
}
