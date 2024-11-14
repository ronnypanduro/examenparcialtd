package com.examenparcial.examenparcial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/all")
    public List<UsuarioModel> getAll() {
        return usuarioService.findAll();

}

@PostMapping("/create")
public UsuarioModel create(UsuarioModel usuario) {
