package com.tecsup.demo.servicios;

import com.tecsup.demo.modelo.daos.AlumnoRepository;
import com.tecsup.demo.modelo.documentos.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository dao;
    @Override
    @Transactional
    public void grabar(Alumno alumno) {
        dao.save(alumno);  }

    @Override
    @Transactional
    public void eliminar(String id) {
        dao.deleteById(id); }

    @Override
    @Transactional(readOnly = true)
    public Alumno buscar(String id) {
        return dao.findById(id).orElse(null);  }

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> listar() {
        return dao.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public List<Alumno> buscarPorNombre(String nombre) {
        return dao.findByNombreContainingIgnoreCase(nombre);
    }
}
