package Productos;

import java.util.Objects;

public abstract class Producto {
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer id;
    private Integer stock;

    public Producto(String nombre, String descripcion, Double precio, Integer id, Integer stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.id = id;
        this.stock = stock;
    }

    public void Mostrar() {
        System.out.println("    Producto " + this.tipoProducto() + " ID: " + id + " | Nombre: " + nombre + " | Descripcion: " + descripcion +
                " | Precio: " + precio + " | Stock: " + stock +
                this.mostrarProducto());
    }

    protected abstract String tipoProducto();

    protected abstract String mostrarProducto();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre) && Objects.equals(descripcion, producto.descripcion) && Objects.equals(precio, producto.precio) && Objects.equals(id, producto.id) && Objects.equals(stock, producto.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, descripcion, precio, id, stock);
    }
}
