package Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private int orderID;

    @Column(name = "CustomerID")
    private int customerID;

    @Column(name = "EmployeeID")
    private int employeeID;

    @Column(name = "OrderDate")
    private LocalDate orderDate;

    @Column(name = "ShipperID")
    private int shipperID;

    public Order() {
    }

    public Order(int orderID) {
        this.orderID = orderID;
    }

    public Order(int customerID, int employeeID, LocalDate orderDate, int shipperID) {
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.orderDate = orderDate;
        this.shipperID = shipperID;
    }

    public Order(int orderID, int customerID, int employeeID, LocalDate orderDate, int shipperID) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.orderDate = orderDate;
        this.shipperID = shipperID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", employeeID=" + employeeID +
                ", orderDate=" + orderDate +
                ", shipperID=" + shipperID +
                '}';
    }
}