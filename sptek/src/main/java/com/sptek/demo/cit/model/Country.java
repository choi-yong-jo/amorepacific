package com.sptek.demo.cit.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="country_id")
    private Integer id;

    @Column(name = "country_nm", nullable = false, length = 50)
    private String name;
}
