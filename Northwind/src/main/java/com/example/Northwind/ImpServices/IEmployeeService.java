package com.example.Northwind.ImpServices;

import com.example.Northwind.Models.Employee;
import com.example.Northwind.Repositories.EmployeeRepo;
import com.example.Northwind.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IEmployeeService implements EmployeeService {
    @Autowired
    private EmployeeRepo repo;

    public IEmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    @Override
    public Employee buscar(int idEmp) {
        return this.repo.findById(idEmp).orElse(null);
    }

    @Override
    public List<Employee> consultar() {
        return this.repo.findAll();
    }

    @Override
    public Employee agregar(Employee emp) {
        Optional<Employee> result = Optional.ofNullable(this.buscar(emp.getEmployeeID()));
        if (result.isPresent())
            throw new IllegalStateException("Ya existe ese empleado!!!");
        return this.repo.save(emp);
    }

    @Override
    public Employee actualizar(Employee emp, int idEmp) {
        Employee aux = this.buscar(idEmp);
        if (aux != null) {
            aux.setLastName(emp.getLastName());
            aux.setFirstName(emp.getFirstName());
            aux.setBirthdate(emp.getBirthdate());
            aux.setPhoto(emp.getPhoto());
            aux.setNotes(emp.getNotes());

            return this.repo.save(aux);
        }
        return null;
    }

    @Override
    public void eliminar(int idEmp) {
        this.repo.deleteById(idEmp);
    }
}