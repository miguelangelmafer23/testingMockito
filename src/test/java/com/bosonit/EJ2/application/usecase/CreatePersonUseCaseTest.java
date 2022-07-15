package com.bosonit.EJ2.application.usecase;

import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.infraestructure.DTOs.InputPersonaDTO;
import com.bosonit.EJ2.infraestructure.Repository.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import org.assertj.core.api.Assertions;
import org.modelmapper.ModelMapper;

import java.util.Date;


class CreatePersonUseCaseTest {

    @Mock
    private PersonaRepository personaRepository;
    @InjectMocks
    private CreatePersonUseCase createPersonUseCase;

    @InjectMocks
    private ModelMapper modelMapper;

    @Test
    void addPersona() throws Exception {
        //given

        InputPersonaDTO inputPersonaDTO = new InputPersonaDTO();

        inputPersonaDTO.setId_persona(1);
        inputPersonaDTO.setPassword(1234);
        inputPersonaDTO.setUsuario("Miguel");
        inputPersonaDTO.setName("Miguel");
        inputPersonaDTO.setSurname("Martín");
        inputPersonaDTO.setCompany_email("miguel@bosonit.com");
        inputPersonaDTO.setPersona_email("miguel@gmail.com");
        inputPersonaDTO.setCity("Madrid");
        inputPersonaDTO.setActive(true);
        inputPersonaDTO.setImagen_url("sin imagen");
        inputPersonaDTO.setCreated_date(new Date());
        inputPersonaDTO.setTermination_date(null);

        //when
        createPersonUseCase.addPersona(inputPersonaDTO);

        //then
        ArgumentCaptor<PersonaEnt> personaEntArgumentCaptor =
                ArgumentCaptor.forClass(PersonaEnt.class);

        verify(personaRepository)
                .save(personaEntArgumentCaptor.capture());

        PersonaEnt capturedPersonaEnt = personaEntArgumentCaptor.getValue();

        Assertions.assertThat(capturedPersonaEnt).isEqualTo(modelMapper.map(inputPersonaDTO,PersonaEnt.class));

    }
}