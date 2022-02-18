package com.blog.blog.service.impl;

import com.blog.blog.exception.NotFoundException;
import com.blog.blog.model.DictStatusUser;
import com.blog.blog.repository.DictStatusUserRepository;
import com.blog.blog.service.DictStatusUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DictStatusUserServiceImpl implements DictStatusUserService {
    private final DictStatusUserRepository dictStatusUserRepository;

    @Override
    public List<DictStatusUser> getAllDictStatusUsers(){return dictStatusUserRepository.findAll();}

    @Override
    public DictStatusUser getDictStatusUser(Long id) {
        Optional<DictStatusUser> dictStatusUser = dictStatusUserRepository.findById(id);
        return dictStatusUser.orElseThrow(()->new NotFoundException("DictStatusUser"));
    }

    @Override
    public void addDictStatusUser(DictStatusUser dictStatusUser){
        dictStatusUserRepository.save(dictStatusUser);
    }

    @Override
    public DictStatusUser updateDictStatusUser(Long id, DictStatusUser dictStatusUser)  {
        getDictStatusUser(id);
        dictStatusUser.setId(id);
        return dictStatusUserRepository.save(dictStatusUser);
    }

    @Override
    public boolean deleteDictStatusUser(Long id)  {
        dictStatusUserRepository.delete(getDictStatusUser(id));
        return true;
    }
}
