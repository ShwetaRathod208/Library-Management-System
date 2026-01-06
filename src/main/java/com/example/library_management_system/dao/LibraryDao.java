package com.example.library_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.library_management_system.entity.Address;
import com.example.library_management_system.entity.Library;
import com.example.library_management_system.repository.LibraryRepository;

@Repository
public class LibraryDao {
    @Autowired
    private LibraryRepository libraryRepository;

    public Library saveLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public Library updateLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public Library getLibraryById(int libraryId) {
    	Optional<Library>optional=libraryRepository.findById(libraryId);
		if(optional.isPresent())
			return optional.get();
		return null;
    }

    public List<Library> findAllLibraries() {
        return libraryRepository.findAll();
    }

    public String deleteLibrary(int libraryId) {
        libraryRepository.deleteById(libraryId);
        return "Library deleted";
    }
}
