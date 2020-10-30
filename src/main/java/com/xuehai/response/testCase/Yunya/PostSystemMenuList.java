package com.xuehai.response.testCase.Yunya;

import com.xuehai.base.AssertHandler;
import com.xuehai.base.BaseTest;
import com.xuehai.base.Log;
import com.xuehai.model.Entity;
import com.xuehai.response.Assertion.YunyaAssertion.PostDoctorLoginAssertion;
import com.xuehai.response.Assertion.YunyaAssertion.PostSystemMenuListAssertion;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author slyart
 * @create 2020/10/30 12:56 PM
 */
public class PostSystemMenuList extends BaseTest {
    Log logger = new Log(PostSystemMenuList.class);
    private static HashMap<String, AssertHandler> assertMap = new HashMap<String, AssertHandler>();

    static {
        assertMap.put("first", new PostSystemMenuListAssertion());
    }

    @BeforeSuite
    public void beforeSuite(ITestContext context) {
        super.setUpBeforeSuite(context);
    }

    @BeforeClass
    @Parameters({"testCasePath1"})
    public void beforeClass(@Optional("src/test/resources/case_test.xml") String testCasePath) {
        super.setUpBeforeClass(testCasePath);
    }

    @Test(dataProvider = "data", description = "获取用户菜单")
    public void action(Entity entity) {
        //如果需要token，去登录接口token替换请求头
        Map<String, String> entity1 = entity.getHeader();
        entity1.replace("Authorization", "?", PostDoctorLoginAssertion.token);
        entity.setHeader(entity1);

        super.execute(entity, assertMap);

    }

    @DataProvider(name = "data")
    public Iterator<Object[]> initData() {
        return super.getDataIterator();
    }
}
