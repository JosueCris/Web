package com.example.Northwind.ImpServices;

import com.example.Northwind.Models.Shipper;
import com.example.Northwind.Respositories.ShipperRepo;
import com.example.Northwind.Services.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IShipperService implements ShipperService {
    @Autowired
    private ShipperRepo repo;

    public IShipperService(ShipperRepo repo) {
        this.repo = repo;
    }

    @Override
    public Shipper buscar(int idShip) {
        return this.repo.findById(idShip).orElse(null);
    }

    @Override
    public List<Shipper> consultar() {
        return this.repo.findAll();
    }

    @Override
    public Shipper agregar(Shipper ship) {
        Optional<Shipper> result = Optional.ofNullable(this.buscar(ship.getShipperID()));
        if (result.isPresent())
            throw new IllegalStateException("Ya existe ese exportador!!!");
        return this.repo.save(ship);
    }

    @Override
    public Shipper actualizar(Shipper ship, int idShip) {
        Shipper aux = this.buscar(idShip);
        if (aux != null) {
            aux.setShipperName(ship.getShipperName());
            aux.setPhone(ship.getPhone());

            return this.repo.save(aux);
        }
        return null;
    }

    @Override
    public void eliminar(int idShip) {
        this.repo.deleteById(idShip);
    }
}