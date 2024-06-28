package com.blogapplication.BlogApplication.payloads;

import com.blogapplication.BlogApplication.entities.Category;
import com.blogapplication.BlogApplication.entities.Comment;
import com.blogapplication.BlogApplication.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private String title;

    private String content;
    private Integer postId;

    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;
    private Set<CommentDto> comments=new HashSet<>();
}
