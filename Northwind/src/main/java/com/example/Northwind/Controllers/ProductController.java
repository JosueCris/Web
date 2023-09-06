package com.example.Northwind.Controllers;

import com.example.Northwind.ImpServices.IProductService;
import com.example.Northwind.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("northwind/api/v1")
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping
    @RequestMapping(value = "product/get/{idProd}", method = RequestMethod.GET)
    public ResponseEntity<?> productSearch(@PathVariable int idProd) {
        Product aux = this.service.buscar(idProd);
        if (aux != null)
            return ResponseEntity.ok(aux);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @RequestMapping(value = "product/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> orderShowAll() {
        List<Product> prod = this.service.consultar();
        return ResponseEntity.ok(prod);
    }

    @PostMapping
    @RequestMapping(value = "product/save", method = RequestMethod.POST)
    public void productSave(@RequestBody Product prod) {
        this.service.agregar(prod);
    }

    @PutMapping
    @RequestMapping(value = "product/update/{idProd}", method = RequestMethod.PUT)
    public ResponseEntity<?> productUpdate(@RequestBody Product prod, @PathVariable int idProd) {
        Product aux = this.service.actualizar(prod, idProd);
        if (aux != null)
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @RequestMapping(value = "product/delete/{idProd}", method = RequestMethod.DELETE)
    public ResponseEntity<?> orderDelete(@PathVariable int idProd) {
        Product aux = this.service.buscar(idProd);
        if (aux != null) {
            this.service.eliminar(idProd);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}