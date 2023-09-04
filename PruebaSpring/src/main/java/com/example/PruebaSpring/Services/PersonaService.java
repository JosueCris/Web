package com.example.PruebaSpring.Services;

import com.example.PruebaSpring.Models.Persona;

import java.util.List;

public interface PersonaService {
    public List<Persona> consultar();
    public Persona agregar(Persona per) throws IllegalAccessException, IllegalStateException;
    public Persona actualizar(Persona per);
    public Persona buscar(int idPersona);
    public void eliminar(int idPersona);
}
