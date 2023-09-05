package com.example.Northwind.Services;

import com.example.Northwind.Models.Order;

import java.util.List;

public interface OrderService {
    Order buscar(int idOrd);
    List<Order> consultar();
    Order agregar(Order ord);
    Order actualizar(Order ord, int idOrd);
    void eliminar(int idOrd);
}
