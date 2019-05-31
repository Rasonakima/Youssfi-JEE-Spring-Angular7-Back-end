package com.demo.restbackend.web;

import java.util.List;
import java.util.Optional;

import com.demo.restbackend.dao.ContactRepository;
import com.demo.restbackend.entities.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ContactRestService {

    @Autowired
    ContactRepository contactRepository;

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public Contact save(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.PATCH)
    public Contact save(@PathVariable Long id, @RequestBody Contact contact) {
        contact.setId(id);
        return contactRepository.save(contact);
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Long id) {
        try {
            contactRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public List<Contact> contacts() {
        return contactRepository.findAll();
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
    public Optional<Contact> getContact(@PathVariable Long id) {
        return contactRepository.findById(id);
    }

    @RequestMapping(value = "contacts/findContacts", method = RequestMethod.GET)
    public Page<Contact> findByNom(@RequestParam(name = "mc", defaultValue = "") String mc,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        return contactRepository.findAllByNom("%" + mc + "%", PageRequest.of(page, size));
    }
}