package com.easyjobs.resource;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;

@Data
public class SaveUserDetailResource {

    @NotNull
    @Column(length = 25)
    private String firstName;

    @NotNull
    @Column(length = 25)
    private String lastName;

    @NotNull
    @Column(length = 50)
    private String address;

    @NotNull
    @Column(length = 8)
    private String dni;

    private Float rating;

    @NotNull
    @Column(length = 10)
    private String status;
}
