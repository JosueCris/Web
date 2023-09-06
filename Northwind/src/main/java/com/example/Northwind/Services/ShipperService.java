package com.example.Northwind.Services;

import com.example.Northwind.Models.Shipper;

import java.util.List;

public interface ShipperService {
    Shipper buscar(int idShip);
    List<Shipper> consultar();
    Shipper agregar(Shipper ship);
    Shipper actualizar(Shipper ship, int idShip);
    void eliminar(int idShip);
}
