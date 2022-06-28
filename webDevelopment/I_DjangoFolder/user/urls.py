from django.urls import path
from user import view
urlpatterns = [
    path("", view.register),
    path("/login", view.loginFun),
    path("/logout", view.logoutFun),
]
