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

import com.example.library_management_system.entity.Library;
import com.example.library_management_system.service.LibraryService;
import com.example.library_management_system.util.ResponseStructure;


@RestController
@RequestMapping("/library")
class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/{addressId}")
    public ResponseEntity<ResponseStructure<Library>> saveLibrary(@RequestBody Library library,@PathVariable int addressId) {
        return libraryService.saveLibrary(library,addressId);
    }

    @GetMapping("/{libraryId}")
    public ResponseEntity<ResponseStructure<Library>> findLibraryById(@PathVariable int libraryId) {
        return libraryService.findLibraryById(libraryId);
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<Library>> updateLibrary(@RequestBody Library library) {
        return libraryService.updateLibrary(library);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Library>>> findAllLibraries() {
        return libraryService.findAllLibraries();
    }

    @DeleteMapping("/{libraryId}")
    public ResponseEntity<ResponseStructure<String>> deleteLibrary(@PathVariable int libraryId) {
        return libraryService.deleteLibrary(libraryId);
    }
}
