package com.blog.blog.service;

import com.blog.blog.model.DictTypeUser;

import java.util.List;

public interface DictTypeUserService {

    List<DictTypeUser> getAllDictTypeUsers();

    DictTypeUser getDictTypeUser(Long id);

    DictTypeUser getDictTypeUserWithCode(String code);

    void addDictTypeUser(DictTypeUser dictTypeUser);

    DictTypeUser updateDictTypeUser(Long id, DictTypeUser dictTypeUser );

    boolean deleteDictTypeUser(Long id);
}

