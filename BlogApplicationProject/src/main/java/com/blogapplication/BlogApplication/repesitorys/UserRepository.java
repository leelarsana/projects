package com.blogapplication.BlogApplication.repesitorys;

import com.blogapplication.BlogApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {

  //controll shift t

}
