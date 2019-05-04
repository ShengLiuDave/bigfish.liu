package com.bigfish.EmpRepository;

import com.bigfish.domain.Emp;
import com.bigfish.repository.EmpJpaRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @ClassName: EmpJpaRepositoryTest
 * @Description: 测试JpaRepository
 * @author: liusheng
 * @date: 2019-05-04 22:12
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-04   liusheng        v1.0.0          Modify reason
 */
public class EmpJpaRepositoryTest {

    private ApplicationContext ctx = null;
    private EmpJpaRepository empJpaRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        empJpaRepository = ctx.getBean(EmpJpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFind(){
        List<Emp> emp = empJpaRepository.findAll();
        System.out.println("emp: " + emp);
    }


}
    