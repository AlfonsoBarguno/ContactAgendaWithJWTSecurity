package com.project.SecurityJWT.controller;

import com.project.SecurityJWT.entity.Contacto;
import com.project.SecurityJWT.repository.ContactoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contactos")
public class ContactoController {

    private final ContactoRepositorio contactoRepositorio;

    @GetMapping
    public List<Contacto> getContactos(){

        return contactoRepositorio.findAll();

    }


}
