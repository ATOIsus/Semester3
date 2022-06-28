import re
from django.shortcuts import render, redirect
from django.contrib.auth import authenticate, logout, login
from django.contrib.auth import get_user_model


User = get_user_model()

def register(request):
    print(request.method)
    if request.method == "POST":

        print(request.POST)

        User.objects.create_user(
            first_name=request.POST['firstname'],
            last_name=request.POST['lastname'],
            email=request.POST['email'],
            username=request.POST['username'],
            password=request.POST['password'],
        )

        return redirect('/user/login')
    else:
        return render(request, "user/register.html")


def loginFun(request):

    if request.method == "POST":
        user = authenticate(
            request, username=request.POST['username'], password=request.POST['password'])

        if user is not None:
            login(request, user)
            return redirect('/item/create')

        else:
            print("wrong username")
            return redirect('/user/login')

    else:
        return render(request, "user/login.html")


def logoutFun(request):
    logout(request)
    return redirect('/user/login')
