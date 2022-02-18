package com.blog.blog.service.impl;

import com.blog.blog.exception.NotFoundException;
import com.blog.blog.model.DictTypeUser;
import com.blog.blog.repository.DictTypeUserRepository;
import com.blog.blog.service.DictTypeUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DictTypeUserServiceImpl implements DictTypeUserService {
    
    private final DictTypeUserRepository dictTypeUserRepository;

    @Override
    public List<DictTypeUser> getAllDictTypeUsers(){return dictTypeUserRepository.findAll();}

    @Override
    public DictTypeUser getDictTypeUser(Long id) {
        Optional<DictTypeUser> dictTypeUser = dictTypeUserRepository.findById(id);
        return dictTypeUser.orElseThrow(()->new NotFoundException("DictTypeUser"));
    }

    @Override
    public DictTypeUser getDictTypeUserWithCode(String code) {
        Optional<DictTypeUser> dictTypeUser = dictTypeUserRepository.findByCode(code);
        return dictTypeUser.orElseThrow(()->new NotFoundException("DictTypeUserWithCode"));
    }

    @Override
    public void addDictTypeUser(DictTypeUser dictTypeUser){
        dictTypeUserRepository.save(dictTypeUser);
    }

    @Override
    public DictTypeUser updateDictTypeUser(Long id, DictTypeUser dictTypeUser)  {
        getDictTypeUser(id);
        dictTypeUser.setId(id);
        return dictTypeUserRepository.save(dictTypeUser);
    }

    @Override
    public boolean deleteDictTypeUser(Long id)  {
        dictTypeUserRepository.delete(getDictTypeUser(id));
        return true;
    }
}
