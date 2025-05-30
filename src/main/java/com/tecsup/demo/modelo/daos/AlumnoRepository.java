package com.tecsup.demo.modelo.daos;

import com.tecsup.demo.modelo.documentos.Alumno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends MongoRepository<Alumno, String> {
    List<Alumno> findByNombreContainingIgnoreCase(String nombre);
}
