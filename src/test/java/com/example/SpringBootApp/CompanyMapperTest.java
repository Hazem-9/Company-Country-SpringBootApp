package com.example.SpringBootApp;

import com.example.SpringBootApp.DTOs.CompanyDto;
import com.example.SpringBootApp.DTOs.CountryDto;
import com.example.SpringBootApp.Entities.Company;
import com.example.SpringBootApp.Entities.Country;
import com.example.SpringBootApp.Mappers.CompanyMapper;
import com.example.SpringBootApp.Mappers.CountryMapper;
import com.example.SpringBootApp.Services.CountryService;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;

public class CompanyMapperTest {

    private final CompanyMapper mapper = Mappers.getMapper(CompanyMapper.class);
    private final CountryService service = new CountryService();

    @Test
    public void testToDto() {
        // Prepare data for Company and Country
        Country country = new Country();
        country.setId(1);
        country.setIsoCode("US");

        Company company = new Company();
        company.setId(1);
        company.setName("Tech Corp");
        company.setCountry(country);

        // Perform mapping
        CompanyDto dto = mapper.toDto(company, service);

        // Assertions for mapping correctness
        assertEquals(1, dto.getId()); // Verifying CompanyDto id
        assertEquals("Tech Corp", dto.getName()); // Verifying CompanyDto name
        assertEquals("name of US", dto.getCountry().getName()); // Verifying CountryDto name (derived from CountryService)
    }

    @Test
    public void testToEntity() {
        // Prepare data for CountryDto and CompanyDto
        CountryDto countryDto = new CountryDto();
        CompanyDto dto = new CompanyDto(1, "Tech Corp", countryDto);

        // Perform mapping
        Company company = mapper.toEntity(dto);

        // Assertions for mapping correctness
        assertEquals(1, company.getId()); // Verifying Company id
        assertEquals("Tech Corp", company.getName()); // Verifying Company name
        assertEquals(1, company.getCountry().getId()); // Verifying associated Country id
    }
}