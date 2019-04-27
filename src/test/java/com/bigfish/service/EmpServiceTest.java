package com.bigfish.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @ClassName: EmpServiceTest
 * @Description: emp service测试类
 * @author: liusheng
 * @date: 2019-04-27 00:36
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-04-27   liusheng        v1.0.0          Modify reason
 */
public class EmpServiceTest {

    private ApplicationContext ctx = null;
    private EmpService empService = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        empService = ctx.getBean(EmpService.class);
        System.out.printf("setup");
    }

    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testUpdate(){
        empService.update(1, 66);
    }

}
    