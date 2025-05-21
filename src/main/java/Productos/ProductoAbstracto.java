package Productos;

import java.sql.Date;
import java.util.Objects;

public abstract class ProductoAbstracto {
    protected String nombre;
    protected String descripcion;
    protected Double precio;
    protected Integer id;
    protected Integer stock;

    public ProductoAbstracto(String nombre, String descripcion, Double precio, Integer id, Integer stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.id = id;
        this.stock = stock;
    }

    public ProductoAbstracto(String nombre, String descripcion, Double precio , Integer stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public ProductoAbstracto() {}



    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductoAbstracto productoAbstracto = (ProductoAbstracto) o;
        return Objects.equals(nombre, productoAbstracto.nombre) && Objects.equals(descripcion, productoAbstracto.descripcion) && Objects.equals(precio, productoAbstracto.precio) && Objects.equals(id, productoAbstracto.id) && Objects.equals(stock, productoAbstracto.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, descripcion, precio, id, stock);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public Integer getStock() {
        return this.stock;
    }
}
