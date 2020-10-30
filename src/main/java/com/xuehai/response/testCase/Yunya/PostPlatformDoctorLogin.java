package com.xuehai.response.testCase.Yunya;

import com.xuehai.base.AssertHandler;
import com.xuehai.base.BaseTest;
import com.xuehai.base.Log;
import com.xuehai.model.Entity;
import com.xuehai.response.Assertion.YunyaAssertion.PostDoctorLoginAssertion;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Iterator;

public class PostPlatformDoctorLogin extends BaseTest {
    Log logger=new Log(PostPlatformDoctorLogin.class);
    private static HashMap<String, AssertHandler> assertMap = new HashMap<String, AssertHandler>();
    static {
        assertMap.put("first", new PostDoctorLoginAssertion());
    }

    @BeforeSuite
    public void beforeSuite(ITestContext context) {
        super.setUpBeforeSuite(context);
    }

    @BeforeClass
    @Parameters({"testCasePath"})
    public void beforeClass(@Optional("src/test/resources/case_DoctorLogin.xml") String testCasePath) {
        super.setUpBeforeClass(testCasePath);
    }

    @Test(dataProvider = "data", description = "用户登录(医生)")
    public void action(Entity entity) {
        super.execute(entity, assertMap);

    }

    @DataProvider(name = "data")
    public Iterator<Object[]> initData() {
        return super.getDataIterator();
    }

}
