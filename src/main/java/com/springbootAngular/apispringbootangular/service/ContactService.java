package com.springbootAngular.apispringbootangular.service;

import com.springbootAngular.apispringbootangular.entity.Contact;
import com.springbootAngular.apispringbootangular.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Contact findById(Integer id){
        return contactRepository.findById(id).orElse(null);
    }


    public Contact create(Contact contact){
        contact.setCreaterAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id,Contact form){
        Contact contactFromBd = findById(id);
        contactFromBd.setNombre(form.getNombre());
        contactFromBd.setEmail(form.getEmail());

        return contactRepository.save(contactFromBd);
    }


    public void delete(Integer id){
        Contact contactFromBd = findById(id);
        contactRepository.delete(contactFromBd);
    }

}
