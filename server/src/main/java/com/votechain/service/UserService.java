package com.votechain.service;

import com.votechain.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(long id);

    void saveOrUpdate(User user);

    void delete(long id);

}
