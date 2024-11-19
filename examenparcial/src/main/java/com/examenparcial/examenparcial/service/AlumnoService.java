package com.examenparcial.examenparcial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenparcial.examenparcial.exception.CustomException;
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
        return repository.findById(id)
                         .orElseThrow( () -> new CustomException("Alumno no encontrado con ID: " + id));
    }

    // Guardar un nuevo alumno
    @Override
    public AlumnoModel guardarAlumno(AlumnoModel alumno) {
        // Verificar si el nombre o la nota son inválidos
        if (alumno.getNombre() == null || alumno.getNota() == null) {
            throw new IllegalArgumentException("El nombre o la nota del alumno no pueden ser nulos.");
        }
        return repository.save(alumno);
    }

    // Actualizar un alumno existente
    @Override
    public AlumnoModel actualizarAlumno(AlumnoModel alumno) {
        if (!repository.existsById(alumno.getId())) {
            throw new CustomException("Alumno no encontrado con ID: " + alumno.getId());
        }
        return repository.save(alumno);
    }

    // Eliminar un alumno
    @Override
    public boolean eliminarAlumno(int id) {
        if (!repository.existsById(id)) {
            throw new CustomException("Alumno no encontrado con ID: " + id);
        }
        repository.deleteById(id);
        return true;
    }

}