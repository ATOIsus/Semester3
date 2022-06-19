from django.shortcuts import render
from item.models import Item

# Create your views here.
def index(request):
    items=Item.objects.all()
    return render(request, "item/index.html", {'items':items})