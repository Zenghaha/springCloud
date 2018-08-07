package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findUserByUserName(String username) {
        return userDao.findByUsername(username);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public User findUserById(long id) {
        return userDao.findById(id).get();
    }

    public User updateUser(User user) {
        return userDao.saveAndFlush(user);
    }

    public void deleteUser(long id) {
        userDao.deleteById(id);
    }
}
