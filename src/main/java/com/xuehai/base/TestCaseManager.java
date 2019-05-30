package com.xuehai.base;

import com.xuehai.model.Entity;
import com.xuehai.model.Mock;
import com.xuehai.model.TestCase;
import com.xuehai.util.Utils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.mockserver.model.Parameter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCaseManager {
	private static final Log LOGGER = new Log(TestCaseManager.class);
	
	public static TestCase getTestCase(String filePath, Class<?> targetClass) {
		TestCase testCase = new TestCase();
		try {
			testCase.setName(targetClass.getName());
			File inputXML = new File(filePath);
			if (inputXML.exists()) {
				SAXReader sax = new SAXReader();
				Document doc = sax.read(inputXML);
				Element root = doc.getRootElement();
				String domain = root.elementText("domain");
				List<Element> cases = root.elements("case");
				boolean isFind = false;
				for (Element e : cases) {
					String cName = e.attributeValue("class");
					if (cName.equals(targetClass.getName())) {
						isFind=true;
						String name = e.attributeValue("name");
						List<Entity> entityList=getTestCase(e, domain);
						testCase.setName(name);
						testCase.setEntityList(entityList);
						LOGGER.info("测试用例: \"" + testCase.getName() + "\" 实例初始化成功");
						break;
					}
				}
				if (!isFind) {
					LOGGER.error("case节点不存在,测试类: \"" + targetClass.getName() + "\" 用例加载失败,"
							+ "文件路径: \"" + filePath + "\"");
				}
			} else {
				LOGGER.error("用例文件不存在,测试类: \"" + targetClass.getName() + "\" 用例加载失败,"
							+ "文件路径: \"" + filePath + "\"");
			}
		} catch (DocumentException e) {
			LOGGER.error("文件解析出错,测试类: \"" + targetClass.getName() + "\" 用例加载失败,文件路径: \"" + filePath + "\"", e);
		}
		return testCase;
	}
	
	private static List<Entity> getTestCase(Element e, String domain){
		List<Entity> entityList = new ArrayList<Entity>();
		Map<String,String> headerMap = new HashMap<String,String>();
		Element request = e.element("request");
		if (request != null) {
			Element header = request.element("header");
			if (header != null) {
				List<Element> headerElements = header.elements();
				if (headerElements != null) {
					if (headerElements.size() > 0) {
						for (Element headerElement : headerElements) {
							String key = headerElement.getName();
							String value = headerElement.getText().trim();
							headerMap.put(key, value);
						}
					}
				}
			}
		} else {
			LOGGER.error("Request节点不存在");
		}
		Element dataList = e.element("dataList");
		if (dataList != null) {
			List<Element> dataElements = dataList.elements();
			if (dataElements != null) {
				if (dataElements.size() > 0) {
					String url = request.elementText("url");
					String method = request.elementText("method");
					//String queryString=request.elementText("queryString");
					if (method != null && !"".equals(method)) {
						method = method.toUpperCase();
					}
					String urlParam = request.elementText("urlParam");
					String sign = request.elementText("sign");
					for (Element dataElement : dataElements) {
						String id = dataElement.attributeValue("id");
						String description = dataElement.attributeValue("description");
						String queryString = Utils.trim(dataElement.elementText("queryString"));
						String authToken = dataElement.elementText("authToken");
						Entity entity = new Entity();
						entity.setId(id);
						entity.setDescription(description);
						entity.setDomain(domain);
						entity.setUrl(url);
						entity.setMethod(method);
						entity.setUrlParam(urlParam);
						entity.setHeader(headerMap);
						entity.setQueryString(queryString);
						entity.setAuthToken(authToken);
						if (sign != null && !"".equals(sign))
							entity.setSign(Boolean.valueOf(sign));
						Element mockElement = dataElement.element("mock");
						if (mockElement != null) {
							boolean isMock = Boolean.valueOf(mockElement.attributeValue("isMock")); 
							if (isMock) {
								Mock mock = new Mock();
								mock.setMock(isMock);
								String path = mockElement.elementText("path");
								mock.setPath(path);
								String methodType = mockElement.elementText("method");
								mock.setMethod(methodType);
								Element parametersElement = mockElement.element("parameters");
								if (parametersElement != null) {
									List<Element> parameters = parametersElement.elements();
									List<Parameter> list = new ArrayList<Parameter>();
									for (Element parameter : parameters) {
										String key = parameter.getName();
										String value = parameter.getText();
										Parameter para = new Parameter(key, value);
										list.add(para);
									}
									mock.setParameters(list);
								}
								String requestBody = mockElement.elementText("requestBody");
								mock.setRequestBody(requestBody);
								String responseCode = mockElement.elementText("responseCode");
								mock.setResponseCode(Integer.valueOf(responseCode));
								String responseData = mockElement.elementText("responseData");
								mock.setResponseData(responseData);
								entity.setMock(mock);
							}
						}
						String body = Utils.trim(dataElement.elementText("body"));
						entity.setBodyData(body);
						String assertion = Utils.trim(dataElement.elementText("assertion"));
						entity.setAssertion(assertion);
						entityList.add(entity);
					}
				}
			}else{
				LOGGER.error("\"dataList\" 节点下不存在子节点");
			}
		}else{
			LOGGER.error("\"dataList\" 节点不存在");
		}
		return entityList;
	}
	
}
