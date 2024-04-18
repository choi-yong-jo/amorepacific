package com.sptek.demo.cit.repository;

import com.sptek.demo.cit.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
