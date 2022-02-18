package com.blog.blog.service;

import com.blog.blog.model.User;
import com.blog.blog.model.dto.UserDto;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Long id);

    void addUser(User user);

    //void addUser(User user);
    void addUser(UserDto userDTO);

    User updateUser(User user );

    boolean deleteUser(Long id);
}
