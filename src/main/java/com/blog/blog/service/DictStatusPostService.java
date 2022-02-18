package com.blog.blog.service;

import com.blog.blog.model.DictStatusPost;

import java.util.List;

public interface DictStatusPostService {
    List<DictStatusPost> getAllDictStatusPosts();

    DictStatusPost getDictStatusPost(Long id);

    void addDictStatusPost(DictStatusPost dictStatusPost);

    DictStatusPost updateDictStatusPost(Long id, DictStatusPost dictStatusPost );

    boolean deleteDictStatusPost(Long id);
}
