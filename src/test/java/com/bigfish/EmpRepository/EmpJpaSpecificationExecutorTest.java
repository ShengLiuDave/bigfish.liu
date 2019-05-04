package com.bigfish.EmpRepository;

import com.bigfish.domain.Emp;
import com.bigfish.repository.EmpJpaSpecificationExecutor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @ClassName: EmpJpaSpecificationExecutorTest
 * @Description: 测试JpaSpecificationExecutor
 * @author: liusheng
 * @date: 2019-05-04 22:23
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-04   liusheng        v1.0.0          Modify reason
 */
public class EmpJpaSpecificationExecutorTest {

    private ApplicationContext ctx = null;
    private EmpJpaSpecificationExecutor empJpaSpecificationExecutor = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        empJpaSpecificationExecutor = ctx.getBean(EmpJpaSpecificationExecutor.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }


    /** 分页、排序、查询条件: 年龄大于50  */
    @Test
    public void testQuery(){
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "id");
        Sort sort = new Sort(order);
        // page: index是从0开始的, 不是从1开始的
        Pageable pageable = new PageRequest(0, 5, sort);
        // root: 查询的类型Emp, cq: 添加查询条件, cb: 构建Predicate
        Specification<Emp> specification = new Specification<Emp>() {
            @Override
            public Predicate toPredicate(Root<Emp> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                // Root (Emp (age))
                Path path =  root.get("age");
                return cb.ge(path, 50);
            }
        };

        Page<Emp> page = empJpaSpecificationExecutor.findAll(specification, pageable);

        System.out.println("查询的总页数: " + page.getTotalPages());
        System.out.println("查询的总记录数: " + page.getTotalElements());
        System.out.println("查询当前页面的集合: " + page.getContent());
    }


}
    