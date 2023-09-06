package com.example.Northwind.ImpServices;

import com.example.Northwind.Models.Supplier;
import com.example.Northwind.Repositories.SupplierRepo;
import com.example.Northwind.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ISupplierService implements SupplierService {
    @Autowired
    private SupplierRepo repo;

    public ISupplierService(SupplierRepo repo) {
        this.repo = repo;
    }

    @Override
    public Supplier buscar(int idSupp) {
        return this.repo.findById(idSupp).orElse(null);
    }

    @Override
    public List<Supplier> consultar() {
        return this.repo.findAll();
    }

    @Override
    public Supplier agregar(Supplier supp) {
        Optional<Supplier> result = Optional.ofNullable(this.buscar(supp.getSupplierID()));
        if (result.isPresent())
            throw new IllegalStateException("Ya existe es proveedor!!!");
        return this.repo.save(supp);
    }

    @Override
    public Supplier actualizar(Supplier supp, int idSupp) {
        Supplier aux = this.buscar(idSupp);
        if (aux != null) {
            aux.setSupplierName(supp.getSupplierName());
            aux.setContactName(supp.getContactName());
            aux.setAddress(supp.getAddress());
            aux.setCity(supp.getCity());
            aux.setPostalCode(supp.getPostalCode());
            aux.setCountry(supp.getCountry());
            aux.setPhone(supp.getPhone());
        }
        return null;
    }

    @Override
    public void eliminar(int idSupp) {
        this.repo.deleteById(idSupp);
    }
}