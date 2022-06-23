from django.shortcuts import render, redirect
from item.models import Item
from item.forms import ItemForm
# Create your views here.


def index(request):
    items = Item.objects.all()
    return render(request, "item/index.html", {'items': items})


def create(request):
    return render(request, 'item/create.html')


def save(request):
    print(request.POST)
    print(request.FILES)
    data = ItemForm(request.POST, request.FILES)
    data.save()
    return redirect("/item")


def edit(request, id):
    print(id)
    data = Item.objects.get(id=id)
    return render(request,"item/edit.html",{'data':data})



def update(request, id):
    print(id)
    data = Item.objects.get(id=id)
    form=ItemForm(request.POST, request.FILES, instance=data)
    form.save()
    return redirect("/item")



def delete(request, id):
    data = Item.objects.get(id=id)
    data.delete()
    return redirect("/item")

