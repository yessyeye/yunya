package com.xuehai.response.testCase.Student;

import com.xuehai.base.AssertHandler;
import com.xuehai.base.BaseTest;
import com.xuehai.base.Log;
import com.xuehai.model.Entity;
import com.xuehai.response.Assertion.PostFriendsRequestsAssertion;
import com.xuehai.util.OperateEntity;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author slyart
 * @create 2019/5/28 4:23 PM
 */
public class PostFriendsRequests extends BaseTest {
    Log logger = new Log(PostFriendsRequests.class);
    private static HashMap<String, AssertHandler> assertMap = new HashMap<String, AssertHandler>();

    static {
        assertMap.put("first", new PostFriendsRequestsAssertion());
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

    @Test(dataProvider = "data", description = "添加好友")
    public void action(Entity entity) {
        //获取加签名后的entity中最新queryString
        OperateEntity.getEntityValueStudent(entity);
        super.execute(entity, assertMap);

    }

    @DataProvider(name = "data")
    public Iterator<Object[]> initData() {
        return super.getDataIterator();
    }
}