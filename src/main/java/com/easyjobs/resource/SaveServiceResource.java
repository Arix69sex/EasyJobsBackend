package com.easyjobs.resource;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;

@Data
public class SaveServiceResource {

    @NotNull
    @Column(length = 25)
    private String name;

    @NotNull
    @Column(length = 250)
    private String description;

    @NotNull
    private Float price;
}
