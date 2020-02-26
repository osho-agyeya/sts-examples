package com.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class CustomerServiceTestImpl implements CustomerService {


    public String getFullName() {
        return "Testing the service";
    }


}
