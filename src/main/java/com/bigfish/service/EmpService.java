package com.bigfish.service;

import com.bigfish.domain.Emp;
import com.bigfish.repository.EmpCrudRepository;
import com.bigfish.repository.EmpRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @ClassName: EmpService
 * @Description: emp service层
 * @author: liusheng
 * @date: 2019-04-27 00:32
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-04-27   liusheng        v1.0.0          Modify reason
 */
@Service
public class EmpService {

    @Resource
    private EmpRepository empRepository;

    @Resource
    private EmpCrudRepository empCrudRepository;

    @Transactional(rollbackOn = Exception.class)
    public void update(Integer id, Integer age) {
        empRepository.update(id, age);
    }

    @Transactional(rollbackOn = Exception.class)
    public void save(List<Emp> emps) {
        empCrudRepository.saveAll(emps);
    }

}
    