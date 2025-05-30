package com.tecsup.demo.modelo.documentos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Document(collection = "cursos")
public class Curso {

    @Id
    private String id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Min(value = 1, message = "Los créditos deben ser al menos 1")
    private int creditos;

    public Curso() {}

    public Curso(String id, String nombre, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    // Getters y setters

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCreditos() { return creditos; }

    public void setCreditos(int creditos) { this.creditos = creditos; }

    @Override
    public String toString() {
        return "Curso{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                '}';
    }
}

