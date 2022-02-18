package com.blog.blog.service.impl;

import com.blog.blog.exception.NotFoundException;
import com.blog.blog.model.DictStatusUser;
import com.blog.blog.model.DictTypeUser;
import com.blog.blog.model.User;
import com.blog.blog.model.dto.UserDto;
import com.blog.blog.repository.UserRepository;
import com.blog.blog.service.DictStatusUserService;
import com.blog.blog.service.DictTypeUserService;
import com.blog.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    DictTypeUserService dictTypeUserService;

    @Autowired
    DictStatusUserService dictStatusUserService;

    @Override
    public List<User> getAllUsers(){return userRepository.findAll();}

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(()->new NotFoundException("User"));
    }

    @Override
    public void addUser(User user){
        DictTypeUser dictTypeUser = dictTypeUserService.getDictTypeUser(1L);
        DictStatusUser dictStatusUser = dictStatusUserService.getDictStatusUser(1L);
        user.setType(dictTypeUser);
        user.setStatus(dictStatusUser);
        userRepository.save(user);
    }



    @Override
    public void addUser(UserDto userDTO){

        DictTypeUser dictTypeUser = dictTypeUserService.getDictTypeUserWithCode(userDTO.getType());
        DictStatusUser dictStatusUser = dictStatusUserService.getDictStatusUser(1L);
        User user= new User();
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setType(dictTypeUser);
        user.setStatus(dictStatusUser);
        userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        user.setId(user.getId());
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(Long id)  {
        userRepository.delete(getUser(id));
        return true;
    }
}
