package com.example.Northwind.Services;

import com.example.Northwind.Models.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail buscar(int idOrdet);
    List<OrderDetail> consultar();
    OrderDetail agregar(OrderDetail idOrdet);
    OrderDetail actualizar(OrderDetail ordet, int idOrdet);
    void eliminar(int idOrdet);
}
