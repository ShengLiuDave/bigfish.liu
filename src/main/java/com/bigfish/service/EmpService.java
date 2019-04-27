package com.bigfish.service;

import com.bigfish.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


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

    @Autowired
    private EmpRepository empRepository;

    @Transactional
    public void update(Integer id, Integer age) {
        empRepository.update(id, age);
    }


}
    