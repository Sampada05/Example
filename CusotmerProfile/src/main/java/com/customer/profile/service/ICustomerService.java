package com.customer.profile.service;

import com.customer.profile.dto.ResponseDto;
import com.customer.profile.exception.RecordNotFound;
import com.customer.profile.model.Customer;

public interface ICustomerService {

	Customer getCustomerProfile(Long id)throws RecordNotFound;


	ResponseDto updateCustomerProfile(Long id)throws RecordNotFound;


	ResponseDto deleteCustomerProfile(Long id);


	ResponseDto createCustomerProfile(Customer customer);

}
