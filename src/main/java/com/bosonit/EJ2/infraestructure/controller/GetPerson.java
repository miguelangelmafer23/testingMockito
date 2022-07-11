package com.bosonit.EJ2.infraestructure.controller;


import com.bosonit.EJ2.exceptions.NotFoundException;
import com.bosonit.EJ2.application.port.GetPersonPort;
import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.infraestructure.DTOs.OutPutPersonaDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class GetPerson {

    @Autowired
    GetPersonPort getPersonPort;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/id/{id}")

    public OutPutPersonaDTO getPersonByID(@PathVariable Integer id) throws Exception {
            return getPersonPort.getPersonaByID(id);
    }

    @GetMapping("/name/{nombre}")
    public List<OutPutPersonaDTO> getPersonByName(@PathVariable String nombre) throws Exception {
        return getPersonPort.getPersonByName(nombre);
    }

    @GetMapping("/all")
    public List<OutPutPersonaDTO> getAllPerson(){
        return getPersonPort.getAllPerson();
    }

}



