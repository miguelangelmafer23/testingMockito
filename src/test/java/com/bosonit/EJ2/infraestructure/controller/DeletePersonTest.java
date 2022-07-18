package com.bosonit.EJ2.infraestructure.controller;

import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.infraestructure.Repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
class DeletePersonTest {

    @LocalServerPort
    int puerto;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private PersonaRepository personaRepository;

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

        personaRepository.save(personaEnt);
    }

    @Test
    void deletePerson() {
        RequestEntity<Void> request = RequestEntity.delete("http://localhost:"+puerto+"/person/delete/"+1)
                .accept(MediaType.ALL).build();

        ParameterizedTypeReference<String> mensaje =
                new ParameterizedTypeReference<String>() {};
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(request, mensaje);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
        Assertions.assertThat(responseEntity.getBody()).isEqualTo("Persona eliminada");
    }
}