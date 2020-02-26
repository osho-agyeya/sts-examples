package com.beans;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryMockImpl implements CustomerRepository

{

    public String getFirstName() {
        // TODO Auto-generated method stub
        return "Abc";
    }


    public String getLastName() {
        // TODO Auto-generated method stub
        return "xyz";
    }

}
