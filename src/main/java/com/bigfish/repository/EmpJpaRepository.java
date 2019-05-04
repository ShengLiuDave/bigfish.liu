package com.bigfish.repository;

import com.bigfish.domain.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @InterfaceName: EmpJpaRepository
 * @Description: JpaRepository
 * @author: liusheng
 * @date: 2019-05-04 22:09
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-04   liusheng        v1.0.0          Modify reason
 */
public interface EmpJpaRepository extends JpaRepository<Emp, Integer> {



}
