from model.Employee import Employee

print(Employee.count())
e1=Employee("Anil",200)
e1.print()
print(Employee.count())
e2=Employee("Osho",540)
e2.print()
print(Employee.count())
e3=Employee.create_employee("Steve",7800)
e3.print()
print(Employee.count())
