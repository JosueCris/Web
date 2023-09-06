package com.example.Northwind.Controllers;

import com.example.Northwind.ImpServices.IOrderService;
import com.example.Northwind.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("northwind/api/v1")
public class OrderController {
    @Autowired
    private IOrderService service;

    @GetMapping
    @RequestMapping(value = "order/get/{idOrd}", method = RequestMethod.GET)
    public ResponseEntity<?> orderSearch(@PathVariable int idOrd) {
        Order aux = this.service.buscar(idOrd);
        if (aux != null)
            return ResponseEntity.ok(aux);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @RequestMapping(value = "order/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> orderShowAll() {
        List<Order> orders = this.service.consultar();
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    @RequestMapping(value = "orders/save", method = RequestMethod.POST)
    public void orderSave(@RequestBody Order ord) {
        this.service.agregar(ord);
    }

    @PutMapping
    @RequestMapping(value = "order/update/{idOrd}", method = RequestMethod.PUT)
    public ResponseEntity<?> orderUpdate(@RequestBody Order ord, @PathVariable int idOrd) {
        Order aux = this.service.actualizar(ord, idOrd);
        if (aux != null)
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @RequestMapping(value = "order/delete/{idOrd}", method = RequestMethod.DELETE)
    public ResponseEntity<?> orderDelete(@PathVariable int idOrd) {
        Order aux = this.service.buscar(idOrd);
        if (aux != null) {
            this.service.eliminar(idOrd);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}