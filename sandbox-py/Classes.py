'''
class MyClass:
    pass

    def __init__(self): #constructor
        print("Cons")

    def __del__(self): #destrucotr
        print("Desc")


obj=MyClass()
obj=MyClass()
print(type(obj))

#del objj

print("Ended")

'''

import datetime

class Product:

    def __init__(self, name=None, price=None):
        self.name=name
        self.__price=price #private
        self.createDate=datetime.datetime.now()

    def __str__(self):
        return "Name={0} Cost={1} Time={2}".format(self.name,self.__price,self.createDate)

    @property
    def price(self):
        print("price getter")
        return self.__price

    @price.setter
    def price(self, price):
        print("Setter")
        if isinstance(price, float):
            self.__price=price
        else:
            raise TypeError()

p1=Product()
print(p1)

p2=Product("Oho",234)

print(p2)

print(p2.name)
print(p2.price)

p2.price=999.

print(p2.price)

print("ended")
