package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class CustomerServiceImpl implements CustomerService {

    @Autowired // the container will search for a proper implementation//setter
               // injection
    @Qualifier("customerRepositoryImpl") // this injects with the name
    private CustomerRepository repository;

    @Override
    public String getFullName() {
        return this.repository.getFirstName() + " " + this.repository.getLastName();
    }


}
