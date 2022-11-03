package com.infy.respository;

import com.infy.dto.CustomerLoginDTO;

public interface CustomerLoginRepository {
    public CustomerLoginDTO getCustomerLoginByName(String loginName);
}
