package com.chori.springdataredis.controller;

import com.chori.springdataredis.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Resource(name = "redisTemplate")
    private HashOperations<String, byte[], byte[]> hashOperations;

    @Resource(name = "redisTemplate")
    private ListOperations<String, User> listOperations;

    private HashMapper<Object, byte[], byte[]> mapper = new ObjectHashMapper();

    private void writeUserHash(String key, User user) {

        Map<byte[], byte[]> mappedHash = mapper.toHash(user);
        hashOperations.putAll(key, mappedHash);
    }

    private User loadUserHash(String key) {

        Map<byte[], byte[]> loadedHash = hashOperations.entries(key);
        return (User) mapper.fromHash(loadedHash);
    }

    @PostMapping("/user/{name}/{number}/{city}")
    public void insertNameInRedis(@PathVariable("name") String name,
                                  @PathVariable("number") long number,
                                  @PathVariable("city") String city) throws JsonProcessingException {
        User user = new User().setName(name).setNumber(number).setCity(city);
        writeUserHash(String.valueOf(number), user);
        listOperations.leftPush("users", user);

    }

    @GetMapping("/user/{number}")
    public User getNameInRedis(@PathVariable("number") long number) {
        return loadUserHash(String.valueOf(number));
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return listOperations.range("users", 0, listOperations.size("users"));
    }

}
