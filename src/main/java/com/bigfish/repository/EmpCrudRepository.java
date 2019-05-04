package com.bigfish.repository;

import com.bigfish.domain.Emp;
import org.springframework.data.repository.CrudRepository;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @InterfaceName: EmpCrudRepository
 * @Description: CrudRepository的使用
 * @author: liusheng
 * @date: 2019-05-04 15:29
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-04   liusheng        v1.0.0          Modify reason
 */
public interface EmpCrudRepository extends CrudRepository<Emp, Integer> {



}
