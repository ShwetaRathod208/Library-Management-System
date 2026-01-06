package com.example.library_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.library_management_system.entity.Address;
import com.example.library_management_system.entity.User;
import com.example.library_management_system.repository.UserRepository;

@Repository
public class UserDao {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(int userId) {
    	Optional<User>optional=userRepository.findById(userId);
		if(optional.isPresent())
			return optional.get();
		return null;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public String deleteUser(int userId) {
        userRepository.deleteById(userId);
        return "User deleted";
    }
}