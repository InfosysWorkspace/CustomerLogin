package com.infy.service;

import com.infy.dto.CustomerLoginDTO;
import com.infy.exception.InfyBankException;
import com.infy.repository.CustomerLoginRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "customerLoginService")
public class CustomerLoginServiceImpl implements CustomerLoginService{

    @Autowired
    private CustomerLoginRepository customerLoginRepository;

    public String authenticateCustomer(CustomerLoginDTO customerLogin) throws InfyBankException {
        try {
            String toReturn = null;
            CustomerLoginDTO customerLoginFromDao = customerLoginRepository.
                    getCustomerLoginByName(customerLogin.getLoginName());
            if (customerLogin.getPassword().equals(customerLoginFromDao.getPassword())) {
                toReturn = "SUCCESS";
            } else {
                throw new InfyBankException("Service.WRONG_CREDENTIALS");
            }

            return toReturn;
        } catch (InfyBankException exception){
            Log LOGGER = LogFactory.getLog(this.getClass());
            LOGGER.error(exception.getMessage(), exception);
            throw exception;
        }
    }
}
