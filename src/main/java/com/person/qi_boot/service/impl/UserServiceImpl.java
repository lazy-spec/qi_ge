package com.person.qi_boot.service.impl;

import com.person.qi_boot.dao.UserDao;
import com.person.qi_boot.domain.User;
import com.person.qi_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getList();
    }

    @Override
    public List<User> getUserLikeList(String key) {
        return userDao.getLikeList(key);
    }

    @Override
    public User getUserInfo(Integer id) {
        return userDao.getInfoById(id);
    }

    @Override
    public void updateUserInfo(User user) {
        userDao.updateUserById(user);
    }

    @Override
    public void insertUserInfo(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deletedById(Integer id) {
        userDao.deleteById(id);
    }
}
