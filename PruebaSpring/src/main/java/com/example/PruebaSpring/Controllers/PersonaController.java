package com.example.PruebaSpring.Controllers;

import com.example.PruebaSpring.Models.Persona;
import com.example.PruebaSpring.Repositories.PersonaRepo;
import com.example.PruebaSpring.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PersonaController {

    @Autowired
    private PersonaRepo repo;
    @Autowired
    private PersonaService service;

    @GetMapping
    @RequestMapping(value = "persona/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> consultarPersonas() {
        List<Persona> lista = this.service.consultar();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @RequestMapping(value = "persona/save", method = RequestMethod.POST)
    public void agregarPersona(@RequestBody Persona per) {
        try {
            this.service.agregar(per);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @PostMapping
    @RequestMapping(value = "persona/update", method = RequestMethod.POST)
    public ResponseEntity<?> actualizarPersona(@RequestBody Persona per) {
        Persona nuevo = this.service.actualizar(per);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping
    @RequestMapping(value = "persona/get/{idPersona}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPersona(@PathVariable int idPersona) {
        Persona persona = this.service.buscar(idPersona);
        if (persona != null)
            return ResponseEntity.ok(persona);
        return ResponseEntity.noContent().build();
    }



    @DeleteMapping
    @RequestMapping(value = "persona/delete/{idPersona}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarPersona(@PathVariable int idPersona) {
        Persona persona = this.service.buscar(idPersona);
        if (persona == null)
            return ResponseEntity.noContent().build();
        this.service.eliminar(idPersona);
        return ResponseEntity.ok().build();
    }

}