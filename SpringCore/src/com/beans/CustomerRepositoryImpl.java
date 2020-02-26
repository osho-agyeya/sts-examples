package com.beans;

import org.springframework.stereotype.Repository;

@Repository // service, repository and controller any three of
            // these can be
// used. we use repositry here since it interacts with repository
public class CustomerRepositoryImpl implements CustomerRepository { // the bean
                                                                    // name
                                                                    // becomes
                                                                    // class
                                                                    // name
                                                                    // camel
                                                                    // cased

    @Override
    public String getFirstName() {
        return "Lionel";
    }

    @Override
    public String getLastName() {
        return "Messi";
    }

}
