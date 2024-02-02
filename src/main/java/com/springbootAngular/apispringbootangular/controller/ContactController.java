package com.springbootAngular.apispringbootangular.controller;


import com.springbootAngular.apispringbootangular.entity.Contact;
import com.springbootAngular.apispringbootangular.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin //acceder a los recursos de un servidor diferente al del servidor actual
@AllArgsConstructor
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public Iterable<Contact> list(){
        return contactService.findAll();
    }

    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id){
        return contactService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED) //Estado de respuesta
    @PostMapping
    public Contact create(@RequestBody Contact contact){
        contact.setCreaterAt(LocalDateTime.now());
        return contactService.create(contact);
    }

    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id, @RequestBody Contact form){

        return contactService.update(id, form);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) //Estado de respuesta
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
       contactService.delete(id);
    }
}
