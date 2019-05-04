package com.bigfish.repository;

import com.bigfish.domain.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @InterfaceName: EmpJpaSpecificationExecutor
 * @Description: JpaSpecificationExecutor 独立的条件过滤接口
 * @author: liusheng
 * @date: 2019-05-04 22:21
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-04   liusheng        v1.0.0          Modify reason
 */
public interface EmpJpaSpecificationExecutor extends JpaRepository<Emp, Integer>, JpaSpecificationExecutor<Emp> {



}
