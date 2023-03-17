package com.hl.hardwareLibrary;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
@EnableScheduling
@MapperScan("com.hl.hardwareLibrary.dao")
@EnableEncryptableProperties
public class HardwareLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(HardwareLibraryApplication.class, args);
    }

}
