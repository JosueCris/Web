package com.example.PruebaSpring.Controllers;

import com.example.PruebaSpring.Models.Persona;
import com.example.PruebaSpring.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping
    @RequestMapping(value = "persona/get/{idPersona}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPersona(@PathVariable int idPersona) {
        Persona aux = this.service.buscar(idPersona);
        if (aux != null)
            return ResponseEntity.ok(aux);
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
        this.service.agregar(per);
    }


    @PutMapping
    @RequestMapping(value = "persona/update/{idPersona}", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarPersona(@RequestBody Persona per, @PathVariable int idPersona) {
        Persona aux = this.service.actualizar(per, idPersona);
        if (aux != null)
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping
    @RequestMapping(value = "persona/delete/{idPersona}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarPersona(@PathVariable int idPersona) {
        Persona aux = this.service.buscar(idPersona);
        if (aux != null)
        {
            this.service.eliminar(idPersona);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}