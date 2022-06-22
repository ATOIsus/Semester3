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
