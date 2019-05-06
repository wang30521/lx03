package io.cjf.lx03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("io.cjf.lx03.dao")
public class Lx03Application {

    public static void main(String[] args) {
        SpringApplication.run(Lx03Application.class, args);
    }

}
