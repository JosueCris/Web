package com.example.Northwind.ImpServices;

import com.example.Northwind.Models.OrderDetail;
import com.example.Northwind.Repositories.OrderDetailRepo;
import com.example.Northwind.Services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IOrderDetailService implements OrderDetailService {
    @Autowired
    private OrderDetailRepo repo;

    public IOrderDetailService(OrderDetailRepo repo) {
        this.repo = repo;
    }

    @Override
    public OrderDetail buscar(int idOrdet) {
        return this.repo.findById(idOrdet).orElse(null);
    }

    @Override
    public List<OrderDetail> consultar() {
        return this.repo.findAll();
    }

    @Override
    public OrderDetail agregar(OrderDetail ordet) {
        Optional<OrderDetail> result = Optional.ofNullable(this.buscar(ordet.getOrderDetailID()));
        if (result.isPresent())
            throw new IllegalStateException("Ya existen detalles de esa orden!!!");
        return this.repo.save(ordet);
    }

    @Override
    public OrderDetail actualizar(OrderDetail ordet, int idOrdet) {
        OrderDetail aux = this.buscar(idOrdet);
        if (aux != null) {
            aux.setOrderID(ordet.getOrderID());
            aux.setProductID(ordet.getProductID());
            aux.setQuantity(ordet.getQuantity());

            return this.repo.save(aux);
        }
        return null;
    }

    @Override
    public void eliminar(int idOrdet) {
        this.repo.deleteById(idOrdet);
    }
}