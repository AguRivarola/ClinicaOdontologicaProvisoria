package com.dh.clinicaFinal;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class clinicaFinalApplication {

    public static void main(String[] args) {
        String log4jConfPath = "src/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        SpringApplication.run(clinicaFinalApplication.class, args);
    }

}
