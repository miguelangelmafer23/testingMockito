package com.bosonit.EJ2.application.port;

import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.infraestructure.DTOs.OutPutPersonaDTO;

import java.util.List;

public interface GetPersonPort {

    public OutPutPersonaDTO getPersonaByID(Integer id) throws Exception;

    public List <OutPutPersonaDTO> getPersonByName(String name);

    public List<OutPutPersonaDTO> getAllPerson();

}
