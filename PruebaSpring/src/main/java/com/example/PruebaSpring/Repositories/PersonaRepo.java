package com.example.PruebaSpring.Repositories;

import com.example.PruebaSpring.Models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepo extends JpaRepository<Persona, Integer> {
        Optional<Persona> findPersonByNombre(String nombre);
}
