package com.qinmei.service;

import com.qinmei.domain.Girl;
import com.qinmei.enums.ResultEnum;
import com.qinmei.exception.GirlException;
import com.qinmei.repositroy.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事物测试
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 插入一个对象，事物
     */
    @Transactional
    public void insertGirl(){
        Girl girl = new Girl();
        girl.setCupSize("C");
        girl.setAge(18);
        girlRepository.save(girl);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(20);
        //int i = 1/0;
        girlRepository.save(girlB);
    }

    /**
     * 通过 id 查询一个女孩,全局异常处理 service抛出异常方式
     * @param id
     */
    public void selectGirl(Integer id) throws RuntimeException {
        Girl girl = girlRepository.findOne(id);
        // 异常
        Integer age = girl.getAge();
        if (age < 10){
            throw new GirlException(ResultEnum.AGIRL);
        }else if (10<age &&age <16){
            throw new GirlException(ResultEnum.BGIRL);
        }

    }

    /**
     * 通过 id 查询一个女孩   测试
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
       return girlRepository.findOne(id);
    }
}
