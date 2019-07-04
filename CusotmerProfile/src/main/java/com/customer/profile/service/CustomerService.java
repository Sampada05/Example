package com.customer.profile.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.profile.dto.ResponseDto;
import com.customer.profile.exception.RecordNotFound;
import com.customer.profile.model.Customer;
import com.customer.profile.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService	{

	@Autowired
	private ICustomerRepository customerRepository;
	@Override
	public Customer getCustomerProfile(Long id) throws RecordNotFound {
		Optional<Customer> customer=customerRepository.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}
		else {
			throw new RecordNotFound("customer with id "+id+" is not found");
		}
				
	}
	@Override
	public ResponseDto updateCustomerProfile(Long id) throws RecordNotFound {
		ResponseDto rs=new ResponseDto();
		Optional<Customer> customer=customerRepository.findById(id);
		if(customer.isPresent()) {
			customer.get().setName("abc");
			rs.setMessage("Customer updated successfully");
		}
		else {
			throw new RecordNotFound("customer with id "+id+" is not found");
		}
			
		return rs;
	}
	@Override
	public ResponseDto deleteCustomerProfile(Long id) {
		ResponseDto rs=new ResponseDto();
		customerRepository.deleteById(id);
		rs.setMessage("Customer deleted successfully");
		return rs;
	}
	@Override
	public ResponseDto createCustomerProfile(Customer customer) {
		ResponseDto rs=new ResponseDto();
		customerRepository.save(customer);
		rs.setMessage("Customer created successfully");
		return rs;

	}
	
}
