package com.bosonit.EJ2.application.usecase;

import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.infraestructure.DTOs.OutPutPersonaDTO;
import com.bosonit.EJ2.infraestructure.Repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

class GetPersonUseCaseTest {

    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private GetPersonUseCase getPersonUseCase;

    private OutPutPersonaDTO outPutPersonaDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        outPutPersonaDTO = new OutPutPersonaDTO();
        outPutPersonaDTO.setName("Miguel");
        outPutPersonaDTO.setSurname("Martin");
        outPutPersonaDTO.setCity("Madrid");
        outPutPersonaDTO.setPassword(1234);
        outPutPersonaDTO.setActive(true);
        outPutPersonaDTO.setPersona_email("Miguel");
        outPutPersonaDTO.setCompany_email("Miguel");

    }

    @Test
    void getAllPerson() {
        when(personaRepository.findAll()).thenReturn(Arrays.asList(outPutPersonaDTO));
        assertNotNull(getPersonUseCase.getAllPerson());
    }
