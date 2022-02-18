package com.blog.blog.repository;

import com.blog.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    /*List<Post> getAllPostWithParent(Long parentId);*/


}
