package com.demo.restbackend.dao;

import com.demo.restbackend.entities.Contact;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query("select c from Contact c where c.nom like:x")
    public Page<Contact> findAllByNom(@Param("x")String nom, Pageable pageable);
}