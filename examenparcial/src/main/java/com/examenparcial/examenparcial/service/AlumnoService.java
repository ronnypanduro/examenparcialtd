package com.examenparcial.examenparcial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenparcial.examenparcial.model.AlumnoModel;
import com.examenparcial.examenparcial.repository.IAlumnoRepository;





@Service
public class AlumnoService implements IAlumnoService {

    @Autowired
    IAlumnoRepository repository;
    @Override
    public List<AlumnoModel> getAlumnos() { 
        return (List<AlumnoModel>) repository.findAll();
    } 

    @Override
    public AlumnoModel getAlumnoId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AlumnoModel guardarAlumno(AlumnoModel alumno) {
        return repository.save(alumno);
    }

    @Override
    public AlumnoModel actualizarAlumno(AlumnoModel alumno) {
        return repository.save(alumno);
    }

    @Override
    public boolean eliminarAlumno(int id) {
            if(repository.existsById(id)){
            repository.deleteById(id);
                
                return true;
            }
            return false;
    }

}