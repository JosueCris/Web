package com.example.Northwind.Services;

import com.example.Northwind.Models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee buscar(int idEmp);
    List<Employee> consultar();
    Employee agregar(Employee emp);
    Employee actualizar(Employee emp, int idEmp);
    void eliminar(int idEmp);
}
