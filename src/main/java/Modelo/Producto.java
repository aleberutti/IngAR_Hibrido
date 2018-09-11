/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author ale_b
 */
public class Producto {
    public Brand marca;
    public String id;
    public String nombre;
    public String clase;
    public String descripcion;
    public String modelo;
    public ArrayList<String> categorias;


    public Producto(Brand m, String id, String name, String c, String d, String model, String categoria1){
        this.marca=m;
        this.id=id;
        this.nombre=name;
        this.clase=c;
        this.descripcion=d;
        this.modelo=model;
        this.categorias= new ArrayList();
        this.categorias.add(categoria1);
    }
    public Producto(Brand m, String id, String name, String c, String d, String model, String categoria1, String categoria2){
        this.marca=m;
        this.id=id;
        this.nombre=name;
        this.clase=c;
        this.descripcion=d;
        this.modelo=model;
        this.categorias= new ArrayList();
        this.categorias.add(categoria1);
        this.categorias.add(categoria2);
    }
    public Producto(Brand m, String id, String name, String c, String d, String model, String categoria1, String categoria2, String categoria3){
        this.marca=m;
        this.id=id;
        this.nombre=name;
        this.clase=c;
        this.descripcion=d;
        this.modelo=model;
        this.categorias= new ArrayList();
        this.categorias.add(categoria1);
        this.categorias.add(categoria2);
        this.categorias.add(categoria3);
    }

    public Brand getMarca() {
        return marca;
    }

    public void setMarca(Brand marca) {
        this.marca = marca;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<String> categorias) {
        this.categorias = categorias;
    }
}