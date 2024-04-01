package com.sptek.demo.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Users {
	
	@Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String password;
}
