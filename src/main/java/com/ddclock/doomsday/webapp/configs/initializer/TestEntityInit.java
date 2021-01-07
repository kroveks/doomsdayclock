package com.ddclock.doomsday.webapp.configs.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnMissingClass({"org.springframework.boot.test.context.SpringBootTest"})
public class TestEntityInit implements CommandLineRunner {

    private DataInit DataInit;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Autowired
    public TestEntityInit(DataInit testDataInitService) {
        this.DataInit = testDataInitService;
    }

    @Override
    public void run(String... args) {
        if (ddlAuto.contains("create")) {
            DataInit.createEntity();
        }
    }
}
