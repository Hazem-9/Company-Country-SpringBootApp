package com.example.SpringBootApp;

import com.example.SpringBootApp.DTOs.CountryDto;
import com.example.SpringBootApp.Entities.Country;
import com.example.SpringBootApp.Mappers.CountryMapper;
import com.example.SpringBootApp.Services.CountryService;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;

public class CountryMapperTest {

    private final CountryMapper countryMapper = Mappers.getMapper(CountryMapper.class);
    private final CountryService service = new CountryService();

    @Test
    public void testToDto() {
        Country country = new Country();
        country.setId(1);
        country.setIsoCode("EGY");

        CountryDto dto = countryMapper.toDto(country, service);

//        assertEquals(1, dto.id());
//        assertEquals("name of EGY", dto.name());
    }

    @Test
    public void testToEntity() {
        CountryDto dto = new CountryDto();
        Country country = countryMapper.toEntity(dto);

        assertEquals(1, country.getId());
        assertEquals(null, country.getIsoCode());
    }
}
