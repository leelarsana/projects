package com.blogapplication.BlogApplication.sevices.impl;

import com.blogapplication.BlogApplication.entities.Comment;
import com.blogapplication.BlogApplication.entities.Post;
import com.blogapplication.BlogApplication.exceptions.ResourceNotFoundException;
import com.blogapplication.BlogApplication.payloads.CommentDto;
import com.blogapplication.BlogApplication.repesitorys.CommentRepository;
import com.blogapplication.BlogApplication.repesitorys.PostRepository;
import com.blogapplication.BlogApplication.sevices.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceimpl implements CommentService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post=this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post id",postId));
        Comment comment=this.modelMapper.map(commentDto,Comment.class);
        comment.setPost(post);
        Comment savedComment=this.commentRepository.save(comment);

        return this.modelMapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment=this.commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","CommentId",commentId));
        this.commentRepository.delete(comment);

    }
}
