package com.easyjobs.resource;

import lombok.Data;

@Data
public class UserDetailResource {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String dni;

    private Float rating;

    private String status;
}
