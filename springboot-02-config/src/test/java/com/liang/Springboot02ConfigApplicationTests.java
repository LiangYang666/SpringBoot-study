package com.liang;

import com.liang.pojo.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {
    @Autowired
//    @Qualifier
    private Dog dog;

    @Test
    void contextLoads() {
        System.out.println(dog);

    }

}
