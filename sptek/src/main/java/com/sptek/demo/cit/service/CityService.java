package com.sptek.demo.cit.service;

import com.sptek.demo.cit.model.City;
import com.sptek.demo.cit.repository.CityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAllCities() {
        List<City> cities = cityRepository.findAll();
        return cities.isEmpty() ? Collections.emptyList() : cities;
    }

    @Transactional
    public List<City> findCitiesStartWith(final String str) {
        List<City> cities = cityRepository.findStartWith(str);
        return cities.isEmpty() ? Collections.emptyList() : cities;
    }

}
