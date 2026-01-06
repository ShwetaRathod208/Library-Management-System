package com.example.library_management_system.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.library_management_system.dao.AddressDao;
import com.example.library_management_system.dao.LibraryDao;
import com.example.library_management_system.entity.Address;
import com.example.library_management_system.entity.Library;
import com.example.library_management_system.entity.User;
import com.example.library_management_system.util.ResponseStructure;

@Service
public class LibraryService {
    @Autowired
    private LibraryDao libraryDao;
    
    @Autowired
    private AddressDao addressDao;

    public ResponseEntity<ResponseStructure<Library>> saveLibrary(Library library,int addressId) {
        Address findAddressById=addressDao.findAddressById(addressId);
        ResponseStructure<Library> response = new ResponseStructure<>();
        if(findAddressById!=null) {
        
        library.setAddress(findAddressById);
        libraryDao.saveLibrary(library);
        
        response.setData(library);
        response.setMessage("Library Saved");
        response.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<Library>>(response,HttpStatus.OK);
        }
        else {
        	 response.setData(library);
             response.setMessage("Library NOT Saved ADDRESSID NOT FOUND");
             response.setStatusCode(HttpStatus.BAD_REQUEST.value());
             return new ResponseEntity<ResponseStructure<Library>>(response,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseStructure<Library>> findLibraryById(int id) {
        Library library = libraryDao.getLibraryById(id);
        ResponseStructure<Library> response = new ResponseStructure<>();
        if (library != null) {
            response.setMessage("Library Found");
            response.setData(library);
            response.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<Library>>(response,HttpStatus.OK);
        } else {
            response.setMessage("Library Not Found");
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<ResponseStructure<Library>>(response,HttpStatus.BAD_REQUEST);
        }
        
    }

    public ResponseEntity<ResponseStructure<Library>> updateLibrary(Library library) {
        Library updated = libraryDao.updateLibrary(library);
        ResponseStructure<Library> response = new ResponseStructure<>();
        response.setMessage("Library Updated");
        response.setData(updated);
        response.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<Library>>(response,HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<Library>>> findAllLibraries() {
        List<Library> list = libraryDao.findAllLibraries();
        ResponseStructure<List<Library>> response = new ResponseStructure<>();
        response.setMessage("All Libraries Retrieved");
        response.setData(list);
        response.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<List<Library>>>(response,HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deleteLibrary(int id) {
        String result = libraryDao.deleteLibrary(id);
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setMessage("Library Deletion Status");
        response.setData(result);
        response.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.OK);
    }
}
