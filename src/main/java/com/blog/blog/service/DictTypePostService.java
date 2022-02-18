package com.blog.blog.service;

import com.blog.blog.model.DictTypePost;
import com.blog.blog.model.Post;

import java.util.List;

public interface DictTypePostService {

    List<DictTypePost> getAllDictTypePosts();

    DictTypePost getDictTypePost(Long id);

    void addDictTypePost(DictTypePost dictTypePost);

    DictTypePost updateDictTypePost(Long id, DictTypePost dictTypePost );

    boolean deleteDictTypePost(Long id);
}
