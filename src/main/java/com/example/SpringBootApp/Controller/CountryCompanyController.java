package com.example.SpringBootApp.Controller;


import com.example.SpringBootApp.DTOs.CompanyDto;
import com.example.SpringBootApp.DTOs.CountryDto;
import com.example.SpringBootApp.Entities.Company;
import com.example.SpringBootApp.Entities.Country;

import com.example.SpringBootApp.Mappers.CompanyMapper;
import com.example.SpringBootApp.Mappers.CountryMapper;
import com.example.SpringBootApp.Services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CountryCompanyController {



    private final CountryService countryService;
    private final CountryMapper countryMapper;
    private final CompanyMapper companyMapper;

    private final List<Country> countries = new ArrayList<>();
    private final List<Company> companies = new ArrayList<>();

    @Autowired
    public CountryCompanyController(CountryService countryService, CountryMapper countryMapper, CompanyMapper companyMapper) {
        this.countryService = countryService;
        this.countryMapper = countryMapper;
        this.companyMapper = companyMapper;

        // Initialize example data
        Country country = new Country();
        country.setId(1);
        country.setName("EGYPT");
        country.setIsoCode("EGY");
        countries.add(country);

        Company company = new Company();
        company.setId(1);
        company.setName("Sonar Dive");
        company.setCountry(country);
        companies.add(company);
    }

    @GetMapping("/countries")
    public List<CountryDto> getAllCountries() {
        return countries.stream()
                .map(country -> countryMapper.toDto(country, countryService))
                .toList();
    }

    @PostMapping("/countries")
    public CountryDto addCountry(@RequestBody CountryDto countryDto) {
        Country country = countryMapper.toEntity(countryDto);
        countries.add(country);
        return countryMapper.toDto(country, countryService);
    }

    @GetMapping("/companies")
    public List<CompanyDto> getAllCompanies() {
        return companies.stream()
                .map(company -> companyMapper.toDto(company, countryService))
                .toList();
    }

    @PostMapping("/companies")
    public CompanyDto addCompany(@RequestBody CompanyDto companyDto) {
        Company company = companyMapper.toEntity(companyDto);
        companies.add(company);
        return companyMapper.toDto(company, countryService);
    }
}

