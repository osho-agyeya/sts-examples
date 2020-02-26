

def add(x=0,y=0):
    return x+y

'''
def add(x,y,z): // this one is used
    return x+y+z
'''
print(add())
print(add(10))
print(add(y=9))
print(add(10,20))
print(add(y=20,x=19))
#print(add(10,20,30))

def sum(*args):
    summ=0
    for i in args:
        summ+=i
    return summ


print(sum(23,4))
