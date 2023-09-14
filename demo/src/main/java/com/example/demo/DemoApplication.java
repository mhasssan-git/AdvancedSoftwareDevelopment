package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import printer.FrameworkPrinter;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        FrameworkPrinter printer=new FrameworkPrinter();
        printer.print("Areh kisu ekta print korlei to hoy");
        SpringApplication.run(DemoApplication.class, args);
    }

}
