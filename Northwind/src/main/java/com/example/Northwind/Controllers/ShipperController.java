package com.example.Northwind.Controllers;

import com.example.Northwind.ImpServices.IShipperService;
import com.example.Northwind.Models.Shipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("northwind/api/v1")
public class ShipperController {
    @Autowired
    private IShipperService service;

    @GetMapping
    @RequestMapping(value = "shipper/get/{idShipp}", method = RequestMethod.GET)
    public ResponseEntity<?> shipperSearch(@PathVariable int idShipp) {
        Shipper aux = this.service.buscar(idShipp);
        if (aux != null)
            return ResponseEntity.ok(aux);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @RequestMapping(value = "shipper/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> orderShowAll() {
        List<Shipper> prod = this.service.consultar();
        return ResponseEntity.ok(prod);
    }

    @PostMapping
    @RequestMapping(value = "shipper/save", method = RequestMethod.POST)
    public void productSave(@RequestBody Shipper shipp) {
        this.service.agregar(shipp);
    }

    @PutMapping
    @RequestMapping(value = "shipper/update/{idShipp}", method = RequestMethod.PUT)
    public ResponseEntity<?> productUpdate(@RequestBody Shipper shipp, @PathVariable int idShipp) {
        Shipper aux = this.service.actualizar(shipp, idShipp);
        if (aux != null)
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @RequestMapping(value = "shipper/delete/{idShipp}", method = RequestMethod.DELETE)
    public ResponseEntity<?> orderDelete(@PathVariable int idShipp) {
        Shipper aux = this.service.buscar(idShipp);
        if (aux != null) {
            this.service.eliminar(idShipp);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}