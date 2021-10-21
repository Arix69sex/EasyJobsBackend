package com.easyjobs.unit;

import com.easyjobs.domain.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    public void createUserWithValidEmail(){
        User user = new User();

        String email = "testemail@gmail.com";
        user.setEmail(email);

        assertThat(user.getEmail()).isEqualTo(email);
    }

    @Test
    public void createUserWithValidPassword(){
        User user = new User();

        String password = "123testpass321";
        user.setPassword(password);

        assertThat(user.getPassword()).isEqualTo(password);
    }
}
