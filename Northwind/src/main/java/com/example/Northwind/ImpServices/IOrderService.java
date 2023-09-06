package com.example.Northwind.ImpServices;

import com.example.Northwind.Models.Order;
import com.example.Northwind.Repositories.OrderRepo;
import com.example.Northwind.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IOrderService implements OrderService {
    @Autowired
    private OrderRepo repo;

    public IOrderService() {
        this.repo = repo;
    }

    @Override
    public Order buscar(int idOrd) {
        return this.repo.findById(idOrd).orElse(null);
    }

    @Override
    public List<Order> consultar() {
        return this.repo.findAll();
    }

    @Override
    public Order agregar(Order ord) {
        Optional<Order> result = Optional.ofNullable(this.buscar(ord.getOrderID()));
        if (result.isPresent())
            throw new IllegalStateException("Ya existe esa orden!!!");
        return this.repo.save(ord);
    }

    @Override
    public Order actualizar(Order ord, int idOrd) {
        Order aux = this.buscar(idOrd);
        if (aux != null) {
            aux.setCustomerID(ord.getCustomerID());
            aux.setEmployeeID(ord.getEmployeeID());
            aux.setOrderDate(ord.getOrderDate());
            aux.setShipperID(ord.getShipperID());

            return this.repo.save(aux);
        }
        return null;
    }

    @Override
    public void eliminar(int idOrd) {
        this.repo.deleteById(idOrd);
    }
}