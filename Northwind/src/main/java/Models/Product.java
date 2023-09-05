package Models;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private int productID;
    @Column(name = "SupplierID")
    private int supplierID;
    @Column(name = "CategoryID")
    private int categoryID;
    @Column(name = "Unit")
    private String unit;
    @Column(name = "Price")
    private double price;

    public Product() {
    }

    public Product(int productID) {
        this.productID = productID;
    }

    public Product(int productID, int supplierID, int categoryID, String unit, double price) {
        this.productID = productID;
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.unit = unit;
        this.price = price;
    }

    public Product(int supplierID, int categoryID, String unit, double price) {
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.unit = unit;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", supplierID=" + supplierID +
                ", categoryID=" + categoryID +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                '}';
    }
}
