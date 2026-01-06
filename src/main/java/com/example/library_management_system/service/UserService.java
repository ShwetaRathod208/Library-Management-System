package com.example.library_management_system.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.library_management_system.dao.AddressDao;
import com.example.library_management_system.dao.UserDao;
import com.example.library_management_system.entity.Address;
import com.example.library_management_system.entity.User;
import com.example.library_management_system.util.ResponseStructure;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private AddressDao addressDao;

    public ResponseEntity<ResponseStructure<User>> saveUser(User user,int addressId) {
        Address findAddressById=addressDao.findAddressById(addressId);
        ResponseStructure<User> response = new ResponseStructure<>();
        if(findAddressById!=null) {
        
        user.setAddress(findAddressById);
        userDao.saveUser(user);
        
        response.setData(user);
        response.setMessage("User Saved");
        response.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<User>>(response,HttpStatus.OK);
        }
        else {
        	 response.setData(user);
             response.setMessage("User NOT Saved ADDRESSID NOT FOUND");
             response.setStatusCode(HttpStatus.BAD_REQUEST.value());
             return new ResponseEntity<ResponseStructure<User>>(response,HttpStatus.BAD_REQUEST);
        }
    }

    
    public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
        User user = userDao.getUserById(id);
        ResponseStructure<User> response = new ResponseStructure<>();
        if (user != null) {
            response.setMessage("User Found");
            response.setData(user);
            response.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<User>>(response,HttpStatus.OK);
        } else {
            response.setMessage("User Not Found");
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<ResponseStructure<User>>(response,HttpStatus.BAD_REQUEST);
        }
        
    }

    public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
        User updated = userDao.updateUser(user);
        ResponseStructure<User> response = new ResponseStructure<>();
        response.setMessage("User Updated");
        response.setData(updated);
        response.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<User>>(response,HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<User>>> findAllUsers() {
        List<User> list = userDao.findAllUsers();
        ResponseStructure<List<User>> response = new ResponseStructure<>();
        response.setMessage("All Users Retrieved");
        response.setData(list);
        response.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<List<User>>>(response,HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
        String result = userDao.deleteUser(id);
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setMessage("User Deletion Status");
        response.setData(result);
        response.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.OK);
    }
}

