package com.bigfish.repository;

import com.bigfish.domain.Emp;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @InterfaceName: PagingAndSortingRepository
 * @Description: 测试分页跟排序 PagingAndSortingRepository
 * @author: liusheng
 * @date: 2019-05-04 16:07
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-04   liusheng        v1.0.0          Modify reason
 */
public interface EmpPagingAndSortingRepository extends PagingAndSortingRepository<Emp, Integer> {


}
