package com.qinmei.controller;

import com.qinmei.domain.Girl;
import com.qinmei.domain.Result;
import com.qinmei.repositroy.GirlRepository;
import com.qinmei.service.GirlService;
import com.qinmei.properties.TestProperties;
import com.qinmei.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 控制器
 */
@RestController
public class GirlController {

    @Autowired
    private TestProperties testProperties;

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @RequestMapping(value = "hei",method = RequestMethod.GET)
    public String testBoot(@RequestParam(value = "id",defaultValue = "0",required = false) Integer id){
        return testProperties.getCupSize()+testProperties.getAge()+id;
    }

    /**
     * 查询列表
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> getGirlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生  @Valid 表单验证
     * @return
     */
    @PostMapping("/girl")
    public Girl addGirl(@Valid Girl girl, BindingResult bindingResult){

        System.out.println("getGirlListByAge");
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return girlRepository.save(girl);
    }

    /**
     * 根据年龄查询
     * @param age
     * @return
     */
    @GetMapping("/girl/age/{age}")
    public List<Girl> getGirlListByAge(@PathVariable("age") Integer age){
        System.out.println("getGirlListByAge");
        return girlRepository.findByAge(age);
    }

    /**
     * 事物管理
     */
    @GetMapping("/girl/add")
    public  void  insertGirl(){
        girlService.insertGirl();
    }

    /**
     * 测试统一异常处理
     * @return
     */
    @PostMapping("/girls")
    public Result addGirls(@Valid Girl girl, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            // 如果插入数据错误，处理返回结果
            return ResultUtil.error(0,bindingResult.getFieldError().getDefaultMessage());
        }

        // 给对象赋值
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

            // 如果插入成功
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 全局异常处理测试
     * @param id
     * @return
     * @throws RuntimeException
     */
    @GetMapping("/exception/test/{id}")
    public Result selectGirl(@PathVariable("id") Integer id) throws RuntimeException {
        // 测试非自定义异常
        //int i = 1/0;
        girlService.selectGirl(id);
        return null;
    }
}
