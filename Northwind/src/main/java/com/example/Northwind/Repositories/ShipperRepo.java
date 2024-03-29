package com.example.Northwind.Repositories;

import com.example.Northwind.Models.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperRepo extends JpaRepository<Shipper, Integer> {
}
