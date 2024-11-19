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

import com.examenparcial.examenparcial.model.AlumnoModel;
import com.examenparcial.examenparcial.service.AlumnoService;


@RestController
@RequestMapping(RutaApi.RUTABASE)
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @GetMapping(RutaApi.RUTA_GETALUMNOS)
    public List<AlumnoModel> getAll() {
        return alumnoService.getAlumnos();
    }

    @PostMapping(RutaApi.RUTA_POSTALUMNO)
    public AlumnoModel create(@RequestBody AlumnoModel model) {
        return alumnoService.guardarAlumno(model);
    }
    @DeleteMapping(RutaApi.RUTA_DELETEALUMNO)
    public String delete(@PathVariable("id") int id) {
        return alumnoService.eliminarAlumno(id) ? "deleted" : "not exste id";
    }
    @PutMapping(RutaApi.RUTA_PUTALUMNO)
    public AlumnoModel update(@RequestBody AlumnoModel model, @PathVariable("id") int id) {
        AlumnoModel alumno = new AlumnoModel(); 
        alumno.setId(id); alumno.setNombre(model.getNombre()); alumno.setNota(model.getNota());
        return alumnoService.actualizarAlumno(alumno);
    }
    @GetMapping(RutaApi.RUTA_GETALUMNO)
    public AlumnoModel findById(@PathVariable("id") int id) {
        
        return alumnoService.getAlumnoId(id);

        
    }
}