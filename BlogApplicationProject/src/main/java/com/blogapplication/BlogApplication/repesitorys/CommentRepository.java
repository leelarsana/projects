package com.blogapplication.BlogApplication.repesitorys;

import com.blogapplication.BlogApplication.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {


}
