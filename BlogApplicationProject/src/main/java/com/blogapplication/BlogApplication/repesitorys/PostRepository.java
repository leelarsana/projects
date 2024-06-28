package com.blogapplication.BlogApplication.repesitorys;

import com.blogapplication.BlogApplication.entities.Category;
import com.blogapplication.BlogApplication.entities.Post;
import com.blogapplication.BlogApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);
    List<Post> findByTitleContaining(String title);
}
