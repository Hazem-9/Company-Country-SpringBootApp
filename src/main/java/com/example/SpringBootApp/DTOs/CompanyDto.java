package com.example.SpringBootApp.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CompanyDto {

    private int id;
    private String name;
    private CountryDto country;



}

