package com.easyjobs.resource;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;

@Data
public class SaveUserResource {

    @NotNull
    @Column(length = 50)
    private String email;

    @NotNull
    @Column(length = 50)
    private String password;
}
