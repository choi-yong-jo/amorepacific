package com.sptek.demo.cit.controller;

import com.sptek.demo.cit.dto.CityResponseDto;
import com.sptek.demo.cit.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/list")
    public ResponseEntity<List<CityResponseDto>> findAllCities(){
        return ResponseEntity.ok(cityService.findAllCities() // 전체를 Find 한다.
                .stream() // 스트림으로 바꿔서
                .map(CityResponseDto::from) // DTO 타입으로 모두 변경해서
                .collect(Collectors.toList())); // List형식으로 반환
    }

    @GetMapping("/list/{str}")
    public ResponseEntity<List<CityResponseDto>> findCitysStartWith(@PathVariable final String str){
        return ResponseEntity.ok(cityService.findCitiesStartWith(str) // 만족하는 전체를 가져와서
                .stream() // 스트림으로
                .map(CityResponseDto::from) // DTO로 변경
                .collect(Collectors.toList())); // List로 반환
    }
}
