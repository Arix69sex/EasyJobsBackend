package com.easyjobs.unit;

import com.easyjobs.domain.model.Service;
import com.easyjobs.domain.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTest {

    @Test
    public void createServiceWithValidName(){
        Service service = new Service();

        String name = "iPhone 69 repair";
        service.setName(name);

        assertThat(service.getName()).isEqualTo(name);
    }

    @Test
    public void createServiceWithValidDescription(){
        Service service = new Service();

        String description = "I can repair any problem that your iPhone has, as long as its the 69 model.";
        service.setDescription(description);

        assertThat(service.getDescription()).isEqualTo(description);
    }

    @Test
    public void createServiceWithValidPrice(){
        Service service = new Service();

        Float price = 60.99f;
        service.setPrice(price);

        assertThat(service.getPrice()).isEqualTo(price);
    }

    @Test
    public void createServiceWithValidScore(){
        Service service = new Service();

        Float score = 0f;
        service.setScore(score);

        assertThat(service.getScore()).isEqualTo(score);
        assertThat(service.getScore()).isGreaterThanOrEqualTo(0f);
        assertThat(service.getScore()).isLessThanOrEqualTo(5f);
    }

    @Test
    public void createServiceWithValidUser(){
        Service service = new Service();

        User user = new User();

        service.setUser(user);

        assertThat(service.getUser()).isEqualTo(user);
    }
}
