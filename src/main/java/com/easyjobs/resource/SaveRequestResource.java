package com.easyjobs.resource;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;

@Data
public class SaveRequestResource {

    @NotNull
    @Column(length = 25)
    private String status;
}
