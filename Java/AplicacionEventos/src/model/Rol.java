package model;

import java.sql.Timestamp;
import java.util.*;

public class Rol {
    private int id;
    private String nombre;
    private Timestamp fecha_creacion;
    private Timestamp fecha_modificacion;

    public Rol( int id, String nombre, Timestamp fecha_creacion, Timestamp fecha_modificacion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }

    public Rol(String nombre, Timestamp fecha_creacion, Timestamp fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
        this.fecha_creacion = fecha_creacion;
        this.nombre = nombre;
    }

    public Rol() {
    }

    public Timestamp getFecha_modificacion() {return fecha_modificacion;}
    public void setFecha_modificacion(Timestamp fecha_modificacion) {this.fecha_modificacion = fecha_modificacion;}

    public Timestamp getFecha_creacion() {return fecha_creacion;}
    public void setFecha_creacion(Timestamp fecha_creacion) {this.fecha_creacion = fecha_creacion;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}
