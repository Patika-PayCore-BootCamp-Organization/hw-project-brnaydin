package com.blog.blog.model.dto;

import com.blog.blog.model.DictStatusPost;
import com.blog.blog.model.DictTypePost;
import com.blog.blog.model.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResultDto {

    private String title;

    private String content;

    private DictTypePost type;

    private DictStatusPost status;

    private List<Post> postList;

}
