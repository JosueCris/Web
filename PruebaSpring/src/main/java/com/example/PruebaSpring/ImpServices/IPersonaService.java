package com.example.PruebaSpring.ImpServices;

import com.example.PruebaSpring.Models.Persona;
import com.example.PruebaSpring.Repositories.PersonaRepo;
import com.example.PruebaSpring.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IPersonaService implements PersonaService {
    @Autowired
    private PersonaRepo repo;

    public IPersonaService(PersonaRepo repo) {
        this.repo = repo;
    }


    @Override
    public Persona buscar(int idPersona) {
        return this.repo.findById(idPersona).orElse(null);
    }


    @Override
    public List<Persona> consultar() {
        return (List<Persona>) this.repo.findAll();
    }


    @Override
    public Persona agregar(Persona per) {
        Optional<Persona> result = repo.findById(per.getIdPersona());
        if (result.isPresent())
            throw new IllegalStateException("Ya existe esa persona!!!");
        return repo.save(per);
    }


    @Override
    public Persona actualizar(Persona per, int idPersona) {
        Persona aux = this.buscar(idPersona);
        if (aux != null) {
            aux.setNombre(per.getNombre());
            aux.setApPaterno(per.getApPaterno());
            aux.setApMaterno(per.getApMaterno());
            aux.setFechaNac(per.getFechaNac());

            return this.repo.save(aux);
        }
        return null;
    }


    @Override
    public void eliminar(int idPersona) {
        this.repo.deleteById(idPersona);
    }
}