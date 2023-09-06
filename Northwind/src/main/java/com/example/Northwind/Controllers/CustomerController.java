package com.example.Northwind.Controllers;

import com.example.Northwind.ImpServices.ICustomerService;
import com.example.Northwind.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("northwind/api/v1")
public class CustomerController {
    @Autowired
    private ICustomerService service;

    @GetMapping
    @RequestMapping(value = "customer/get/{idCust}", method = RequestMethod.GET)
    public ResponseEntity<?> customerSearch(@PathVariable int idCust) {
        Customer aux = this.service.buscar(idCust);
        if (aux != null)
            return ResponseEntity.ok(aux);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @RequestMapping(value = "customer/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> categoryShowAll() {
        List<Customer> customers = this.service.consultar();
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    @RequestMapping(value = "customer/save", method = RequestMethod.POST)
    public void customerSave(@RequestBody Customer cust) {
        this.service.agregar(cust);
    }

    @PutMapping
    @RequestMapping(value = "customer/update/{idCust}", method = RequestMethod.PUT)
    public ResponseEntity<?> customerUpdate(@RequestBody Customer cust, @PathVariable int idCust) {
        Customer aux = this.service.actualizar(cust, idCust);
        if (aux != aux)
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @RequestMapping(value = "customer/delete/{idCust}", method = RequestMethod.DELETE)
    public ResponseEntity<?> customerDelete(@PathVariable int idCust) {
        Customer aux = this.service.buscar(idCust);
        if (aux != null) {
            this.service.eliminar(idCust);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}