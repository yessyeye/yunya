package com.xuehai.base;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class HttpClientDispatch {
    private static final Log LOGGER = new Log(HttpClientDispatch.class);
    private static RequestConfig requestConfig;
    private static HttpClientDispatch instance;

    public static HttpClientDispatch getInstance() {
        if (instance == null) {
            instance = new HttpClientDispatch();
            setConfig();
        }
        return instance;
    }

    public static HttpClientDispatch getInstance(String hostName, int port) {
        if (instance == null) {
            instance = new HttpClientDispatch();
            setConfig(hostName, port);
        }
        return instance;
    }

    private static RequestConfig setConfig() {
        requestConfig = RequestConfig.custom().setSocketTimeout(5000) // 设置请求获取数据超时5秒
                .setConnectTimeout(30000) // 设置连接超时30秒
                .setConnectionRequestTimeout(5000) // 设置从connect Manager获取Connection超时时间5秒
                .build();
        return requestConfig;
    }

    private static RequestConfig setConfig(String hostName, int port) {
        requestConfig = RequestConfig.custom().setSocketTimeout(5000)
                .setConnectTimeout(30000)
                .setConnectionRequestTimeout(5000)
                .setProxy(new HttpHost(hostName, port)) //设置代理（主机名+端口）
                .build();
        return requestConfig;
    }

    public String sendHttpGet(String httpUrl)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpRequest = new HttpGet(httpUrl);
        return sendHttpGet(httpRequest, new HashMap<String, String>());
    }

    public String sendHttpGet(String httpUrl, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpRequest = new HttpGet(httpUrl);
        return sendHttpGet(httpRequest, header);
    }

    private String sendHttpGet(HttpRequestBase httpRequest, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String responseInfo = null;
        try {
            httpClient = HttpClients.createDefault();
            httpRequest.setConfig(requestConfig);
            for (Map.Entry<String, String> entry : header.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                httpRequest.setHeader(key, value);
            }
            String requestInfo = getRequestInfo(httpRequest);
            LOGGER.info(">>> 请求信息: " + requestInfo);
            response = httpClient.execute(httpRequest);
            responseInfo = getResponseInfo(response);

//			String responseInfoValue= JSONPath.eval(JSON.parseObject(responseInfo), "$.responseInfo").toString();
//			if (responseInfoValue.startsWith("http://")) {
//				responseInfoValue = "\"" + responseInfoValue+"\"";
//			}
//			LOGGER.info(">>> responseInfoValue信息: " + responseInfoValue);
            LOGGER.info(">>> 响应信息: " + responseInfo);
            String fullInfo = getFullInfo(requestInfo, responseInfo);
            LOGGER.info(">>> 接口请求/响应信息: " + fullInfo);
        } finally {
            if (response != null)
                response.close();
            if (httpClient != null)
                httpClient.close();
        }
        return responseInfo;
    }

    public String sendHttpPost(String httpUrl)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpRequest = new HttpPost(httpUrl);
        return sendHttpPost(httpRequest, new HashMap<String, String>());
    }

    public String sendHttpPost(String httpUrl, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpRequest = new HttpPost(httpUrl);
        return sendHttpPost(httpRequest, header);
    }

    public String sendHttpPost(String httpUrl, String data, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpRequest = new HttpPost(httpUrl);
        StringEntity stringEntity = new StringEntity(data, "UTF-8");
        ((HttpPost) httpRequest).setEntity(stringEntity);
        return sendHttpPost(httpRequest, header);
    }

    public String sendHttpPost(String httpUrl, Map<String, File> map, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpRequest = new HttpPost(httpUrl);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        for (Map.Entry<String, File> entry : map.entrySet()) {
            String key = entry.getKey();
            File file = entry.getValue();
            FileBody fileBody = new FileBody(file);
            builder.addPart(key, fileBody);
        }
        HttpEntity reqEntity = builder.build();
        ((HttpPost) httpRequest).setEntity(reqEntity);
        return sendHttpPost(httpRequest, header);
    }

    private String sendHttpPost(HttpRequestBase httpRequest, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String responseInfo = null;
        try {
            httpClient = HttpClients.createDefault();
            httpRequest.setConfig(requestConfig);
            for (Map.Entry<String, String> entry : header.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                httpRequest.setHeader(key, value);
            }
            String requestInfo = getRequestInfo(httpRequest);
            LOGGER.info(">>> 请求信息: " + requestInfo);
            HttpEntity entity = ((HttpPost) httpRequest).getEntity();
            String bodyInfo = null;
            if (entity != null) {
                bodyInfo = EntityUtils.toString(entity);
            }
            LOGGER.info(">>> 请求Body信息: " + bodyInfo);
            response = httpClient.execute(httpRequest);
            responseInfo = getResponseInfo(response);
            LOGGER.info(">>> 响应信息: " + responseInfo);
            String fullInfo = getFullInfo(requestInfo, bodyInfo, responseInfo);
            LOGGER.info(">>> 接口请求/响应信息: " + fullInfo);
        } finally {
            if (response != null)
                response.close();
            if (httpClient != null)
                httpClient.close();
        }
        return responseInfo;
    }

    public String sendHttpDelete(String httpUrl)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpRequest = new HttpDelete(httpUrl);
        return sendHttpDelete(httpRequest, new HashMap<String, String>());
    }

    public String sendHttpDelete(String httpUrl, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpRequest = new HttpDelete(httpUrl);
        return sendHttpDelete(httpRequest, header);
    }

    public String sendHttpDelete(String httpUrl, String data, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpRequest = new HttpDelete(httpUrl);
        StringEntity stringEntity = new StringEntity(data, "UTF-8");
        ((HttpDelete) httpRequest).setEntity(stringEntity);
        return sendHttpDelete(httpRequest, header);
    }

    private String sendHttpDelete(HttpRequestBase httpRequest, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String responseInfo = null;
        try {
            httpClient = HttpClients.createDefault();
            httpRequest.setConfig(requestConfig);
            for (Map.Entry<String, String> entry : header.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                httpRequest.setHeader(key, value);
            }
            String requestInfo = getRequestInfo(httpRequest);
            LOGGER.info(">>> 请求信息: " + requestInfo);
            HttpEntity entity = ((HttpDelete) httpRequest).getEntity();
            String bodyInfo = null;
            if (entity != null) {
                bodyInfo = EntityUtils.toString(entity);
            }
            LOGGER.info(">>> 请求Body信息: " + bodyInfo);
            response = httpClient.execute(httpRequest);
            responseInfo = getResponseInfo(response);
            LOGGER.info(">>> 响应信息: " + responseInfo);
            String fullInfo = getFullInfo(requestInfo, bodyInfo, responseInfo);
            LOGGER.info(">>> 接口请求/响应信息: " + fullInfo);
        } finally {
            if (response != null)
                response.close();
            if (httpClient != null)
                httpClient.close();
        }
        return responseInfo;
    }

    public String sendHttpPut(String httpUrl)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpPut = new HttpPut(httpUrl);
        return sendHttpPut(httpPut, new HashMap<String, String>());
    }

    public String sendHttpPut(String httpUrl, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpPut = new HttpPut(httpUrl);
        return sendHttpPut(httpPut, header);
    }

    public String sendHttpPut(String httpUrl, String data, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpPut = new HttpPut(httpUrl);
        StringEntity stringEntity = new StringEntity(data, "UTF-8");
        ((HttpPut) httpPut).setEntity(stringEntity);
        return sendHttpPut(httpPut, header);
    }

    private String sendHttpPut(HttpRequestBase httpRequest, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String responseInfo = null;
        try {
            httpClient = HttpClients.createDefault();
            httpRequest.setConfig(requestConfig);
            for (Map.Entry<String, String> entry : header.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                httpRequest.setHeader(key, value);
            }
            String requestInfo = getRequestInfo(httpRequest);
            LOGGER.info(">>> 请求信息: " + requestInfo);
            HttpEntity entity = ((HttpPut) httpRequest).getEntity();
            String bodyInfo = null;
            if (entity != null) {
                bodyInfo = EntityUtils.toString(entity);
            }
            LOGGER.info(">>> 请求Body信息: " + bodyInfo);
            response = httpClient.execute(httpRequest);
            responseInfo = getResponseInfo(response);
            LOGGER.info(">>> 响应信息: " + responseInfo);
            String fullInfo = getFullInfo(requestInfo, bodyInfo, responseInfo);
            LOGGER.info(">>> 接口请求/响应信息: " + fullInfo);
        } finally {
            if (response != null)
                response.close();
            if (httpClient != null)
                httpClient.close();
        }
        return responseInfo;
    }

    public String sendHttpPatch(String httpUrl)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpRequest = new HttpPatch(httpUrl);
        return sendHttpPatch(httpRequest, new HashMap<String, String>());
    }

    public String sendHttpPatch(String httpUrl, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpRequest = new HttpPatch(httpUrl);
        return sendHttpPatch(httpRequest, header);
    }

    public String sendHttpPatch(String httpUrl, String data, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        HttpRequestBase httpRequest = new HttpPatch(httpUrl);
        StringEntity stringEntity = new StringEntity(data, "UTF-8");
        ((HttpPatch) httpRequest).setEntity(stringEntity);
        return sendHttpPatch(httpRequest, header);
    }

    private String sendHttpPatch(HttpRequestBase httpRequest, Map<String, String> header)
            throws ClientProtocolException, ParseException, IOException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String responseInfo = null;
        try {
            httpClient = HttpClients.createDefault();
            httpRequest.setConfig(requestConfig);
            for (Map.Entry<String, String> entry : header.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                httpRequest.setHeader(key, value);
            }
            String requestInfo = getRequestInfo(httpRequest);
            LOGGER.info(">>> 请求信息: " + requestInfo);
            HttpEntity entity = ((HttpPatch) httpRequest).getEntity();
            String bodyInfo = null;
            if (entity != null) {
                bodyInfo = EntityUtils.toString(entity);
            }
            LOGGER.info(">>> 请求Body信息: " + bodyInfo);
            response = httpClient.execute(httpRequest);
            responseInfo = getResponseInfo(response);
            LOGGER.info(">>> 响应信息: " + responseInfo);
            String fullInfo = getFullInfo(requestInfo, bodyInfo, responseInfo);
            LOGGER.info(">>> 接口请求/响应信息: " + fullInfo);
        } finally {
            if (response != null)
                response.close();
            if (httpClient != null)
                httpClient.close();
        }
        return responseInfo;
    }

    private static String getRequestInfo(HttpRequestBase request) {
        StringBuilder sb = new StringBuilder("{\"url\":\"");
        String url = request.getRequestLine().getUri();
        String method = request.getRequestLine().getMethod();
        sb.append(url)
                .append("\",\"method\":\"")
                .append(method)
                .append("\",")
                .append("\"requestHeader\":{");
        Header[] reqHeader = request.getAllHeaders();
        for (Header header : reqHeader) {
            String value = header.getValue();
            value = value.replaceAll("\"", "\\\\\"");
            sb.append("\"")
                    .append(header.getName())
                    .append("\":\"")
                    .append(value)
                    .append("\",");
        }
        sb.append("}}");
        int index = sb.indexOf(",}");
        while (index > 0) {
            sb.replace(index, index + 1, "");
            index = sb.indexOf(",}");
        }
        ;
        //LOGGER.info("sb.toString为。。。。"+sb.toString());
        return sb.toString();
    }

    private static String getResponseInfo(CloseableHttpResponse response)
            throws ParseException, IOException {
        StringBuilder sb = new StringBuilder("{\"responseCode\":");
        int responseCode = response.getStatusLine().getStatusCode();
        String responseMessage = response.getStatusLine().getReasonPhrase();
        sb.append(responseCode)
                .append(",")
                .append("\"responseMessage\":\"")
                .append(responseMessage)
                .append("\",\"responseHeader\":{");
        Header[] responseHeader = response.getAllHeaders();
        for (Header header : responseHeader) {
            String value = header.getValue();
            value = value.replaceAll("\"", "\\\\\"");
            sb.append("\"")
                    .append(header.getName())
                    .append("\":\"")
                    .append(value)
                    .append("\",");
        }
        sb.append("},\"responseInfo\":");
        HttpEntity responseEntity = response.getEntity();
        String responseInfo = null;
        if (responseEntity != null) {
            responseInfo = EntityUtils.toString(responseEntity, "UTF-8");
            if (responseInfo.contains("F21CBB9A6224B7A903EE6AA91A48F24F.apk")) {
                responseInfo = "\"" + responseInfo + "\"";
            } else if ("".equals(responseInfo)) {
                responseInfo = "\"\"";
            } else if (responseInfo.contains("\"") == false) {
                String ss = "\"";
                responseInfo = ss + responseInfo + ss;
            }
        }
        sb.append(responseInfo)
                .append("}");
        int index = sb.indexOf(",}");
        while (index > 0) {
            sb.replace(index, index + 1, "");
            index = sb.indexOf(",}");
        }

        return sb.toString();
    }

    private static String getFullInfo(String requestInfo, String responseInfo)
            throws ParseException, IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"requestInfo\":")
                .append(requestInfo)
                .append(",\"responseInfo\":")
                .append(responseInfo)
                .append("}");
        return sb.toString();
    }

    private static String getFullInfo(String requestInfo, String bodyInfo, String responseInfo)
            throws ParseException, IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"requestInfo\":")
                .append(requestInfo)
                .append(",\"bodyInfo\":")
                .append(bodyInfo)
                .append(",\"responseInfo\":")
                .append(responseInfo)
                .append("}");
        return sb.toString();

    }

}