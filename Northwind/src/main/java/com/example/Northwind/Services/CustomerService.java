package com.example.Northwind.Services;

import com.example.Northwind.Models.Customer;

import java.util.List;

public interface CustomerService {
    Customer buscar(int idCustomer);
    List<Customer> consultar();
    Customer agregar(Customer cust);
    Customer actualizar(Customer cust, int idCust);
    void eliminar(int idCust);
}
