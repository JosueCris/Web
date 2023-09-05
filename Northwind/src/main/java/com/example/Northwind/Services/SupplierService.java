package com.example.Northwind.Services;

import com.example.Northwind.Models.Supplier;

import java.util.List;

public interface SupplierService {
    Supplier buscar(int idSupp);
    List<Supplier> consultar();
    Supplier agregar(Supplier idSupp);
    Supplier actualizar(Supplier supp, int idSupp);
    void eliminar(int idSupp);
}
