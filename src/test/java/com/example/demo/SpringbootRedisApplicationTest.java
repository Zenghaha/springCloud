package com.example.demo;

import com.example.demo.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTest {

    private Logger logger = Logger.getLogger("logger");

    @Test
    public void contextLoads(){

    }

    @Autowired
    RedisDao redisDao;

    @Test
    public void textRedis() {
        redisDao.setKey("name","zhh");
        redisDao.setKey("age","23");
        logger.info(redisDao.getValue("name"));
        logger.info(redisDao.getValue("age"));
    }
}
