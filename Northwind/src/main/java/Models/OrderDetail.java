package Models;

import jakarta.persistence.*;

@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailID")
    private int orderDetailID;
    @Column(name = "OrderID")
    private int orderID ;
    @Column(name = "ProductID")
    private int productID;
    @Column(name = "Quantity")
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public OrderDetail(int orderID, int productID, int quantity) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public OrderDetail(int orderDetailID, int orderID, int productID, int quantity) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailID=" + orderDetailID +
                ", orderID=" + orderID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                '}';
    }
}