package com.example.SpringBootApp.DTOs;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {

    private  Integer id;
    private String name;
    private String isoCode;
   }



