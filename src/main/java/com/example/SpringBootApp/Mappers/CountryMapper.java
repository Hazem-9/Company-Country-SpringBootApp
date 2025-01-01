package com.example.SpringBootApp.Mappers;

import com.example.SpringBootApp.DTOs.CountryDto;
import com.example.SpringBootApp.Entities.Country;
import com.example.SpringBootApp.Services.CountryService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryDto toDto(Country country, CountryService countryService);

    Country toEntity(CountryDto countryDto);
}