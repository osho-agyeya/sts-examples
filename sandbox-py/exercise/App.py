import sys
from Account import Account

list_accounts=[]
num_accounts=-1
while(num_accounts<=0):
    try:
        num_accounts=int(input("Please enter the no. of accounts to create:"))
        if(num_accounts<=0):
            print("Invalid value of number of accounts! Re enter please!")
    except:
        print("Invalid value of number of accounts! Re enter please!")

print()
i=0
is_balance_first=True
is_id_first=True
is_name_first=True
is_correct_id=False
is_correct_name=False
is_correct_balance=False
while(i < num_accounts):
    try:
        if(not is_correct_id):
            is_id_first=False
            temp_id=int(input("Enter account id for input {0}:".format(i+1)))
            is_correct_id=True
        if(not is_correct_name):
            is_name_first=False
            temp_name=str(input("Enter account name for input {0}:".format(i+1)))
            is_correct_name=True
        if(not is_correct_balance):
            is_balance_first=False
            temp_balance=float(input("Enter account balance for input {0}:".format(i+1)))
            is_correct_balance=True
        temp_account=Account.create_account(temp_id,temp_name,temp_balance)
        list_accounts.append(temp_account)
        print("*"*50)
        is_correct_id=False
        is_correct_name=False
        is_correct_balance=False
        is_id_first=True
        is_name_first=True
        is_balance_first=True
        i+=1
    except:
        if(not is_correct_id and not is_id_first):
            print("Invalid datatype of id!Enter details again")
        if(not is_correct_name and not is_name_first):
            print("Invalid datatype of name!Enter details again")
        if(not is_correct_balance and not is_balance_first):
            print("Invalid datatype of balance!Enter details again")
print()
print("*"*50)
print("*"*50)
print("Printing all accounts")
print()
for account in list_accounts:
    account.print()
