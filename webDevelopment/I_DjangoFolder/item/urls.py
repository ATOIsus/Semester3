from django.urls import path
from item import views
urlpatterns = [
    path("", views.index),
    path("/create", views.create),
    path("/save", views.save),
    path("/edit/<int:id>", views.edit),
    path("/update/<int:id>", views.update),
    path("/delete/<int:id>", views.delete),
]
