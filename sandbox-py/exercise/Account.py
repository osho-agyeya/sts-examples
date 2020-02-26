class Account:

    def __init__(self,id,name,balance):
        self.__id=id
        self.__name=name
        self.__balance=balance

    @property
    def name(self):
        return self.__name

    @property
    def balance(self):
        return self.__balance

    @property
    def id(self):
        return self.__id

    @name.setter
    def name(self, name):
        if isinstance(name, str):
            self.__name=name
        else:
            raise TypeError()

    @name.setter
    def balance(self, balance):
        if isinstance(balance, float):
            self.__balance=balance
        else:
            raise TypeError()

    @name.setter
    def id(self, id):
        if isinstance(id, int):
            self.__id=id
        else:
            raise TypeError()

    def print(self):
        print("Account Id: {0}, Name: {1}, Balance: {2}".format(self.__id,self.__name,self.__balance))

    @classmethod
    def create_account(cls, id, name, balance):
        if (isinstance(id,int) and isinstance(name,str) and isinstance(balance,float)):
            return cls(id,name,balance)
        else:
            raise TypeError()
