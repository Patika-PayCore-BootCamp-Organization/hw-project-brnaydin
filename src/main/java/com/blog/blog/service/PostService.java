package com.blog.blog.service;

import com.blog.blog.model.Post;
import com.blog.blog.model.dto.PostResultDto;


import java.util.List;


public interface PostService {

    List<Post> getAllPosts();

    Post getPost(Long id);

    void addPost(Post post);

    Post updatePost(Long id, Post post );

    boolean deletePost(Long id);

    /*PostResultDto getPostWithParent(Long id);*/

}
