package com.xuehai.response.testCase.Student;

import com.xuehai.base.AssertHandler;
import com.xuehai.base.BaseTest;
import com.xuehai.base.Log;
import com.xuehai.model.Entity;
import com.xuehai.response.Assertion.PostPlatformLoginAssertion;
import com.xuehai.util.OperateEntity;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Iterator;

public class PostPlatformStudentLogin extends BaseTest {
    Log logger=new Log(PostPlatformStudentLogin.class);
    private static HashMap<String, AssertHandler> assertMap = new HashMap<String, AssertHandler>();
    static {
        assertMap.put("first", new PostPlatformLoginAssertion());
    }

    @BeforeSuite
    public void beforeSuite(ITestContext context) {
        super.setUpBeforeSuite(context);
    }

    @BeforeClass
    @Parameters({"testCasePath"})
    public void beforeClass(@Optional("src/test/resources/case_login.xml") String testCasePath) {
        super.setUpBeforeClass(testCasePath);
    }

    @Test(dataProvider = "data", description = "平台用户登录(学生)")
    public void action(Entity entity) {
        super.execute(entity, assertMap);
        //获取登陆后的authToken值，并传到基础类中
        String AuthtokenValueNew = super.execute2(entity);
        OperateEntity.getAuthTokenStudent(AuthtokenValueNew);

    }

    @DataProvider(name = "data")
    public Iterator<Object[]> initData() {
        return super.getDataIterator();
    }

}
