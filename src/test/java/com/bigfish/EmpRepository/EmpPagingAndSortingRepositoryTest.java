package com.bigfish.EmpRepository;

import com.bigfish.domain.Emp;
import com.bigfish.repository.EmpPagingAndSortingRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @ClassName: EmpPagingAndSortingRepositoryTest
 * @Description: 测试分页跟排序 PagingAndSortingRepository
 * @author: liusheng
 * @date: 2019-05-04 16:05
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-04   liusheng        v1.0.0          Modify reason
 */
public class EmpPagingAndSortingRepositoryTest  {


    private ApplicationContext ctx = null;
    private EmpPagingAndSortingRepository empPagingAndSortingRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        empPagingAndSortingRepository = ctx.getBean(EmpPagingAndSortingRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testPage() {
        // page: index是从0开始的, 不是从1开始的
        Pageable pageable = new PageRequest(0, 5);
        Page<Emp> page =  empPagingAndSortingRepository.findAll(pageable);
        System.out.println("查询的总页数: " + page.getTotalPages());
        System.out.println("查询的总记录数: " + page.getTotalElements());
    }


}
