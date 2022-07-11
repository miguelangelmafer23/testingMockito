package com.bosonit.EJ2.infraestructure.Repository;

import com.bosonit.EJ2.domain.PersonaEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonaRepository extends JpaRepository<PersonaEnt,Integer> {
    List<PersonaEnt> findByName(String name);
}
