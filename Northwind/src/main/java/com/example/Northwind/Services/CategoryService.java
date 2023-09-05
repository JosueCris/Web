package com.example.Northwind.Services;

import com.example.Northwind.Models.Category;

import java.util.List;

public interface CategoryService {
    Category buscar(int idCat);
    List<Category> consultar();
    Category agregar(Category cat);
    Category actualizar(Category cat, int idCat);
    void eliminar(int idCat);
}
