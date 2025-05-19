package Productos;

public class ArtLimpieza extends Producto{

    public ArtLimpieza(String nombre, String descripcion, Double precio, Integer id, Integer stock) {
        super(nombre, descripcion, precio, id, stock);
    }

    @Override
    protected String tipoProducto() {
        return "de Limpieza";
    }

    @Override
    protected String mostrarProducto() {
        return "";
    }
}
