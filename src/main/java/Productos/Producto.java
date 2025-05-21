package Productos;


public class Producto extends ProductoAbstracto {

    public Producto() {
        super();
    }

    public Producto(String nombre, String descripcion, Double precio, Integer stock, Integer id) {
        super(nombre, descripcion, precio, stock, id);
    }

    public Producto(String nombre, String descripcion, Double precio, Integer stock) {
        super(nombre, descripcion, precio, stock);
    }

    public Producto(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Producto: " + this.id + " Nombre: " + this.nombre + " Precio: " + this.precio;
    }

}
