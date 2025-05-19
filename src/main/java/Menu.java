import Productos.ArtLimpieza;
import Productos.Comestible;
import Productos.Producto;

import javax.lang.model.type.NullType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String nombre;
    private List<Producto> productos;
    Scanner teclado = new Scanner(System.in);

    public Menu(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public void mostrarMenu() {
        System.out.println("Menu: " + nombre);
        System.out.println("Elija una opcion:");
        System.out.println("1. Ingresar productos");
        System.out.println("2. Listar productos");
        System.out.println("3. Actualizar stock");
        System.out.println("4. Eliminar stock");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Buscar producto");
        System.out.println("7. Productos con bajo stock");
        System.out.println("8. Salir");

        int opcion = teclado.nextInt();
        teclado.nextLine();
        if (opcion == 1) {
            this.IngresarProducto();
        } else if (opcion == 2) {
            this.mostrarProductos();
        }
    }

    private void IngresarProducto() {
        
        System.out.println("Ingrese el nombre: ");
        String nombre = teclado.nextLine();

        System.out.println("Ingrese el descripcion: ");
        String descripcion = teclado.nextLine();

        System.out.println("Ingrese el costo: ");
        Double costo = teclado.nextDouble();
        teclado.nextLine();
        
        System.out.println("Ingrese el stock: ");
        Integer stock = teclado.nextInt();
        teclado.nextLine();

        Integer id = this.productos.size() + 1;
        
        System.out.println("Ingrese el tipo de producto: ");
        System.out.println("1. Producto comestible");
        System.out.println("2. Producto de limpieza");
        int tipoProducto = teclado.nextInt();
        teclado.nextLine();

        if (tipoProducto == 1) {
            this.ingresarProductoComestible(nombre, descripcion, costo, id, stock);
        } else {
            this.ingresarProductoLimpieza(nombre, descripcion, costo, id, stock);
        }
        this.mostrarMenu();
    }

    private void ingresarProductoLimpieza(String nombre, String descripcion, Double costo, Integer id, Integer stock) {
        Producto limpieza = new ArtLimpieza(nombre, descripcion, costo, id, stock);
        productos.add(limpieza);
    }

    private void ingresarProductoComestible(String nombre, String descripcion, Double costo, Integer id, Integer stock) {
        System.out.println("Ingrese la fecha de creacion: ");
        String fechaIng = teclado.nextLine().trim();
        Date fechaCreado = this.crearFecha(fechaIng);

        System.out.println("Ingrese la fecha de vencimiento: ");
        String fechaSalida = teclado.nextLine().trim();
        Date fechaVenc = this.crearFecha(fechaSalida);

        Producto comestible = new Comestible(nombre, descripcion, costo, id, stock, fechaCreado, fechaVenc);
        productos.add(comestible);
    }

    private Date crearFecha(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaCreada = null;
        try {
            fechaCreada = sdf.parse(fecha);
        } catch (ParseException e) {
            System.out.println("Fecha incorrecta");
            this.crearFecha(fecha);
        }
        return fechaCreada;
    }


    public void mostrarProductos() {
        System.out.println(nombre);
        if (productos == null) {
            throw  new RuntimeException("No hay productos cargados en el inventario");
        }
        else {
            productos.forEach(producto -> producto.Mostrar());
        }
        this.mostrarMenu();
    }
}
