package com.sptek.demo.cit.dto;

import com.sptek.demo.cit.model.City;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityResponseDto {
    private final String name;
    private final int code;

    // 빌더 패턴으로 형성하자.
    public static CityResponseDto from(City city){
        return CityResponseDto.builder()
                .name(city.getCity()) // 이름과
                .code(city.getId()) // id만
                .build();
    }
}
