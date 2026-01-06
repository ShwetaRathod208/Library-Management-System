package com.example.library_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.library_management_system.entity.Address;
import com.example.library_management_system.repository.AddressRepository;

@Repository
public class AddressDao {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public Address saveAddress(Address address) {
		addressRepository.save(address);
		return address;
	}
	
	public Address updateAddress(Address address) {
		addressRepository.save(address);
		return address;
	}
	
	public Address findAddressById(int  addressId) {
		Optional<Address>optional=addressRepository.findById(addressId);
		if(optional.isPresent())
			return optional.get();
		return null;
	}
	
	public List<Address>findAllAddress(){
		return addressRepository.findAll();
	}
	
	public String deleteAddress(int addressId) {
		addressRepository.deleteById(addressId);
		return "Address deleted";
	}
	
	
}
