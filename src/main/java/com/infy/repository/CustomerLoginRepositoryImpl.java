package com.infy.repository;

import com.infy.dto.CustomerLoginDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository(value = "customerLoginRepository")
public class CustomerLoginRepositoryImpl implements CustomerLoginRepository{

    public CustomerLoginDTO getCustomerLoginByName(String loginName){
        Map<String, String> customerCredentials = new HashMap<>();
        customerCredentials.put("robin", "robin123");
        customerCredentials.put("garry", "garry123");
        customerCredentials.put("harry", "harru123");
        customerCredentials.put("monica", "monica123");

        CustomerLoginDTO customerLogin = new CustomerLoginDTO();
        customerLogin.setLoginName(loginName);
        customerLogin.setPassword(customerCredentials.get(loginName));

        return customerLogin;
    }
}
