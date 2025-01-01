package com.example.SpringBootApp.Mappers;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import com.example.SpringBootApp.DTOs.CompanyDto;
import com.example.SpringBootApp.Entities.Company;
import com.example.SpringBootApp.Services.CountryService;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDto toDto(Company company,  CountryService countryService);

    Company toEntity(CompanyDto companyDto);
}