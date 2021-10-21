package com.easyjobs.unit;

import com.easyjobs.domain.model.User;
import com.easyjobs.domain.model.UserDetail;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DetailService {

    @Test
    public void createUserDetailWithValidFirstName(){

        UserDetail userDetail = new UserDetail();
        String firstName = "John";
        userDetail.setFirstName(firstName);

        assertThat(userDetail.getFirstName()).isEqualTo(firstName);
    }

    @Test
    public void createUserDetailWithValidLastName(){

        UserDetail userDetail = new UserDetail();
        String lastName = "Doe";
        userDetail.setLastName(lastName);

        assertThat(userDetail.getLastName()).isEqualTo(lastName);
    }

    @Test
    public void createUserDetailWithValidAddress(){

        UserDetail userDetail = new UserDetail();
        String address = "Fake street 123";
        userDetail.setAddress(address);

        assertThat(userDetail.getAddress()).isEqualTo(address);
    }

    @Test
    public void createUserDetailWithValidStatus(){

        UserDetail userDetail = new UserDetail();
        String status = "active";
        userDetail.setStatus(status);

        assertThat(userDetail.getStatus()).isEqualTo("active");
    }

    @Test
    public void createUserDetailWithValidRating(){

        UserDetail userDetail = new UserDetail();
        Float rating = 0f;
        userDetail.setRating(rating);

        assertThat(userDetail.getRating()).isEqualTo(rating);
        assertThat(userDetail.getRating()).isGreaterThanOrEqualTo(0f);
        assertThat(userDetail.getRating()).isLessThanOrEqualTo(5f);
    }

    @Test
    public void createUserDetailWithValidUser(){

        UserDetail userDetail = new UserDetail();

        User user = new User();
        user.setId(1L);

        userDetail.setUser(user);

        assertThat(userDetail.getUser()).isEqualTo(user);
    }
}
