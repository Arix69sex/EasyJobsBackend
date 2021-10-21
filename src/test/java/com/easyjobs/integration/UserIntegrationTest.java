package com.easyjobs.integration;

import com.easyjobs.domain.model.User;
import com.easyjobs.domain.repository.UserRepository;
import com.easyjobs.domain.service.UserService;
import com.easyjobs.exception.ResourceNotFoundException;
import com.easyjobs.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createValidUser(){
        String email = "testuser@gmail.com";
        String password = "1!23sxE35tg";

        User user = new User();

        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user);

        User foundUser = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User", "Email", email));

        assertThat(foundUser).isEqualTo(user);
    }
}
