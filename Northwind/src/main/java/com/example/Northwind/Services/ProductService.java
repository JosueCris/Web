package com.example.Northwind.Services;

import com.example.Northwind.Models.Product;

import java.util.List;

public interface ProductService {
    Product buscar(int idProd);
    List<Product> consultar();
    Product agregar(Product idProd);
    Product actualizar(Product prod, int idProd);
    void eliminar(int idProd);
}
