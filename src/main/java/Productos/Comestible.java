package Productos;

import java.util.Date;

public class Comestible extends Producto {
    private Date fechaIngreso;
    private Date fechaVencimiento;

    public Comestible(String nombre, String descripcion, Double precio, Integer id, Integer stock, Date fechaIngreso, Date fechaVencimiento) {
        super(nombre, descripcion, precio, id, stock);
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    protected String tipoProducto() {
        return "Comestible";
    }

    @Override
    protected String mostrarProducto() {
        return " | Fecha de elaboracion: " + String.valueOf(this.fechaIngreso) + " | Fecha de vencimiento: " + String.valueOf(this.fechaVencimiento);
    }
}
