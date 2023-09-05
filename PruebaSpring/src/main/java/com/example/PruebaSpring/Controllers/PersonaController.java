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
    @RequestMapping(value = "persona/get/{idPersona}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPersona(@PathVariable int idPersona) {
        Persona persona = this.service.buscar(idPersona);
        if (persona != null)
            return ResponseEntity.ok(persona);
        return ResponseEntity.noContent().build();
    }


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


    @PutMapping
    @RequestMapping(value = "persona/update/{idPersona}", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarPersona(@PathVariable int idPersona, @RequestBody Persona per) {
        Persona aux = this.service.buscar(idPersona);
        if (aux != null) {
            aux.setNombre(per.getNombre());
            aux.setApPaterno(per.getApPaterno());
            aux.setApMaterno(per.getApMaterno());
            aux.setFechaNac(per.getFechaNac());

            this.service.actualizar(aux);

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("La persona con ID " + idPersona + " no existe.");
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