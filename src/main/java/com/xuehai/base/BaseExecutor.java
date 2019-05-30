package com.xuehai.base;

import com.xuehai.model.Entity;
import com.xuehai.model.Mock;
import com.xuehai.util.Utils;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.Parameter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseExecutor {
    private static Log LOGGER = new Log(BaseExecutor.class);
    private static ClientAndServer clientAndServer;
    private static HttpRequest httpRequest;
    private static HttpResponse httpResponse;

    public static String execute(Entity entity) {
        String responseInfo = null;
        String domain = entity.getDomain();
        String url = entity.getUrl();
        String method = entity.getMethod();
        String urlParam = entity.getUrlParam();
        Map<String, String> header = entity.getHeader();
        String queryString = entity.getQueryString();
        String bodyData = entity.getBodyData();
        Mock mock = entity.getMock();
        if (!domain.startsWith("http://")) {
            domain = "http://" + domain;
        }
        if (urlParam != null && !"".equals(urlParam)) {
            String[] urlParamArray = urlParam.split(",");
            Map<String, String> urlParamMap = new HashMap<String, String>();
            for (String param : urlParamArray) {
                String[] temp = param.split("=");
                if (temp.length == 2)
                    urlParamMap.put(temp[0], temp[1]);
            }
            Pattern pattern = Pattern.compile("\\{.+?\\}");
            Matcher matcher = pattern.matcher(url);
            while (matcher.find()) {
                String temp = matcher.group();
                String dataKey = temp.replace("{", "").replace("}", "");
                String value = urlParamMap.get(dataKey);
                if (value != null && !"".equals(value)) {
                    url = url.replace(temp, value);
                }
            }
        }
        if (mock != null && mock.isMock()) {
            clientAndServer = new ClientAndServer(8090);
            domain = "http://127.0.0.1:8090";
            httpRequest = HttpRequest.request();
            httpResponse = HttpResponse.response();
            String methodType = mock.getMethod();
            if (methodType != null && !"".equals(methodType)) {
                httpRequest = httpRequest.withMethod(methodType);
            }
            String path = mock.getPath();
            if (path != null && !"".equals(path)) {
                if (path.contains("{") || path.contains("}")) {
                    httpRequest = httpRequest.withPath(url);
                } else {
                    httpRequest = httpRequest.withPath(path);
                }
            }
            List<Parameter> parameters = mock.getParameters();
            for (Parameter parameter : parameters) {
                if (parameter != null) {
                    httpRequest = httpRequest.withQueryStringParameter(parameter);
                }
            }
            String requestBody = mock.getRequestBody();
            if (requestBody != null && !"".equals(requestBody)) {
                httpRequest = httpRequest.withBody(requestBody);
            }
            int responseCode = mock.getResponseCode();
            if (responseCode > 0) {
                httpResponse = httpResponse.withStatusCode(responseCode);
            }
            String responseData = mock.getResponseData();
            if (responseData != null && !"".equals(responseData)) {
                httpResponse = httpResponse.withBody(responseData);
            }
            clientAndServer.when(httpRequest).respond(httpResponse);
        }
        String httpUrl = "";
        StringBuilder urlTemp = new StringBuilder();
        if (entity.needSign()) {
            String authToken = entity.getAuthToken();
            httpUrl = Utils.getRequestSignature(method, urlTemp.append(domain).append(url).toString(), queryString, bodyData, authToken);
        } else {
            urlTemp.append(domain).append(url);
            if (queryString != null && !"".equals(queryString))
                urlTemp.append("?").append(queryString);
            httpUrl = urlTemp.toString();
        }
        try {
            switch (method.toUpperCase()) {
                case "GET":
                    responseInfo = HttpClientDispatch.getInstance().sendHttpGet(httpUrl, header);
                    break;
                case "POST":
                    responseInfo = HttpClientDispatch.getInstance().sendHttpPost(httpUrl, bodyData, header);
                    break;
                case "PUT":
                    responseInfo = HttpClientDispatch.getInstance().sendHttpPut(httpUrl, bodyData, header);
                    break;
                case "DELETE":
                    responseInfo = HttpClientDispatch.getInstance().sendHttpDelete(httpUrl, bodyData, header);
                    break;
                case "PATCH":
                    responseInfo = HttpClientDispatch.getInstance().sendHttpPatch(httpUrl, bodyData, header);
                    break;
                default:
                    LOGGER.error("Undefined Method Type");
                    break;
            }
        } catch (ClientProtocolException e) {
            LOGGER.error("请求失败，客户端协议出错", e);
        } catch (ParseException e) {
            LOGGER.error("请求失败，解析出错", e);
        } catch (IOException e) {
            LOGGER.error("请求失败", e);
        }


        return responseInfo;


    }

}
