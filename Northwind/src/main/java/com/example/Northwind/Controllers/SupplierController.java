package com.example.Northwind.Controllers;

import com.example.Northwind.ImpServices.ISupplierService;
import com.example.Northwind.Models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("northwind/api/v1")
public class SupplierController {
    @Autowired
    private ISupplierService service;

    @GetMapping
    @RequestMapping(value = "supplier/get/{idSupp}", method = RequestMethod.GET)
    public ResponseEntity<?> supplierSearch(@PathVariable int idSupp) {
        Supplier aux = this.service.buscar(idSupp);
        if (aux != null)
            return ResponseEntity.ok(aux);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @RequestMapping(value = "supplier/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> supplierShowAll() {
        List<Supplier> supp = this.service.consultar();
        return ResponseEntity.ok(supp);
    }

    @PostMapping
    @RequestMapping(value = "supplier/save", method = RequestMethod.POST)
    public void supplierSave(@RequestBody Supplier supp) {
        this.service.agregar(supp);
    }

    @PutMapping
    @RequestMapping(value = "supplier/update/{idSupp}", method = RequestMethod.PUT)
    public ResponseEntity<?> supplierUpdate(@RequestBody Supplier supp, @PathVariable int idSupp) {
        Supplier aux = this.service.actualizar(supp, idSupp);
        if (aux != null)
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @RequestMapping(value = "supplier/delete/{idSupp}", method = RequestMethod.DELETE)
    public ResponseEntity<?> supplierDelete(@PathVariable int idSupp) {
        Supplier aux = this.service.buscar(idSupp);
        if (aux != null) {
            this.service.eliminar(idSupp);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}