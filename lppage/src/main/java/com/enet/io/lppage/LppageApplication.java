package com.enet.io.lppage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.enet.io",exclude = HibernateJpaAutoConfiguration.class)
public class LppageApplication {

    public static void main(String[] args) {
        SpringApplication.run(LppageApplication.class, args);
    }

}
