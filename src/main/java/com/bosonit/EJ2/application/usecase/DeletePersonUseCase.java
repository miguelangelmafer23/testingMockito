package com.bosonit.EJ2.application.usecase;

import com.bosonit.EJ2.application.port.DeletePersonPort;
import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.exceptions.NotFoundException;
import com.bosonit.EJ2.infraestructure.Repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletePersonUseCase implements DeletePersonPort {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    GetPersonUseCase getPersonUseCase;
    @Autowired
    ModelMapper modelMapper;

    public DeletePersonUseCase(PersonaRepository personaRepository, ModelMapper modelMapper) {
        this.personaRepository = personaRepository;
        this.modelMapper = modelMapper;
    }

    public String deletePerson(Integer id){
        try {
            personaRepository.deleteById(id);
            return "Persona eliminada";
        } catch (Exception e) {
            throw new NotFoundException("El ususario: " + id + " no existe y no se puede eliminar");
        }
    }
}
