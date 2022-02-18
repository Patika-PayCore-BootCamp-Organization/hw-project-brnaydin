package com.blog.blog.service.impl;

import com.blog.blog.exception.NotFoundException;
import com.blog.blog.model.DictStatusPost;
import com.blog.blog.repository.DictStatusPostRepository;
import com.blog.blog.service.DictStatusPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DictStatusPostServiceImpl implements DictStatusPostService {

    private final DictStatusPostRepository dictStatusPostRepository;

    @Override
    public List<DictStatusPost> getAllDictStatusPosts(){return dictStatusPostRepository.findAll();}

    @Override
    public DictStatusPost getDictStatusPost(Long id) {
        Optional<DictStatusPost> dictStatusPost = dictStatusPostRepository.findById(id);
        return dictStatusPost.orElseThrow(()->new NotFoundException("DictStatusPost"));
    }

    @Override
    public void addDictStatusPost(DictStatusPost dictStatusPost){
        dictStatusPostRepository.save(dictStatusPost);
    }

    @Override
    public DictStatusPost updateDictStatusPost(Long id, DictStatusPost dictStatusPost)  {
        getDictStatusPost(id);
        dictStatusPost.setId(id);
        return dictStatusPostRepository.save(dictStatusPost);
    }

    @Override
    public boolean deleteDictStatusPost(Long id)  {
        dictStatusPostRepository.delete(getDictStatusPost(id));
        return true;
    }
}
