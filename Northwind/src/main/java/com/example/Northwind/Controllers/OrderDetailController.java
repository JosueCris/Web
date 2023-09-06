package com.example.Northwind.Controllers;

import com.example.Northwind.ImpServices.IOrderDetailService;
import com.example.Northwind.Models.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("northwind/api/v1")
public class OrderDetailController {
    @Autowired
    private IOrderDetailService service;

    @GetMapping
    @RequestMapping(value = "orderdetail/get/{idOrdit}", method = RequestMethod.GET)
    public ResponseEntity<?> orderDetailSearch(@PathVariable int idOrdit) {
        OrderDetail aux = this.service.buscar(idOrdit);
        if (aux != null)
            return ResponseEntity.ok(aux);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @RequestMapping(value = "orderdetail/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> orderDetailShowlAll() {
        List<OrderDetail> orderDetails = this.service.consultar();
        return ResponseEntity.ok(orderDetails);
    }

    @PostMapping
    @RequestMapping(value = "orderdetail/save", method = RequestMethod.POST)
    public void orderDetailSave(@RequestBody OrderDetail ordit) {
        this.service.agregar(ordit);
    }

    @PutMapping
    @RequestMapping(value = "orderdetail/update/{idOrdit}", method = RequestMethod.PUT)
    public ResponseEntity<?> orderDetailUpdate(@RequestBody OrderDetail ordit, @PathVariable int idOrdit) {
        OrderDetail aux = this.service.actualizar(ordit, idOrdit);
        if (aux != null)
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @RequestMapping(value = "orderdetail/delete/{idOrdit}", method = RequestMethod.DELETE)
    public ResponseEntity<?> orderDetailDelete(@PathVariable int idOrdit) {
        OrderDetail aux = this.service.buscar(idOrdit);
        if (aux != null) {
            this.service.eliminar(idOrdit);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}