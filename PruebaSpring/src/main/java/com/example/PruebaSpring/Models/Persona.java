package com.example.PruebaSpring.Models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private int idPersona;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "ApPaterno")
    private String apPaterno;
    @Column(name = "ApMaterno")
    private String apMaterno;
    @Column(name = "FechaNac")
    private Date fechaNac;

    public Persona() {
    }

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(String nombre, String apPaterno, String apMaterno, Date fechaNac) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.fechaNac = fechaNac;
    }

    public Persona(int idPersona, String nombre, String apPaterno, String apMaterno, Date fechaNac) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.fechaNac = fechaNac;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", apPaterno='" + apPaterno + '\'' +
                ", apMaterno='" + apMaterno + '\'' +
                ", fechaNac=" + fechaNac +
                '}';
    }
}