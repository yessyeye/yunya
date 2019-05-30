package com.xuehai.util;

import com.xuehai.model.Entity;

public class OperateEntity {
    public static String authToken;

    public static String getAuthToken(String authtokenValueNew) {
        // TODO Auto-generated method stub
        //获取最新的authToken
        authToken = authtokenValueNew;
        return authToken;

    }

    public static void getEntityValue(Entity entity) {

        String method = entity.getMethod();
        String requestURL = entity.getDomain() + entity.getUrl();
        String queryString = entity.getQueryString();
        System.out.println("初始queryString值：" + entity.getQueryString());
        String body = entity.getBodyData();
        authToken = getAuthToken(authToken);
//		  	String authToken="Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1aWQiOiIzODYxMiIsInN1YiI6ImxzMTA3IiwiY3JlYXRlZCI6eyJlcG9jaFNlY29uZCI6MTU1MDY1MTUzMSwibmFubyI6MTIwMDAwMDB9LCJhdXRob3JpdHkiOm51bGwsImlzcyI6IjZoU05qV0c2M1hmZVRqU1A5azExVTR6Qlh1RXVLaUpDIiwiZXhwIjoxNTUxMjU2MzMxLCJzaWQiOiI5NzBkNGNlY2I2MDM0YWE5OTU5N2E2ODA4ODcxMDFmZCJ9.XnyzhlsIgm0E_AUygKT4kecDuh5woPI5gMsSjWIyWk6iuXrrbmv-n21xwF5SdCxQ50tdbOhqoXZ4ylwgCOj1yw";
        System.out.println(authToken);
        //传参，生成签名
        String signInfo = Utils.getRequestSignature(method, requestURL, queryString, body, authToken);
        //将签名后的信息放到entity的QueryString
        String newQueryString = queryString + signInfo;
        entity.setQueryString(newQueryString);
        System.out.println("最新queryString值：" + entity.getQueryString());
        //给头信息Authorization赋值
        entity.getHeader().replace("Authorization", "?", authToken);
    }


}
