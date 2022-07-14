package com.angryzyh;

import com.angryzyh.spring5.yml.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Application01Tests {

    @Autowired
    private Person person;

    @Test
    void contextLoads() {
        System.out.println("person = " + person);
    }
}
