package com.nyf.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello world!
 */

@SpringBootApplication
@MapperScan("com.nyf.test.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
