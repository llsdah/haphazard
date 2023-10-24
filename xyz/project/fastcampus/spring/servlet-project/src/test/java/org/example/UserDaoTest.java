package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

public class UserDaoTest {

    @BeforeEach
    void serUp(){
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db_schema.sql"));
        DatabasePopulatorUtils.execute(populator,ConnecionManager.getDataSource());


    }
}
