package com.example.winter_vacation_checkin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.winter_vacation_checkin.mapper")
public class WinterVacationCheckInApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinterVacationCheckInApplication.class, args);
    }

}
