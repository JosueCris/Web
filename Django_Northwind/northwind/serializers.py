from rest_framework import serializers
from .models import *

class CategorySerializer(serializers.ModelSerializer):
    class Meta:
        model = Category
        fields = '__all__'


class CustomerSerializer(serializers.ModelSerializer):
    class Meta:
        model = Customer
        fields = '__all__'


class EmployeeSerializer(serializers.ModelSerializer):
    class Meta:
        model = Employee
        fields = '__all__'


class OrderDetailSerializer(serializers.ModelSerializer):
    class Meta:
        model = OrderDetail
        fields = '__all__'


class OrderSerializer(serializers.ModelSerializer):
    class Meta:
        model = Order
        fields = '__all__'


class ProductSerializer(serializers.ModelSerializer):
    class Meta:
        model = Product
        fields = '__all__'


class ShipperSerializer(serializers.ModelSerializer):
    class Meta:
        model = Shipper
        fields = '__all__'


class SupplierSerializer(serializers.ModelSerializer):
    class Meta:
        model = Supplier
        fields = '__all__'        


class CombinedSerializer(serializers.Serializer):
    categories = CategorySerializer(many=True)
    customers = CustomerSerializer(many=True)
    employees = EmployeeSerializer(many=True)
    orderdetails = OrderDetailSerializer(many=True)
    orders = OrderSerializer(many=True)
    products = ProductSerializer(many=True)
    shippers = ShipperSerializer(many=True)
    suppliers = SupplierSerializer(many=True)