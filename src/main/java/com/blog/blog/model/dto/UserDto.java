package com.blog.blog.model.dto;
import com.blog.blog.model.DictStatusUser;
import com.blog.blog.model.DictTypeUser;
import com.blog.blog.model.Post;
import lombok.Data;

@Data
public class UserDto {

    private String username;

    private String name;

    private String surname;

    private String type;


}
