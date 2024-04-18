package com.sptek.demo.cit.repository;

import com.sptek.demo.cit.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Procedure("sp_find_city_with_string")
    List<City> findStartWith(String str);
}
