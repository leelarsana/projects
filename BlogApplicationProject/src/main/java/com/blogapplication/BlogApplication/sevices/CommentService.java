package com.blogapplication.BlogApplication.sevices;

import com.blogapplication.BlogApplication.payloads.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,Integer postId);
    void deleteComment(Integer commentId);

}
