package com.paysys;

import org.springframework.boot.SpringApplication;

public class TestPaysysApplication {

    public static void main(String[] args) {
        SpringApplication.from(PaysysApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
