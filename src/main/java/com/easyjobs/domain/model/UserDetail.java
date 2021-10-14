package com.easyjobs.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_details")
@Data
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @NotNull
    @Column()
    private Float rating;

    @NotNull
    @Column(length = 10)
    private String status;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
}
