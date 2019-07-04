package com.customer.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.profile.dto.ResponseDto;
import com.customer.profile.exception.RecordNotFound;
import com.customer.profile.model.Customer;
import com.customer.profile.service.ICustomerService;

@RestController
@RequestMapping("/customer-info")
public class CustomerProfileController {
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/profile/id")
	public ResponseEntity<Customer> getCustomerProfile(@PathVariable Long id) throws RecordNotFound{
		return new ResponseEntity<>(customerService.getCustomerProfile(id),HttpStatus.OK);
	}
	
	@PutMapping("/profile/id")
	public ResponseEntity<ResponseDto> updateCustomerProfile(@PathVariable Long id) throws RecordNotFound{
		return new ResponseEntity<>(customerService.updateCustomerProfile(id),HttpStatus.OK);
	}
	@PutMapping("/profile/id")
	public ResponseEntity<ResponseDto> deleteCustomerProfile(@PathVariable Long id) {
		return new ResponseEntity<>(customerService.deleteCustomerProfile(id),HttpStatus.OK);
	}
	@PostMapping("/profile")
	public ResponseEntity<ResponseDto> createCustomerProfile(@RequestBody Customer customer) throws RecordNotFound{
		return new ResponseEntity<>(customerService.createCustomerProfile(customer),HttpStatus.OK);
	}

}
