package com.easyjobs.unit;

import com.easyjobs.domain.model.Request;
import com.easyjobs.domain.model.Service;
import com.easyjobs.domain.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestService {

    @Test
    public void createRequestWithValidStatus(){
        Request request = new Request();

        String status = "pending";
        request.setStatus(status);

        assertThat(request.getStatus()).isEqualTo("pending");
    }

    @Test
    public void createRequestWithValidService(){
        Request request = new Request();
        Service service = new Service();

        service.setId(1L);
        request.setService(service);

        assertThat(request.getService()).isEqualTo(service);
    }

    @Test
    public void createRequestWithValidUser(){
        Request request = new Request();
        User user = new User();

        user.setId(1L);
        request.setUser(user);

        assertThat(request.getUser()).isEqualTo(user);
    }


    @Test
    public void createServiceWithValidDescription(){
        Service service = new Service();

        String description = "I can repair any problem that your iPhone has, as long as its the 69 model.";
        service.setDescription(description);

        assertThat(service.getDescription()).isEqualTo(description);
    }
}
