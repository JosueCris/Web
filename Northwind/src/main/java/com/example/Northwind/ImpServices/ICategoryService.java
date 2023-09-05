package com.example.Northwind.ImpServices;

import com.example.Northwind.Models.Category;
import com.example.Northwind.Respositories.CategoryRepo;
import com.example.Northwind.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ICategoryService implements CategoryService {
    @Autowired
    private CategoryRepo repo;

    public ICategoryService(CategoryRepo repo) {
        this.repo = repo;
    }

    @Override
    public Category buscar(int idCat) {
        return this.repo.findById(idCat).orElse(null);
    }

    @Override
    public List<Category> consultar() {
        return this.repo.findAll();
    }

    @Override
    public Category agregar(Category cat) {
        Optional<Category> result = Optional.ofNullable(this.buscar(cat.getCategoryID()));
        if (result.isPresent())
            throw new IllegalStateException("Ya existe esa categoria!!!");
        return this.repo.save(cat);
    }

    @Override
    public Category actualizar(Category cat, int idCat) {
        Category aux = buscar(idCat);
        if (aux != null) {
            aux.setCategoryName(cat.getCategoryName());
            aux.setDescription(cat.getDescription());

            return this.repo.save(aux);
        }
        return null;
    }

    @Override
    public void eliminar(int idCat) {
        this.repo.deleteById(idCat);
    }
}