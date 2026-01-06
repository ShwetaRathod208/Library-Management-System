package com.example.library_management_system.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.library_management_system.dao.AddressDao;
import com.example.library_management_system.entity.Address;
import com.example.library_management_system.util.ResponseStructure;

@Service
public class AddressService {
 @Autowired
 private AddressDao addressDao;
 
 public ResponseEntity<ResponseStructure<Address>>saveAddress(Address address){
	 
     Address saveAddress=addressDao.saveAddress(address);
	 
	 ResponseStructure<Address>responseStructure=new ResponseStructure<>();
	 responseStructure.setMessage("Address Saved");
	 responseStructure.setData(saveAddress);
	 responseStructure.setStatusCode(HttpStatus.OK.value());
	 return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
 }
 
 public ResponseEntity<ResponseStructure<Address>>findAddressById(int addressId){
	 Address findAddressById=addressDao.findAddressById(addressId);
	 ResponseStructure<Address>responseStructure=new ResponseStructure<>();
	 if(findAddressById!=null) {
		 responseStructure.setData(findAddressById);
		 responseStructure.setMessage("AddressFound");
		 responseStructure.setStatusCode(HttpStatus.OK.value());
		 return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
	 }
	 else {
		 responseStructure.setMessage("Address id Not Found");
		 responseStructure.setData(null);
		 responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		 return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.BAD_REQUEST);
	 }
	 
 }
 
 
 public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address) {
     Address updated = addressDao.updateAddress(address);

     ResponseStructure<Address> response = new ResponseStructure<>();
     response.setMessage("Address Updated");
     response.setData(updated);
     response.setStatusCode(HttpStatus.OK.value());

     return new ResponseEntity<ResponseStructure<Address>>(response,HttpStatus.OK);
 }

 public ResponseEntity<ResponseStructure<List<Address>>> findAllAddresses() {
     List<Address> list = addressDao.findAllAddress();

     ResponseStructure<List<Address>> response = new ResponseStructure<>();
     response.setMessage("All Addresses Retrieved");
     response.setData(list);
     response.setStatusCode(HttpStatus.OK.value());

     return new ResponseEntity<ResponseStructure<List<Address>>>(response,HttpStatus.OK);
 }

 public ResponseEntity<ResponseStructure<String>> deleteAddress(int addressId) {
     String result = addressDao.deleteAddress(addressId);

     ResponseStructure<String> response = new ResponseStructure<>();
     response.setMessage("Address Deletion Status");
     response.setData(result);
     response.setStatusCode(HttpStatus.OK.value());

     return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.OK);
 }
 
}
