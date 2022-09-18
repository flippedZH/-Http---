package com.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import okhttp3.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Description: no desc
 * User: zh
 * Date: 2022/9/18
 * Time: 14:25
 */

@Controller
@RequestMapping("index")
public class IndexController {

    @RequestMapping("post")
    public String  post(String key) {
        //发送请求：
        //用来请求的http的url地址

        //调用相应的方法封装user对象，存入list中
        User user1=new User();
        User user2=new User();
        user1.setName("小张");
        user1.setAge(12);
        user1.setGender("男");

        user2.setName("小红");
        user2.setAge(18);
        user2.setGender("女");
        ArrayList list=new ArrayList<>();
        list.add(user1);
        list.add(user2);
        //调用fastjson库中的toJSONString方法返回相应字符串
        String s = JSON.toJSONString(list);
        System.out.println(s);

        //创建okhttp客户端
        OkHttpClient client=new OkHttpClient();
        String url="http://localhost:8080/index/psot";
        MediaType mediaTypeJson = MediaType.get("application/json; charset=utf-8");
        //将数据封装到requestbody中
        RequestBody body=RequestBody.create(mediaTypeJson,s);
        //构建request，发送post请求到相应url
        Request request=new Request.Builder().
                post(body).
                url(url).
                build();

        //客户端执行，得到返回值response
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //得到状态码，响应头，响应体
        System.out.println(response.code());
        //System.out.println(response.headers());
        try {
            System.out.println(response.body().string());
        } catch (IOException e) {

            e.printStackTrace();
        }
        return "index";

    }

    @RequestMapping("get")
    public String get(){

        //get请求（携带token） 获取 用户信息
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://localhost:8080/index/get?token="+12345)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String res= response.body().string();
            System.out.println("res:"+res);
        }catch (IOException e){
            e.printStackTrace();
        }
        return "index";
    }
}
