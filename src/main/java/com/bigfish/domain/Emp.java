package com.bigfish.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @ClassName: Emp
 * @Description: 员工实体类: 先开发实体类===》自动生成数据表
 * @author: liusheng
 * @date: 2019-04-25 22:12
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-04-25   liusheng        v1.0.0          Modify reason
 */
@Data
@Entity
@Table(name="SPRING_DATA_JPA")
public class Emp implements Serializable {

    /** 主键 */
    @Id
    /** 自增 */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** 设定列的长度 */
    @Column(length = 20)
    private String name;

    private Integer age;

}
    