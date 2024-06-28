package com.blogapplication.BlogApplication.sevices;

import com.blogapplication.BlogApplication.entities.Post;
import com.blogapplication.BlogApplication.payloads.PostDto;
import com.blogapplication.BlogApplication.payloads.PostResponse;

import java.util.List;

public interface PostService {
    //create

    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    //update

    PostDto updatePost(PostDto postDto,Integer postId);

    //delete
    void deletePost(Integer postId);

    //getAll posts

    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);

    //get single post

    PostDto getPostById(Integer postId);

    //get all post by category

     List<PostDto> getPostByCategory(Integer categoryId);

     //get all post by user

    List<PostDto> getPostByUser(Integer userId);

    //search posts

    List<PostDto> searchPosts(String keyword);

}
