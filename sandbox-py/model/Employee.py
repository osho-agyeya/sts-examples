class Employee:

    #class  (static)
    idGenerator=0

    def __init__(self,name,salary):
        Employee.idGenerator+=1
        self.id=Employee.idGenerator
        self.name=name
        self.salary=salary

    #instance
    def print(self):
        print("Emp Id: {0}, Name: {1}, Salary: {2}".format(self.id,self.name,self.salary))

    #static method
    @staticmethod
    def count():
        return Employee.idGenerator

    #class method=>factory method(it creates the objects for you)  we have to have self as a function parameter to use class members
    @classmethod
    def create_employee(cls, name, salary):
        return cls(name,salary)
