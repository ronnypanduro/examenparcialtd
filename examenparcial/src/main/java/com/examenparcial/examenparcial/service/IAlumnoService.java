package com.examenparcial.examenparcial.service;

import java.util.List;

import com.examenparcial.examenparcial.model.AlumnoModel;

public interface IAlumnoService {

        List<AlumnoModel> getAlumnos();
        
        AlumnoModel getAlumnoId(int id);
        AlumnoModel guardarAlumno(AlumnoModel alumno);
        AlumnoModel actualizarAlumno(AlumnoModel alumno);
        boolean eliminarAlumno(int id);
}
