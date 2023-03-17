package com.example.microservice.CitizenService.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.microservice.CitizenService.Entity.CitizenEntity;

import com.example.microservice.CitizenService.services.EmployeeNotFoundException;
import com.example.microservice.CitizenService.repositories.CitizenRepo;

public class CitizenServiceImplTest {

    @Mock
    private CitizenRepo mockrepo;
    @InjectMocks
    private CitizenServiceImpl citizenServiceImpl;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById() {
        int id = 3;
        CitizenEntity citizenEntity = new CitizenEntity();
        citizenEntity.setId(id);
        citizenEntity.setName("sumnima");
        citizenEntity.setVaccinationCenterId(4);

        when(mockrepo.findById(id)).thenReturn(Optional.of(citizenEntity));

        // act
        CitizenEntity result = citizenServiceImpl.getById(id);

        // assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("sumnima", result.getName());
        assertEquals(4, result.getVaccinationCenterId());
    }

    @Test(expected=EmployeeNotFoundException.class)
    public void testGetByIdWhenNotExists() {
        // arrange
        int id = 3;
        when(mockrepo.findById(id)).thenReturn(Optional.empty());

        // act & assert
        citizenServiceImpl.getById(id);
    }
    
//    @Override
//	public CitizenEntity save(CitizenEntity citizen) {
//		CitizenEntity sav = repo.save(citizen);
//		return sav;
	@Test
public void testSave() {
	int id = 3;
    CitizenEntity citizenEntity = new CitizenEntity();
    citizenEntity.setId(id);
    citizenEntity.setName("sumnima");
    citizenEntity.setVaccinationCenterId(4);
    when(mockrepo.save(citizenEntity)).thenReturn(citizenEntity);

    // act
    CitizenEntity result = citizenServiceImpl.save(citizenEntity);

    // assert
    assertNotNull(result);
    assertEquals(id, result.getId());
    assertEquals("sumnima", result.getName());
    assertEquals(4, result.getVaccinationCenterId());
}
	
}





