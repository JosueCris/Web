package com.example.Northwind.ImpServices;

import com.example.Northwind.Models.Customer;
import com.example.Northwind.Respositories.CustomerRepo;
import com.example.Northwind.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ICustomerService implements CustomerService {
    @Autowired
    private CustomerRepo repo;

    public ICustomerService(CustomerRepo repo) {
        this.repo = repo;
    }

    @Override
    public Customer buscar(int idCust) {
        return this.repo.findById(idCust).orElse(null);
    }

    @Override
    public List<Customer> consultar() {
        return this.repo.findAll();
    }

    @Override
    public Customer agregar(Customer cust) {
        Optional<Customer> result = Optional.ofNullable(this.buscar(cust.getCustomerID()));
        if (result.isPresent())
             throw new IllegalStateException("Ya exixte ese cliente!!!");
        return this.repo.save(cust);
    }

    @Override
    public Customer actualizar(Customer cust, int idCust) {
        Customer aux = this.buscar(idCust);
        if (aux != null) {
            aux.setCustomerName(cust.getCustomerName());
            aux.setContactName(cust.getContactName());
            aux.setAddress(cust.getAddress());
            aux.setCity(cust.getCity());
            aux.setPostalCode(cust.getPostalCode());
            aux.setCountry(cust.getCountry());

            return this.repo.save(aux);
        }
        return null;
    }

    @Override
    public void eliminar(int idCust) {
        this.repo.deleteById(idCust);
    }
}