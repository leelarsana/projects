package com.blogapplication.BlogApplication.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //SEQUENCE=,AUTO=1,2,3,52,IDENTITY
    private int id;

    @Column(name="user_name",nullable=false,length=100)
    private String name;

    private String email;

    private String password;   //java bean class rules  constructor,class =public,fields=private ,getter and setter =public

    private String about;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)  //FetchType.EAGER: The related entity is loaded immediately along with the parent entity.
                                                                                    //    FetchType.LAZY: The related entity is loaded only when it is explicitly accessed.
    private List<Post> posts=new ArrayList<>();





}
