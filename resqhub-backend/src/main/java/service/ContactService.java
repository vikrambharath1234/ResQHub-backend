package com.resqhub.backend.service;

import com.resqhub.backend.dto.ContactRequestDto;
import com.resqhub.backend.entity.Contact;
import com.resqhub.backend.repository.ContactRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {

        this.contactRepository = contactRepository;
    }


    // ADD CONTACT
    public Contact addContact(ContactRequestDto request) {

        Contact contact = new Contact();

        contact.setUserId(request.getUserId());

        contact.setName(request.getName());

        contact.setPhone(request.getPhone());

        return contactRepository.save(contact);
    }


    // GET USER CONTACTS
    public List<Contact> getContactsByUserId(Long userId) {

        return contactRepository.findByUserId(userId);
    }


    // DELETE CONTACT
    public void deleteContact(Long id) {

        contactRepository.deleteById(id);
    }
}