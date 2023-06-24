package com.example.job_service.controller;

import com.example.job_service.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Autowired
    PostService postService;

    @GetMapping("/retrieveposts")
    public String getAllPosts(Model model){
        model.addAttribute("post", this.postService.allPosts() );
        return "allposts";
    }

    @GetMapping("/search")
    public String searchPost(@Param("keyword") String keyword, Model model){
        model.addAttribute("post", this.postService.searchPostsBy(keyword) );
        return "allposts";
    }

}
