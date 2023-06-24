package com.example.job_service.service;

import com.example.job_service.model.Posts;
import com.example.job_service.repo.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Component
public class PostService{
    @Autowired
    PostsRepo postsRepo;


    public List<Posts> allPosts(){
        return this.postsRepo.findAll();
    }


    public List<Posts> searchPostsBy(String query){
        List<Posts> posts = postsRepo.searchPostsBy(query);
        return posts;
    }
}
