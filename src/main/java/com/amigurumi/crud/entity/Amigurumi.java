package com.amigurumi.crud.entity;


import jakarta.persistence.*;

@Entity
public class Amigurumi extends BaseEntity {

    private String descripcion;
    private double precio;

    @ManyToOne
    private Categoria categoria;

    public Amigurumi() {}

    public Amigurumi(String descripcion, double precio, Categoria categoria) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    @Override
    public String getInfo() {
        return "ID: " + getId() + " | " + descripcion + " | $" + precio +
               (categoria != null ? " | Cat: " + categoria.getNombre() : "");
    }
}
