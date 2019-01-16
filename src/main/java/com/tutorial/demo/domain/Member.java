package com.tutorial.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "email_")
    private String email;

    @Column(name = "cellphone_")
    private String cellphone;

    @Column(name = "password_")
    private String password;

    @Column(name = "address_")
    private String address;
}
