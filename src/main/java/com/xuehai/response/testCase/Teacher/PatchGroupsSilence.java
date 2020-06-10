package com.xuehai.response.testCase.Teacher;

import com.xuehai.base.AssertHandler;
import com.xuehai.base.BaseTest;
import com.xuehai.base.Log;
import com.xuehai.model.Entity;
import com.xuehai.response.Assertion.PatchGroupsSilenceAssertion;
import com.xuehai.response.Assertion.PostGroupsAssertion;
import com.xuehai.util.OperateEntity;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author slyart
 * @create 2020/6/10 2:40 PM
 */
public class PatchGroupsSilence extends BaseTest {
    Log logger = new Log(PatchGroupsSilence.class);
    private static HashMap<String, AssertHandler> assertMap = new HashMap<String, AssertHandler>();

    static {
        assertMap.put("first", new PatchGroupsSilenceAssertion());
    }

    @BeforeSuite
    public void beforeSuite(ITestContext context) {
        super.setUpBeforeSuite(context);
    }

    @BeforeClass
    @Parameters({"testCasePath1"})
    public void beforeClass(@Optional("src/test/resources/case.xml") String testCasePath) {
        super.setUpBeforeClass(testCasePath);
    }

    @Test(dataProvider = "data", description = "切换全群禁言")
    public void action(Entity entity) {
        String entity1 = entity.getUrl().replace("*", PostGroupsAssertion.Id);
        entity.setUrl(entity1);
        //获取加签名后的entity中最新queryString
        OperateEntity.getEntityValueStudent(entity);
        super.execute(entity, assertMap);

    }

    @AfterClass
    public void afterClass() {
        super.tearDownAfterClass();
    }

    @DataProvider(name = "data")
    public Iterator<Object[]> initData() {
        return super.getDataIterator();
    }
}
