from django.urls import path, include
from rest_framework import routers
from northwind import views

router = routers.DefaultRouter()
router.register(r'categories', views.CategoryViewSet)
router.register(r'customers', views.CustomerViewSet)
router.register(r'employees', views.EmployeeViewSet)
router.register(r'orderdetails', views.OrderDetailViewSet)
router.register(r'orders', views.OrderDetailViewSet)
router.register(r'products', views.ProductViewSet)
router.register(r'shippers', views.ShipperViewSet)
router.register(r'suppliers', views.SupplierViewSet)


urlpatterns = [
    path('', include(router.urls)),
]