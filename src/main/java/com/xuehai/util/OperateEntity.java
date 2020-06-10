package com.xuehai.util;

import com.xuehai.model.Entity;

public class OperateEntity {
    public static String authTokenTeacher;
    public static String authTokenStudent;


    public static String getAuthTokenTeacher(String authtokenValueNew) {
        // TODO Auto-generated method stub
        //获取最新的authToken
        authTokenTeacher = authtokenValueNew;
        return authTokenTeacher;

    }

    public static String getAuthTokenStudent(String authtokenValueNew) {
        // TODO Auto-generated method stub
        //获取最新的authToken
        authTokenStudent = authtokenValueNew;
        return authTokenStudent;

    }


    public static void getEntityValueTeacher(Entity entity) {

        String method = entity.getMethod();
        String requestURL = entity.getDomain() + entity.getUrl();
        String queryString = entity.getQueryString();
        System.out.println("初始queryString值：" + entity.getQueryString());
        String body = entity.getBodyData();
        authTokenTeacher = getAuthTokenTeacher(authTokenTeacher);
//		  	String authToken="Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1aWQiOiIzODYxMiIsInN1YiI6ImxzMTA3IiwiY3JlYXRlZCI6eyJlcG9jaFNlY29uZCI6MTU1MDY1MTUzMSwibmFubyI6MTIwMDAwMDB9LCJhdXRob3JpdHkiOm51bGwsImlzcyI6IjZoU05qV0c2M1hmZVRqU1A5azExVTR6Qlh1RXVLaUpDIiwiZXhwIjoxNTUxMjU2MzMxLCJzaWQiOiI5NzBkNGNlY2I2MDM0YWE5OTU5N2E2ODA4ODcxMDFmZCJ9.XnyzhlsIgm0E_AUygKT4kecDuh5woPI5gMsSjWIyWk6iuXrrbmv-n21xwF5SdCxQ50tdbOhqoXZ4ylwgCOj1yw";
        System.out.println(authTokenTeacher);
        //传参，生成签名
        String signInfo = Utils.getRequestSignature(method, requestURL, queryString, body, authTokenTeacher);
        //将签名后的信息放到entity的QueryString
        String newQueryString = queryString + signInfo;
        entity.setQueryString(newQueryString);
        System.out.println("最新queryString值：" + entity.getQueryString());
        //给头信息Authorization赋值
        entity.getHeader().replace("Authorization", "?", authTokenTeacher);
    }

    public static void getEntityValueStudent(Entity entity) {
        String method = entity.getMethod();
        String requestURL = entity.getDomain() + entity.getUrl();
        String queryString = entity.getQueryString();
        System.out.println("初始queryString值：" + entity.getQueryString());
        String body = entity.getBodyData();
        authTokenStudent = getAuthTokenTeacher(authTokenStudent);
        System.out.println(authTokenStudent);
        //传参，生成签名
        String signInfo = Utils.getRequestSignature(method, requestURL, queryString, body, authTokenStudent);
        //将签名后的信息放到entity的QueryString
        String newQueryString = queryString + signInfo;
        entity.setQueryString(newQueryString);
        System.out.println("最新queryString值：" + entity.getQueryString());
        //给头信息Authorization赋值
        entity.getHeader().replace("Authorization", "?", authTokenStudent);
    }

}
