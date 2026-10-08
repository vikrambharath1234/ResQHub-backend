package com.resqhub.backend.controller;

import com.resqhub.backend.dto.ContactRequestDto;
import com.resqhub.backend.entity.Contact;
import com.resqhub.backend.service.ContactService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {

        this.contactService = contactService;
    }


    // ADD CONTACT
    @PostMapping
    public Contact addContact(
            @RequestBody ContactRequestDto request) {

        return contactService.addContact(request);
    }


    // GET CONTACTS OF A USER
    @GetMapping("/user/{userId}")
    public List<Contact> getContacts(
            @PathVariable Long userId) {

        return contactService
                .getContactsByUserId(userId);
    }


    // DELETE CONTACT
    @DeleteMapping("/{id}")
    public String deleteContact(
            @PathVariable Long id) {

        contactService.deleteContact(id);

        return "Contact deleted successfully";
    }
}