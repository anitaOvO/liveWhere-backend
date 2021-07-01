package com.javaclimb.livewhere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.javaclimb.livewhere.dao")
public class LivewhereApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivewhereApplication.class, args);

    }

}
