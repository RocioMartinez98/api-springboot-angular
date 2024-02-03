package com.springbootAngular.apispringbootangular.service;

import com.springbootAngular.apispringbootangular.dto.ContactDTO;
import com.springbootAngular.apispringbootangular.entity.Contact;
import com.springbootAngular.apispringbootangular.exception.ResourceNotFoundException;
import com.springbootAngular.apispringbootangular.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper mapper;

    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Contact findById(Integer id){
        return contactRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }


    public Contact create(ContactDTO contactDTO){
        Contact contact = mapper.map(contactDTO, Contact.class);

        contact.setCreaterAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id,ContactDTO contactDTO){
        Contact contactFromBd = findById(id);
        mapper.map(contactDTO, contactFromBd);
        return contactRepository.save(contactFromBd);
    }


    public void delete(Integer id){
        Contact contactFromBd = findById(id);
        contactRepository.delete(contactFromBd);
    }

}
