package com.example.job_service.Controller;

import com.example.job_service.Model.Posts;
import com.example.job_service.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
