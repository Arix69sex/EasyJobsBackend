package com.easyjobs.integration;

import com.easyjobs.domain.model.Request;
import com.easyjobs.domain.model.Service;
import com.easyjobs.domain.model.User;
import com.easyjobs.domain.model.UserDetail;
import com.easyjobs.domain.repository.RequestRepository;
import com.easyjobs.domain.repository.ServiceRepository;
import com.easyjobs.domain.repository.UserDetailRepository;
import com.easyjobs.domain.repository.UserRepository;
import com.easyjobs.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RequestIntegrationTest {

    /*
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private RequestRepository requestRepository;

    @Test
    public void createValidRequestWithUserAndService(){
        String email = "testuser@gmail.com";
        String password = "1!23sxE35tg";

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);

        Service service = new Service();
        service.setName("Test service");
        service.setDescription("Made up service to test this integration test.");
        service.setScore(0f);
        service.setPrice(69.99f);
        service.setUser(user);
        serviceRepository.save(service);

        Request request = new Request();
        request.setStatus("pending");
        request.setUser(user);
        request.setService(service);
        requestRepository.save(request);

        User foundUser = userRepository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("User", "Id", user.getId()));
        Service foundService = serviceRepository.findById(service.getId()).orElseThrow(() -> new ResourceNotFoundException("Service", "Id", service.getId()));
        Request foundRequest = requestRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException("Request", "Id", 1L));

        assertThat(foundUser).isEqualTo(user);
        assertThat(foundService).isEqualTo(service);
        assertThat(foundRequest).isEqualTo(request);
        assertThat(requestRepository.findAllByUserId(foundUser.getId(), Pageable.unpaged()).get()).contains(foundRequest);
        assertThat(requestRepository.findAllByServiceId(foundService.getId(), Pageable.unpaged()).get()).contains(foundRequest);
    }

     */
}
