package com.blog.blog.service.impl;

import com.blog.blog.exception.NotFoundException;
import com.blog.blog.model.DictTypePost;
import com.blog.blog.repository.DictTypePostRepository;
import com.blog.blog.service.DictTypePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DictTypePostServiceImpl implements DictTypePostService {

    private final DictTypePostRepository dictTypePostRepository;

    @Override
    public List<DictTypePost> getAllDictTypePosts(){return dictTypePostRepository.findAll();}

    @Override
    public DictTypePost getDictTypePost(Long id) {
        Optional<DictTypePost> dictTypePost = dictTypePostRepository.findById(id);
        return dictTypePost.orElseThrow(()->new NotFoundException("DictTypePost"));
    }

    @Override
    public void addDictTypePost(DictTypePost dictTypePost){
        dictTypePostRepository.save(dictTypePost);
    }

    @Override
    public DictTypePost updateDictTypePost(Long id, DictTypePost dictTypePost)  {
        getDictTypePost(id);
        dictTypePost.setId(id);
        return dictTypePostRepository.save(dictTypePost);
    }

    @Override
    public boolean deleteDictTypePost(Long id)  {
        dictTypePostRepository.delete(getDictTypePost(id));
        return true;
    }
}
