package com.bosonit.EJ2.application.usecase;

import com.bosonit.EJ2.infraestructure.Repository.PersonaRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GetPersonUseCaseTest {

    @Mock
    private PersonaRepository personaRepository;
    //private AutoCloseable autoCloseable;

    @InjectMocks
    private GetPersonUseCase getPersonUseCase;

    @InjectMocks
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() throws Exception{
        //autoCloseable = MockitoAnnotations.openMocks(this);
        getPersonUseCase = new GetPersonUseCase(personaRepository, modelMapper);
    }

    /*@AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }*/

    @Test
    @Disabled
    void getPersonaByID() {
    }

    @Test
    @Disabled
    void getPersonByName() {
    }

    @Test
    void getAllPerson() {
        //when
        getPersonUseCase.getAllPerson();
        //then
        verify(personaRepository).findAll();
    }
}