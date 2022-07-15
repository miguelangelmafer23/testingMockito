package com.bosonit.EJ2.application.usecase;

import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.infraestructure.DTOs.InputPersonaDTO;
import com.bosonit.EJ2.infraestructure.Repository.PersonaRepository;
import org.h2.command.dml.Delete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

import java.util.Date;

import static org.mockito.Mockito.verify;


class DeletePersonUseCaseTest {

    @Mock
    private PersonaRepository personaRepository;
    private AutoCloseable autoCloseable;
    @InjectMocks
    private DeletePersonUseCase deletePersonUseCase;
    @InjectMocks
    private GetPersonUseCase getPersonUseCase;
    @InjectMocks
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {


        PersonaEnt personaEnt = new PersonaEnt();

        personaEnt.setId_persona(1);
        personaEnt.setPassword(1234);
        personaEnt.setUsuario("Miguel");
        personaEnt.setName("Miguel");
        personaEnt.setSurname("Martín");
        personaEnt.setCompany_email("miguel@bosonit.com");
        personaEnt.setPersona_email("miguel@gmail.com");
        personaEnt.setCity("Madrid");
        personaEnt.setActive(true);
        personaEnt.setImagen_url("sin imagen");
        personaEnt.setCreated_date(new Date());
        personaEnt.setTermination_date(null);
    }

    @Test
    void deletePerson()  {
        deletePersonUseCase.deletePerson(1);
        verify(personaRepository).deleteById(1);
    }
}