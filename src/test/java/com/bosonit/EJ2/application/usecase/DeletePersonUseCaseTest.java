package com.bosonit.EJ2.application.usecase;

import com.bosonit.EJ2.infraestructure.Repository.PersonaRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class DeletePersonUseCaseTest {

    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private DeletePersonUseCase deletePersonUseCase;

    @InjectMocks
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        deletePersonUseCase = new DeletePersonUseCase(personaRepository, modelMapper);
    }

    @Test
    void deletePerson()  {
        deletePersonUseCase.deletePerson(1);
        verify(personaRepository).deleteById(1);
    }
}