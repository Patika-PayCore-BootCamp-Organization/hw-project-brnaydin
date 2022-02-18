package com.blog.blog.service.impl;

import com.blog.blog.exception.NotFoundException;
import com.blog.blog.model.Post;
import com.blog.blog.model.dto.PostDto;
import com.blog.blog.model.dto.PostResultDto;
import com.blog.blog.repository.PostRepository;
import com.blog.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> getAllPosts(){return postRepository.findAll();}

    @Override
    public Post getPost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(()->new NotFoundException("Post"));
    }

    @Override
    public void addPost(Post post){
        postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post post)  {
        getPost(id);
        post.setId(id);
        return postRepository.save(post);
    }

    @Override
    public boolean deletePost(Long id)  {
        postRepository.delete(getPost(id));
        return true;
    }

/*    @Override
    public PostResultDto getPostWithParent(Long id) {
        Optional<Post> post = postRepository.findById(id);
        PostResultDto postResultDto = new PostResultDto();
        List<Post> postList = postRepository.getAllPostWithParents(post.get().getId());
        postResultDto.setPostList(postList);
        postResultDto.setContent(post.get().getContent());

        return postResultDto;
    }*/

}
