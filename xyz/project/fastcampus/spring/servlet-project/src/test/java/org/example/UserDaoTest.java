package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {

    @BeforeEach
    void serUp(){
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db_schema.sql"));
        DatabasePopulatorUtils.execute(populator,ConnecionManager.getDataSource());


    }

    @Test
    void createTest() throws Exception {
        UserDao userDao = new UserDao();

        userDao.create(new User("wizard","password","name","email"));

        User user = userDao.findByUserIs("home"); // error case
        assertThat(user).isEqualTo(new User("wizard","password","name","email"));
    }

}
