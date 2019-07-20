package org.xujin.sc.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xujin.sc.feign.HelloFeignService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: xujin
 **/
@CommonsLog
@RequestMapping("/hello")
@RestController
public class TestController<T> {

    @Autowired
    HelloFeignService helloRemote;

    @GetMapping("/{name}")
    public String index(@PathVariable("name") String name)  {
        log.info("the name is " + name);
        return helloRemote.hello(name) + "\n" + new Date().toString();
    }

    public static void main(String[] args) {
        TestController<String> ttDemo = new TestController<String>();

        // 获取String类型
        List<String> array = new ArrayList<>();
        array.add("aaa");
        array.add("bbb");
        String str =  ttDemo.getListFirst(array);
        System.out.println(str);

        // 获取Number类型
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
//        Integer num = ttDemo.getListFirst(nums);
        TestController<Integer> ttDemo2 = new TestController<Integer>();
        ttDemo2.getListLastSpicy(nums);

    }
    private <T> T getListFirst(List<T> data){
        if(data == null || data.size() == 0){
            return null;
        }
        return data.get(0);
    }

    private <T> T getListLast(List<T> data){
        if (data == null || data.size() == 0){
            return null;
        }
        return data.get(data.size()-1);
    }

    private T getListLastSpicy(List<T> data){
        if (data == null || data.size() == 0){
            return null;
        }
        return data.get(data.size()-1);
    }
}
