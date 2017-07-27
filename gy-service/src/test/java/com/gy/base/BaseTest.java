package com.gy.base;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by Administrator on 2017/7/27 0028.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring_dao_unit.xml")
@TransactionConfiguration(transactionManager = "txMgr", defaultRollback=true)
public class BaseTest extends TestCase{

    @Test
    public void test(){}

}
