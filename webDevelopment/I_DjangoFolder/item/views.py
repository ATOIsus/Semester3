from django.shortcuts import render, redirect
from item.models import Item
from item.forms import ItemForm

from django.contrib.auth.decorators import login_required
# Create your views here.


@login_required(login_url="/user/login")
def index(request):
    items = Item.objects.all()
    return render(request, "item/index.html", {'items': items})

@login_required(login_url="/user/login")
def create(request):
    return render(request, 'item/create.html')

@login_required(login_url="/user/login")
def save(request):
    print(request.POST)
    print(request.FILES)
    data = ItemForm(request.POST, request.FILES)
    data.save()
    return redirect("/item")

@login_required(login_url="/user/login")
def edit(request, id):
    print(id)
    data = Item.objects.get(id=id)
    return render(request,"item/edit.html",{'data':data})


@login_required(login_url="/user/login")
def update(request, id):
    print(id)
    data = Item.objects.get(id=id)
    form=ItemForm(request.POST, request.FILES, instance=data)
    form.save()
    return redirect("/item")


@login_required(login_url="/user/login")
def delete(request, id):
    data = Item.objects.get(id=id)
    data.delete()
    return redirect("/item")

