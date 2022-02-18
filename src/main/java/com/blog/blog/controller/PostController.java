package com.blog.blog.controller;

import com.blog.blog.model.Post;
import com.blog.blog.model.dto.PostResultDto;
import com.blog.blog.repository.PostRepository;
import com.blog.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @GetMapping(value = "/all")
    public List<Post> getAllPosts(){
        List<Post> allPosts = postService.getAllPosts();
        return allPosts;
    }

    @GetMapping(value = "/{id}")
    public Post getPost(@PathVariable @Min(1) Long id){
        return getPost(id);
    }

    @PostMapping(value = "/create")
    public void savePost(@Valid @RequestBody Post post) {
        postService.addPost(post);
    }

    @PutMapping(value = "/update/{id}")
    public Post updatePost(@PathVariable @Min(1) Long id, @Valid @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping(value = "/delete")
    public boolean deletePost(@RequestParam @Min(1) Long id) {
        return postService.deletePost(id);
    }

/*    @GetMapping(value = "/{id}/parent")
    public PostResultDto getAllPostWithParent(@PathVariable @Min(1) Long id)
    {
        return postService.getPostWithParent(id);
    }*/

}
