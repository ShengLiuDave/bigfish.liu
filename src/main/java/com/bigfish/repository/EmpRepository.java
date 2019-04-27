package com.bigfish.repository;

import com.bigfish.domain.Emp;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @InterfaceName: EmpRepository
 * @Description:
 * @author: liusheng
 * @date: 2019-04-25 22:57
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-04-25   liusheng        v1.0.0          Modify reason
 */
@RepositoryDefinition(domainClass = Emp.class, idClass = Integer.class)
public interface EmpRepository /*extends Repository<Emp, Integer> */{

    /** 根据名字查询数据 */
    Emp findByName(String name);

    /** where name like ?% and age < ? */
    List<Emp> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    /** where name like %? and age < ? */
    List<Emp> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    /** where name in(?,?...) or age < ? */
    List<Emp> findByNameInOrAgeLessThan(ArrayList<String> names, Integer age);

    /** 根据实体类名查询 */
    @Query("select o from Emp o where o.id=(select max(o1.id) from Emp o1)")
    Emp getEmpById();

    /** 根据占位符查询 o ===> Object */
    @Query("select o from Emp o where o.name=?1 and o.age=?2")
    List<Emp> queryParams(String name, Integer age);

    /** 根据参数方式查询 */
    @Query("select o from Emp o where o.name=:name and o.age=:age")
    List<Emp> queryByParams(@Param("name")String name, @Param("age")Integer age);

    /** 模糊查询like的用法 */
    @Query("select o from Emp o where o.name like %?1%")
    List<Emp> queryLike(String name);

    @Query("select o from Emp o where o.name like %:name%")
    List<Emp> queryByLike(@Param("name") String name);

    /** 原生查询 */
    @Query(nativeQuery = true, value = "select count(1) from spring_data_jpa ")
    long getCount();

    /** 根据id更新age */
    @Modifying
    @Query("update Emp o set o.age = :age where o.id = :id")
    void update(@Param("id")Integer id, @Param("age")Integer age);
}
