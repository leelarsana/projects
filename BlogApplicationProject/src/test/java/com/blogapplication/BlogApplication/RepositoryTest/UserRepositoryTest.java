package com.blogapplication.BlogApplication.RepositoryTest;

import com.blogapplication.BlogApplication.entities.User;
import com.blogapplication.BlogApplication.repesitorys.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User u1;
    private User u2;

    @BeforeEach
    void init() {
        u1 = new User();
        //u1 id - post id
        u1.setName("Priya");
        u1.setEmail("priya@123");

        u2 = new User();
        u2.setName("Manu");
        u2.setEmail("manu@123");
    }

    @Test
    @DisplayName("it should return the user based on id")
    void getUserbyId() {

        userRepository.save(u1);


        userRepository.save(u2);

        User user = userRepository.findById(u1.getId()).orElse(null);

        assertThat(user).isNotNull();
        assertEquals(u1.getId(), user.getId());
    }

}
