package com.example.job_service.Repository;

import com.example.job_service.Model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostsRepo extends JpaRepository<Posts, Integer> {

    @Query("Select p from Posts p Where p.title LIKE " +
    "CONCAT('%', :query, '%')" + "Or p.description LIKE CONCAT('%', :query, '%')")
    List<Posts> searchPostsBy(String query);
}
