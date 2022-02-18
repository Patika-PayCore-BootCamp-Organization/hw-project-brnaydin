package com.blog.blog.service;

import com.blog.blog.model.DictStatusUser;

import java.util.List;

public interface DictStatusUserService {
    List<DictStatusUser> getAllDictStatusUsers();

    DictStatusUser getDictStatusUser(Long id);

    void addDictStatusUser(DictStatusUser dictStatusUser);

    DictStatusUser updateDictStatusUser(Long id, DictStatusUser dictStatusUser );

    boolean deleteDictStatusUser(Long id);
}
