package com.example.job_service.Service;

import com.example.job_service.Model.Posts;
import com.example.job_service.Repository.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
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
