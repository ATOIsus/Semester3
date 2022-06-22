from django.db import models

# Create your models here.

class Item(models.Model):
    id = models.AutoField(auto_created=True, primary_key=True)
    itemName = models.CharField(max_length=255)
    itemImage=models.FileField(upload_to="static/image/item", default="default.jpg")




    class meta:
        db_table="item"