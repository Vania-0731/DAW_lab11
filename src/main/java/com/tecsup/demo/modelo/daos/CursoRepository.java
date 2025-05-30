package com.tecsup.demo.modelo.daos;

import com.tecsup.demo.modelo.documentos.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CursoRepository extends MongoRepository<Curso, String> {
}
