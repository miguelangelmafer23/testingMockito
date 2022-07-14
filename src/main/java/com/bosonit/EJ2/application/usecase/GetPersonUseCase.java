package com.bosonit.EJ2.application.usecase;

import com.bosonit.EJ2.exceptions.NotFoundException;
import com.bosonit.EJ2.application.port.GetPersonPort;
import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.infraestructure.DTOs.OutPutPersonaDTO;
import com.bosonit.EJ2.infraestructure.Repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonUseCase implements GetPersonPort {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ModelMapper modelMapper;

    public GetPersonUseCase(PersonaRepository personaRepository, ModelMapper modelMapper) {
        this.personaRepository = personaRepository;
        this.modelMapper = modelMapper;
    }

    public OutPutPersonaDTO getPersonaByID(Integer id) throws Exception
    {
        PersonaEnt personaEnt = personaRepository.findById(id).orElseThrow(()-> new NotFoundException("Usuario no encontrado")) ;
        OutPutPersonaDTO outPutPersonaDTO = modelMapper.map(personaEnt,OutPutPersonaDTO.class);
        return outPutPersonaDTO;
    }

    //getnombre

    public List <OutPutPersonaDTO> getPersonByName(String name){
        List <PersonaEnt> listPersona = personaRepository.findByName(name);
        TypeToken<List<OutPutPersonaDTO>> typeToken = new TypeToken<>() {
        };
        List <OutPutPersonaDTO> outPutPersonaDTOList = modelMapper.map(listPersona, typeToken.getType());
        return outPutPersonaDTOList;
    }

    //getall

    public List<OutPutPersonaDTO> getAllPerson() {
        List<PersonaEnt> personaList = personaRepository.findAll();
        TypeToken<List<OutPutPersonaDTO>> typeToken = new TypeToken<>() {
        };
        List<OutPutPersonaDTO> outPutPersonaDTOList = modelMapper.map(personaList , typeToken.getType());

        return outPutPersonaDTOList;
    }

}
