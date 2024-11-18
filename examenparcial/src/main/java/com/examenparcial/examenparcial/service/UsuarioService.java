package com.examenparcial.examenparcial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenparcial.examenparcial.model.UsuarioModel;
import com.examenparcial.examenparcial.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    IUsuarioRepository repository;

    @Override
    public UsuarioModel add(UsuarioModel model) {
        return repository.save(model);
    }

    @Override
    public UsuarioModel update(UsuarioModel model, int id) {
        UsuarioModel usuarioExistente = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioExistente.setNombres(model.getNombres());
        usuarioExistente.setApellidos(model.getApellidos());
        return repository.save(usuarioExistente);
    }

    @Override
    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<UsuarioModel> findAll() {
        return (List<UsuarioModel>) repository.findAll();
    }

    @Override
    public UsuarioModel findById(int id) {
        UsuarioModel model = repository.findById(id).orElse(null);
        return model;
    }
    
}

}
