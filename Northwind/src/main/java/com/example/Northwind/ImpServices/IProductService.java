package com.example.Northwind.ImpServices;

import com.example.Northwind.Models.Product;
import com.example.Northwind.Respositories.ProductRepo;
import com.example.Northwind.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IProductService implements ProductService {
    @Autowired
    private ProductRepo repo;

    public IProductService(ProductRepo repo) {
        this.repo = repo;
    }

    @Override
    public Product buscar(int idProd) {
        return this.repo.findById(idProd).orElse(null);
    }

    @Override
    public List<Product> consultar() {
        return this.repo.findAll();
    }

    @Override
    public Product agregar(Product prod) {
        Optional<Product> result = Optional.ofNullable(this.buscar(prod.getProductID()));
        if (result.isPresent())
            throw new IllegalStateException("Ya existe ese producto!!!");
        return this.repo.save(prod);
    }

    @Override
    public Product actualizar(Product prod, int idProd) {
        Product aux = this.buscar(idProd);
        if (aux != null) {
            aux.setProductName(prod.getProductName());
            aux.setSupplierID(prod.getSupplierID());
            aux.setCategoryID(prod.getCategoryID());
            aux.setUnit(prod.getUnit());
            aux.setPrice(prod.getPrice());

            return this.repo.save(aux);
        }
        return null;
    }

    @Override
    public void eliminar(int idProd) {
        this.repo.deleteById(idProd);
    }
}