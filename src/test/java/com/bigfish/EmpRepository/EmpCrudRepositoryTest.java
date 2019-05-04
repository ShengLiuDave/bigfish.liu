package com.bigfish.EmpRepository;

import com.bigfish.domain.Emp;
import com.bigfish.service.EmpService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @ClassName: EmpCrudRepositoryTest
 * @Description: 测试CrudRepository
 * @author: liusheng
 * @date: 2019-05-04 15:47
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-04   liusheng        v1.0.0          Modify reason
 */
public class EmpCrudRepositoryTest {

    private ApplicationContext ctx = null;
    private EmpService empService = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        empService = ctx.getBean(EmpService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testSave() {
        List<Emp> empList = new ArrayList<>();
        Emp emp = null;
        for (int i = 0; i < 100; i++) {
            emp = new Emp();
            emp.setName("test" + i);
            emp.setAge(100 - i);
            empList.add(emp);
        }

        empService.save(empList);
    }


}
    