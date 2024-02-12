from django.db import models

# Create your models here.
class Category(models.Model):
    CategoryID = models.IntegerField(primary_key=True)
    CategoryName = models.CharField(max_length=20)
    Description = models.CharField(max_length=60)


class Customer(models.Model):
    CustomerID = models.IntegerField(primary_key=True)
    CustomerName = models.CharField(max_length=40)
    ContactName = models.CharField(max_length=25)
    Address = models.CharField(max_length=50)
    City = models.CharField(max_length=20)
    PostalCode = models.CharField(max_length=15)
    Country = models.CharField(max_length=15)


class Employee(models.Model):
    EmployeeID = models.IntegerField(primary_key=True)
    LastName = models.CharField(max_length=15)
    FirstName = models.CharField(max_length=10)
    BirthDate = models.DateField(auto_now_add = True)
    Photo = models.CharField(max_length=45)
    Notes = models.CharField(max_length=430)


class OrderDetail(models.Model):
    OrderDetailID = models.IntegerField(primary_key=True)
    OrderID = models.IntegerField()
    ProductID = models.IntegerField()
    Quantity = models.IntegerField()


class Order(models.Model):
    OrderID = models.IntegerField(primary_key=True)
    CustomerID = models.IntegerField()    
    EmployeeID = models.IntegerField()
    OrderDate = models.DateField(auto_now_add=True)
    ShipperDate = models.IntegerField()


class Product(models.Model):
    ProductID = models.IntegerField(primary_key=True)
    ProductName = models.CharField(max_length=40)
    SupplierID = models.IntegerField()
    CategoryID = models.IntegerField()
    Unit = models.CharField(max_length=25)
    Price = models.FloatField()


class Shipper(models.Model):
    ShipperID = models.IntegerField(primary_key=True)
    ShipperName = models.CharField(max_length=20)
    Phone = models.CharField(max_length=15)    


class Supplier(models.Model):
    SupplierID = models.IntegerField(primary_key=True)
    SupplierName = models.CharField(max_length=40)
    ContactName = models.CharField(max_length=30)
    Address = models.CharField(max_length=45)
    City = models.CharField(max_length=15)
    PostalCode = models.CharField(max_length=10)
    Country = models.CharField(max_length=15)
    Phone = models.CharField(max_length=15)