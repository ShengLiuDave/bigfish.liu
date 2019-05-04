package com.bigfish.EmpRepository;

import com.bigfish.domain.Emp;
import com.bigfish.repository.EmpRepository;
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
 * @ClassName: EmpRepositoryTest
 * @Description: 测试
 * @author: liusheng
 * @date: 2019-04-25 23:00
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-04-25   liusheng        v1.0.0          Modify reason
 */
public class EmpRepositoryTest {

    private ApplicationContext ctx = null;
    private EmpRepository empRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        empRepository = ctx.getBean(EmpRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFindByName(){
        Emp info = empRepository.findByName("zhangsan");
        System.out.println("id:" + info.getId() + ", name:" + info.getName() + ", age" + info.getAge());
    }

    @Test
    public void testFindByNameStartingWithAndAgeLessThan(){
        List<Emp> empList = empRepository.findByNameStartingWithAndAgeLessThan("lisi", 26);
        for (Emp emp : empList) {
            System.out.println("id:" + emp.getId() + ", name:" + emp.getName() + ", age" + emp.getAge());
        }
    }

    @Test
    public void testFindByNameEndingWithWithAndAgeLessThan(){
        List<Emp> empList = empRepository.findByNameEndingWithAndAgeLessThan("lisi", 26);
        for (Emp emp : empList) {
            System.out.println("id:" + emp.getId() + ", name:" + emp.getName() + ", age" + emp.getAge());
        }
    }

    @Test
    public void testFindByNameInOrAgeLessThan(){
        ArrayList<String> names = new ArrayList<>();
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
        List<Emp> empList = empRepository.findByNameInOrAgeLessThan(names, 23);
        for (Emp emp : empList) {
            System.out.println("id:" + emp.getId() + ", name:" + emp.getName() + ", age" + emp.getAge());
        }
    }

    @Test
    public void testGetEmpById(){
        Emp emp = empRepository.getEmpById();
        System.out.println("id:" + emp.getId() + ", name:" + emp.getName() + ", age" + emp.getAge());
    }

    @Test
    public void testQueryParams(){
        List<Emp> empList = empRepository.queryParams("zhangsan", 20);
        for (Emp emp : empList) {
            System.out.println("id:" + emp.getId() + ", name:" + emp.getName() + ", age" + emp.getAge());
        }
    }

    @Test
    public void testQueryByParams(){
        List<Emp> empList = empRepository.queryByParams("lisi", 21);
        for (Emp emp : empList) {
            System.out.println("id:" + emp.getId() + ", name:" + emp.getName() + ", age" + emp.getAge());
        }
    }

    @Test
    public void testQueryLike(){
        List<Emp> empList = empRepository.queryLike("li");
        for (Emp emp : empList) {
            System.out.println("id:" + emp.getId() + ", name:" + emp.getName() + ", age" + emp.getAge());
        }
    }

    @Test
    public void testQueryByLike(){
        List<Emp> empList = empRepository.queryByLike("li");
        for (Emp emp : empList) {
            System.out.println("id:" + emp.getId() + ", name:" + emp.getName() + ", age" + emp.getAge());
        }
    }

    @Test
    public void testGetCount(){
        long count = empRepository.getCount();
        System.out.println("count = " + count);
    }

    @Test
    public void testUpdate(){
        empRepository.update(1, 66);
    }

}
    