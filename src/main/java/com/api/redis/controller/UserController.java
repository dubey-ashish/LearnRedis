package com.api.redis.controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.api.redis.dao.UserDao;
import com.api.redis.models.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class UserController 
{

    @Autowired
    private UserDao userDao;

    @PostMapping("/save")
    public User createUser(@RequestBody User user) 
    {
        user.setUserId(UUID.randomUUID().toString());
        return userDao.save(user);

    }

    @GetMapping("/get/{userId}")
    public User getUser(@PathVariable String userId) 
    {

        return userDao.get(userId);

    }

    @GetMapping("/get")
    public Map<Object,Object> getAll()
    {
        return userDao.findAll();
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable String userId)
    {
        userDao.delete(userId);
    }
    
    

}
