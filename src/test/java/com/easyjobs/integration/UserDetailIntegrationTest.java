package com.easyjobs.integration;


import com.easyjobs.domain.model.User;
import com.easyjobs.domain.model.UserDetail;
import com.easyjobs.domain.repository.UserDetailRepository;
import com.easyjobs.domain.repository.UserRepository;
import com.easyjobs.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserDetailIntegrationTest {
/*
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository detailRepository;

    @Test
    public void createValidDetailWithGivenUser(){
        String email = "testuser@gmail.com";
        String password = "1!23sxE35tg";

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);

        UserDetail detail = new UserDetail();

        detail.setFirstName("John");
        detail.setLastName("Doe");
        detail.setStatus("active");
        detail.setRating(0f);
        detail.setAddress("Test street 123");
        detail.setDni("88888888");
        detail.setUser(user);
        detailRepository.save(detail);

        User foundUser = userRepository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("User", "Id", user.getId()));
        UserDetail foundDetail = detailRepository.findById(detail.getId()).orElseThrow(() -> new ResourceNotFoundException("Detail", "Id", detail.getId()));


        assertThat(foundUser).isEqualTo(user);
        assertThat(foundDetail).isEqualTo(detail);
        assertThat(detailRepository.findByUserId(foundUser.getId()).get()).isEqualTo(foundDetail);
    }

 */
}
