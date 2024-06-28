package com.blogapplication.BlogApplication.ServiceTest;

import com.blogapplication.BlogApplication.entities.User;
import com.blogapplication.BlogApplication.payloads.UserDto;
import com.blogapplication.BlogApplication.repesitorys.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserServiceTesting {
    @Autowired
    private UserRepository userRepository;
    private UserDto u1;
    private UserDto u2;

    @BeforeEach
    void init() {
        u1 = new UserDto();
        u1.setName("Priya");
        u1.setEmail("priya@123");

        u2 = new UserDto();
        u2.setName("Manu");
        u2.setEmail("manu@123");
    }

    @Test
    @DisplayName("it should return the user based on id")
    void getUserbyId() {
        User user1 = convertToEntity(u1);
        User user2 = convertToEntity(u2);

        userRepository.save(user1);
        userRepository.save(user2);

        User user = userRepository.findById(user1.getId()).orElse(null);

        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(user1.getId());
    }

    private User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        // Set other fields
        return user;
    }
}
