package com.blog.blog.controller;

import com.blog.blog.exception.InvalidRequestException;
import com.blog.blog.model.User;
import com.blog.blog.model.dto.UserDto;
import com.blog.blog.model.mapper.UserMapper;
import com.blog.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")

public class UserController {

    private final UserService userService;
    private static final UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    @GetMapping(value = "/all")
    public List<UserDto> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return allUsers.stream().map(USER_MAPPER::toDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public UserDto getUser(@PathVariable @Min(1) Long id){
        return USER_MAPPER.toDto(userService.getUser(id));
    }

    @PostMapping(value = "/create")
    public void saveUser(@Valid @RequestBody UserDto userDto) {
        userService.addUser(USER_MAPPER.toEntity(userDto));
    }

    @PutMapping(value = "/update/{id}")
    public UserDto updateUser(@RequestParam @Min(1) Long id, @Valid @RequestBody User user) {
        if (user.getId() == null){
            throw new InvalidRequestException("User id can not be null thus update operation failed");
        }
        return USER_MAPPER.toDto(userService.updateUser(user));
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteUser(@RequestParam @Min(1) Long id) {
        return userService.deleteUser(id);
    }

}
