package com.bosonit.EJ2.infraestructure.Repository;

import com.bosonit.EJ2.domain.PersonaEnt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;

@DataJpaTest
class PersonaRepositoryTest {

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    void findByName() {
        //given
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

        //when
        List <PersonaEnt> expected = personaRepository.findByName("Miguel");

        //then
        Assertions.assertThat(expected.get(0)).isEqualTo(personaEnt);
    }
}