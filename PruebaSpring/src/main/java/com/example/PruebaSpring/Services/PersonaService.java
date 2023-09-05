package com.example.PruebaSpring.Services;

import com.example.PruebaSpring.Models.Persona;

import java.util.List;

public interface PersonaService {
    Persona buscar(int idPersona);
    List<Persona> consultar();
    Persona agregar(Persona per) throws IllegalAccessException, IllegalStateException;
    Persona actualizar(Persona per);
    void eliminar(int idPersona);
}
