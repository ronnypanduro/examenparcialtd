package com.examenparcial.examenparcial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.examenparcial.examenparcial.model.UsuarioModel;
import com.examenparcial.examenparcial.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/all")
    public List<UsuarioModel> getAll() {
        return usuarioService.findAll();
    }

    @PostMapping("/create")
    public UsuarioModel create(@RequestBody UsuarioModel model) {
        return usuarioService.add(model);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        return usuarioService.delete(id) ? "deleted" : "not deleted";
    }
    @PutMapping("/update/{id}")
    public UsuarioModel update(@RequestBody UsuarioModel model, @PathVariable("id") int id) {
        
        return usuarioService.update(model, id);
    }
    @GetMapping("/{id}")
    public UsuarioModel findById(@PathVariable("id") int id) {
        return usuarioService.findById(id);
    }
}