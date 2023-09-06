package com.example.Northwind.Controllers;

import com.example.Northwind.ImpServices.IEmployeeService;
import com.example.Northwind.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("northwind/api/v1")
public class EmployeeController {
    @Autowired
    private IEmployeeService service;

    @GetMapping
    @RequestMapping(value = "employee/get/{idEmp}", method = RequestMethod.GET)
    public ResponseEntity<?> employeeSearch(@PathVariable int idEmp) {
        Employee aux = this.service.buscar(idEmp);
        if (aux != null)
            return ResponseEntity.ok(aux);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @RequestMapping(value = "employee/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> employeeShowAll() {
        List<Employee> employees = this.service.consultar();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    @RequestMapping(value = "employee/save", method = RequestMethod.POST)
    public void employeeSave(@RequestBody Employee emp) {
        this.service.agregar(emp);
    }

    @PutMapping
    @RequestMapping(value = "employee/update/{idEmp}", method = RequestMethod.PUT)
    public ResponseEntity<?> employeeUpdate(@RequestBody Employee emp, @PathVariable int idEmp) {
        Employee aux = this.service.actualizar(emp, idEmp);
        if (aux != null)
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @RequestMapping(value = "employee/delete/{idEmp}", method = RequestMethod.DELETE)
    public ResponseEntity<?> employeeDelete(@PathVariable int idEmp) {
        Employee aux = this.service.buscar(idEmp);
        if (aux != null) {
            this.service.eliminar(idEmp);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}