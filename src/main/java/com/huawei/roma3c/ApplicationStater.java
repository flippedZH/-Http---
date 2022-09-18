package com.huawei.roma3c;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Description: no desc
 * User: zh
 * Date: 2022/9/18
 * Time: 14:21
 */



@SpringBootApplication
//@EnableScheduling // 启用定时任务
public class ApplicationStater extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStater.class);
    }

    /* 设置Web项目的启动入口 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApplicationStater.class);
    }


}
