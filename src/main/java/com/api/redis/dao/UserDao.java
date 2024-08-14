package com.api.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.api.redis.models.User;
import java.util.Map;

//DAO is the class that largely manages CRUD operations

@Repository
public class UserDao 
{
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private static final String KEY = "USER";

    /*
      
    KEY--> key1 --> value1, value2 ..
           key2 --> value1, value2 ..
           key3 --> value1, value2 ..
           key4 --> value1, value2 ..

           key = hashkey

     */

     //Create/Save
     public User save(User user)
     {
        redisTemplate.opsForHash().put(KEY, user.getUserId(), user);
        return user;
    
     }

     //Read
     public User get(String userId)
     {
        return (User)redisTemplate.opsForHash().get(KEY,userId);
    
     }


     //Read All
     public Map<Object,Object> findAll()
     {
        return redisTemplate.opsForHash().entries(KEY);

     }

     //Delete
     public void delete(String userId)
     {
        redisTemplate.opsForHash().delete(KEY,userId);
     }









}
