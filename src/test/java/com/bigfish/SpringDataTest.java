package com.bigfish;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @ClassName: SpringDataTest
 * @Description: 测试springdatajpa
 * @author: liusheng
 * @date: 2019-04-25 22:09
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-04-25   liusheng        v1.0.0          Modify reason
 */
public class SpringDataTest {

    private ApplicationContext ctx = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testEntityMannageFactory() {

    }


}
    