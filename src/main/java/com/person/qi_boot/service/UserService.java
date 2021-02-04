package com.person.qi_boot.service;


import com.person.qi_boot.domain.User;

import java.util.List;

public interface UserService {

    User login(String username, String password);

    List<User> getUserList();

    List<User> getUserLikeList(String key);

    User getUserInfo(Integer id);

    void updateUserInfo(User user);

    void insertUserInfo(User user);

    void deletedById(Integer id);

}
