package com.example.library_management_system.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library_management_system.entity.Address;
import com.example.library_management_system.service.AddressService;
import com.example.library_management_system.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>>saveAddress(@RequestBody Address address){
		return addressService.saveAddress(address);
		
	}
	
	@GetMapping("/{addressId}")
	public ResponseEntity<ResponseStructure<Address>>findAddressById(@PathVariable int addressId){
		return addressService.findAddressById(addressId);
	}
	
	  @PutMapping
	    public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address) {
	        return addressService.updateAddress(address);
	    }

	    @GetMapping
	    public ResponseEntity<ResponseStructure<List<Address>>> findAllAddresses() {
	        return addressService.findAllAddresses();
	    }

	    @DeleteMapping("/{addressId}")
	    public ResponseEntity<ResponseStructure<String>> deleteAddress(@PathVariable int addressId) {
	        return addressService.deleteAddress(addressId);
	    }
}
