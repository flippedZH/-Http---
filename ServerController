package com.huawei.roma3c.controller;


import com.huawei.roma3c.entity.User;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description: no desc
 * User: zh
 * Date: 2022/9/18
 * Time: 14:25
 */

@Controller
@RequestMapping("index")
public class IndexController {


    public String  index(String key){
        System.out.println("收到请求："+key);
        return "index";
    }

    @RequestMapping("post")
    @ResponseBody
    public List<User> post(@RequestBody List<User> list){
        for(User user :list) System.out.println(user);
        return list;
    }

    @RequestMapping("get")
    @ResponseBody
    public String get(String token){
        return token;
    }
}
