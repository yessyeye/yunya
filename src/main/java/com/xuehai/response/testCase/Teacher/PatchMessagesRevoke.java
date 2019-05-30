package com.xuehai.response.testCase.Teacher;

import com.xuehai.base.AssertHandler;
import com.xuehai.base.BaseTest;
import com.xuehai.base.Log;
import com.xuehai.model.Entity;
import com.xuehai.response.Assertion.PatchMessagesRevokeAssertion;
import com.xuehai.response.Assertion.PostMessagesAssertion;
import com.xuehai.util.OperateEntity;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author slyart
 * @create 2019/5/29 1:54 PM
 */
public class PatchMessagesRevoke extends BaseTest {
    Log logger = new Log(PatchMessagesRevoke.class);
    private static HashMap<String, AssertHandler> assertMap = new HashMap<String, AssertHandler>();

    static {
        assertMap.put("first", new PatchMessagesRevokeAssertion());
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

    @Test(dataProvider = "data", description = "撤回消息")
    public void action(Entity entity) {
        String entity1 = entity.getUrl().replace("*", PostMessagesAssertion.msgId);
        entity.setUrl(entity1);
        //获取加签名后的entity中最新queryString
        OperateEntity.getEntityValue(entity);
        super.execute(entity, assertMap);

    }

    @DataProvider(name = "data")
    public Iterator<Object[]> initData() {
        return super.getDataIterator();
    }
}
