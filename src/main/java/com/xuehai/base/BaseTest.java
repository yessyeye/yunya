package com.xuehai.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.xuehai.model.Entity;
import com.xuehai.model.TestCase;
import com.xuehai.model.TestCase.CaseResult;
import com.xuehai.report.ExtentManager;
import com.xuehai.util.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.testng.Assert.assertEquals;

public class BaseTest {
    private final Log logger = new Log(getClass());
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    private boolean flag = true;
    private boolean isMethodExecuted = false;
    private TestCase testCase;
    // public static String accessTokenValue;


    protected void setUpBeforeSuite(ITestContext context) {
        if (extent == null) {
            //String suiteName = context.getSuite().getName();
            String suiteName = "ApiTestReport";
            long now = System.currentTimeMillis();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String formatDate = dateFormat.format(now);
            StringBuilder reportPath = new StringBuilder();
            String reportDir = (String) Utils.getConfigProperties("report_path");
            //System.out.print("******"+reportDir);
            File file = new File(reportDir);
            if (!file.exists()) {
                file.mkdir();
            }
            reportPath.append(System.getProperty("user.dir"))
                    .append("/")
                    .append(reportDir)
                    .append(suiteName)
                    //	.append(formatDate)
                    .append(".html");
            extent = ExtentManager.getInstance(reportPath.toString());
        }
    }

    protected void setUpBeforeClass(String testCasePath) {
        logger.info("测试类: \"" + getClass() + "\" 开始执行");
        testCase = TestCaseManager.getTestCase(testCasePath, getClass());
        ExtentTest parent = extent.createTest(testCase.getName());
        parentTest.set(parent);
    }

    protected void setUpBeforeMethod(Method method, Object[] parameter) {
        String methodName = getFullMethod(method, parameter);
        logger.info("Method: " + methodName + " 开始执行");
        ExtentTest child = parentTest.get().createNode(methodName);
        test.set(child);
    }

    protected String execute(Entity entity) {
        isMethodExecuted = true;
        return BaseExecutor.execute(entity);
    }

    protected void execute(Entity entity, HashMap<String, AssertHandler> assertMap) {
        isMethodExecuted = true;
        String responseInfo = BaseExecutor.execute(entity);
        logger.info("@@@@@@@@@@@@@@@" + responseInfo);
        String assertion = entity.getAssertion();
        AssertCommand command = new AssertCommand(assertion);
        assertResult(responseInfo, assertMap, command);

    }

    protected String execute2(Entity entity) {

        String responseInfo = BaseExecutor.execute(entity);
        //参数： JSON.parseObject(httpresponse) 转换成JSON的数据;  "$.access_token" ：   json中key的路径，$表示当前json对象
        String responseInfo2 = JSONPath.eval(JSON.parseObject(responseInfo), "$.responseInfo").toString();//
        String accessTokenValue = JSONPath.eval(JSON.parseObject(responseInfo2), "$.accessToken").toString();
        String accessTokenValueNew = "Bearer " + accessTokenValue;
        return accessTokenValueNew;
    }

    protected void tearDownAfterMethod(ITestResult result, Method method, Object[] parameter) {
        logger.info("Method: " + method.getName() + " 执行完毕");
        if (result.getStatus() == ITestResult.FAILURE) {
            if (flag) {
                flag = false;
            }
            logger.error("Result: Failed!", null);
            test.get().fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            if (flag) {
                flag = false;
            }
            logger.error("Result: Skiped!", null);
            test.get().skip(result.getThrowable());
        } else {
            logger.info("Result: Passed!");
            test.get().pass("Test Passed");
        }
    }

    protected void tearDownAfterClass() {
        try {
            logger.info("测试类: \"" + getClass() + "\" 执行完毕");
            String caseName = null;
            if (testCase != null) {
                caseName = testCase.getName();
            }
            if (!isMethodExecuted) {
                logger.info("Result: Skiped!");
                parentTest.get().skip("方法未执行，用例: \"" + caseName + "(" + getClass().getName() +
                        ")" + "\" Skiped!");
                testCase.setResult(CaseResult.SKIP);
            } else {
                if (flag) {
                    logger.info("Result: Passed!");
                    parentTest.get().pass("用例:	\"" + caseName + "(" + getClass().getName() +
                            ")" + "\" Passed!");
                    testCase.setResult(CaseResult.PASS);
                } else {
                    logger.error("Result: Failed!", null);
                    parentTest.get().fail("用例: \"" + caseName + "(" + getClass().getName() +
                            ")" + "\" Failed!");
                    testCase.setResult(CaseResult.FAIL);
                }
            }
            extent.flush();
        } finally {
            logger.info("============================================================");
        }
    }

    protected void tearDownAfterSuite(ITestContext context) {
        String suiteName = context.getSuite().getName();
        logger.info("TestSuite: \"" + suiteName + "\" 执行完毕");
    }

    protected TestCase getTestCase() {
        return testCase;
    }

    protected Iterator<Object[]> getDataIterator() {
        List<Object[]> dataList = new ArrayList<Object[]>();
        if (testCase != null) {
            List<Entity> entityList = testCase.getEntityList();
            if (entityList != null) {
                for (Entity entity : entityList) {
                    dataList.add(new Object[]{entity});
                }
            } else {
                logger.error("EntityList为空,用例数据初始化失败");
            }
        }
        return dataList.iterator();
    }

    private String getFullMethod(Method method, Object[] parameter) {
        String methodName = method.getName();
        if (parameter.length < 1) {
            return methodName + "()";
        } else if (parameter.length == 1) {
            Object obj = parameter[0];
            return methodName + "(" + obj + ")";
        } else {
            StringBuilder temp = new StringBuilder();
            temp.append(methodName).append("(");
            for (Object obj : parameter) {
                temp.append(obj.toString())
                        .append(",");
            }
            temp.append(")");
            return Utils.format(temp).toString();
        }
    }

    protected void assertResult(String responseJson, Map<String, AssertHandler> assertMap, AssertCommand command) {
        int invokeType = command.getInvokeType();
        if (invokeType == 0) {
            JSONObject response = JSONObject.parseObject(responseJson);
            logger.error("返回码：" + "responseJson");
            int actualCode = response.getIntValue("responseCode");
            String content = response.getString("responseInfo");
            String expectResult = command.expectResult();
            String action = command.action();
            int assertType = command.assertType();
            if (expectResult == null || "".equals(expectResult)) {
                expectResult = assertMap.get(action).getExpectResult().toString();
            }

            if (assertType == 0) {
                JSONObject expectJson = JSONObject.parseObject(expectResult);
                int expectCode = expectJson.getIntValue("responseCode");
                if (actualCode == expectCode) {
                    //全量断言
                    logger.info("\r\n执行全量断言！！！");
                    assertEquals(expectJson.getString("responseInfo"), content);
                    flag = true;
                } else {
                    logger.error("响应码错误: expectCode=" + expectCode + ", actualCode=" + actualCode);
                    throw new AssertionError("响应码错误: expectCode=" + expectCode + ", actualCode=" + actualCode);
                }

            } else if (assertType == 1) {
                //部分断言
                logger.info("\r\n执行部分断言！！！");
                String[] keys = command.assertKey();

                JSONObject actualResponseJson = null;
                JSONObject exceptResponseJson = null;
                //最终用来对比的list
                ArrayList<String> actualResponseList = new ArrayList<>();
                ArrayList<String> exceptResponseList = new ArrayList<>();

                ArrayList<JSONObject> actualResponseJsonList = new ArrayList<>();
                ArrayList<JSONObject> exceptResponseJsonList = new ArrayList<>();
                //如果是数组
                try {
                    JSONArray actualResponseJsonArray = JSONObject.parseArray(content.toString());
                    JSONArray exceptResponseJsonArray = JSONObject.parseArray(expectResult);
                    for (String key : keys) {
                        for (int i = 0; i < actualResponseJsonArray.size(); i++) {
                            actualResponseJson = JSONObject.parseObject(actualResponseJsonArray.get(i).toString());
                            actualResponseJsonList.add(actualResponseJson);
                        }
                        for (int i = 0; i < exceptResponseJsonArray.size(); i++) {
                            exceptResponseJson = JSONObject.parseObject(exceptResponseJsonArray.get(i).toString());
                            exceptResponseJsonList.add(exceptResponseJson);
                        }
                        for (int i = 0; i < actualResponseJsonList.size(); i++) {
                            actualResponseList.add(actualResponseJsonList.get(i).get(key).toString());
                        }
                        for (int i = 0; i < exceptResponseJsonList.size(); i++) {
                            exceptResponseList.add(exceptResponseJsonList.get(i).get(key).toString());
                        }
                    }
                    Collections.sort(exceptResponseList);
                    Collections.sort(actualResponseList);
                    logger.info("<<<<期待结果\t" + exceptResponseList);
                    logger.info("<<<<请求结果\t" + actualResponseList);
                    assertEquals(actualResponseList, exceptResponseList);
                    flag = true;
                } catch (Exception e) {
                    // TODO: 如果非数组
                    JSONObject expectJson = JSONObject.parseObject(expectResult);
                    try {
                        expectJson = JSONObject.parseObject(expectResult);
                    } catch (Exception e1) {
                        JSONArray expectJsonArray = JSONObject.parseArray(expectResult);
                        if (expectJsonArray.size() > 0) {
                            expectJson = expectJsonArray.getJSONObject(0);
                        }
                    }

                    JSONObject actualJson = null;
                    //JSONObject responseinfo = null;
                    try {
                        actualJson = JSONObject.parseObject(responseJson);
                        //responseinfo = actualJson.getJSONObject("responseInfo");
                    } catch (Exception e2) {
                        JSONArray actualJsonArray = JSONObject.parseArray(content);
                        if (actualJsonArray.size() > 0) {
                            actualJson = actualJsonArray.getJSONObject(0);
                        }
                    }
                    System.out.println(actualJson);
                    for (String key : keys) {
                        logger.info("expect*******" + expectJson.get(key));
                        logger.info("actual*******" + actualJson.get(key));
                        assertEquals(expectJson.get(key), actualJson.get(key));

                    }
                    logger.info("\r\n>>>>部分断言成功！！");
                    flag = true;
                }


            } else {
                logger.error("Unknown assertType \"" + assertType + "\"");
                throw new AssertionError("Unknown assertType \"" + assertType + "\"");
            }

        } else {
            String action = command.action();
            assertMap.get(action).execAssertion(responseJson);
        }
    }
}
