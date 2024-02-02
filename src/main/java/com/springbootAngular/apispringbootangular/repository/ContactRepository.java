package com.springbootAngular.apispringbootangular.repository;

import com.springbootAngular.apispringbootangular.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,Integer> {


}
