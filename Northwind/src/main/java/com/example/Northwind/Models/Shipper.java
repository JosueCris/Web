package com.example.Northwind.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "shippers")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShipperID")
    private int shipperID;
    @Column(name = "ShipperName")
    private String shipperName;
    @Column(name = "Phone")
    private String phone;

    public Shipper() {
    }

    public Shipper(int shipperID) {
        this.shipperID = shipperID;
    }

    public Shipper(String shipperName, String phone) {
        this.shipperName = shipperName;
        this.phone = phone;
    }

    public Shipper(int shipperID, String shipperName, String phone) {
        this.shipperID = shipperID;
        this.shipperName = shipperName;
        this.phone = phone;
    }

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Shipper{" +
                "shipperID=" + shipperID +
                ", shipperName='" + shipperName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}