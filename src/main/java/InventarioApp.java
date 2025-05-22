import Productos.Producto;
import Productos.ProductoAbstracto;
import ProductosDAO.IProductoDao;
import ProductosDAO.ProductoDao;

import java.util.List;
import java.util.Scanner;

public class InventarioApp {
    public static void main(String[] args) {
        appInventario();
    }
    private static void appInventario() {
        Scanner sc = new Scanner(System.in);
        IProductoDao productoDao = new ProductoDao();
        Boolean salir = Boolean.FALSE;
        while (!salir) {
            try{
                Integer opcion = mostrarMenu(sc);
                salir = ejecutarOpciones(sc, opcion,productoDao);
            } catch (Exception e) {
                System.out.println("Error al ejecutar las opciones: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static Boolean ejecutarOpciones(Scanner sc, Integer opcion, IProductoDao productoDao) {
        Boolean salir = Boolean.FALSE;
        switch (opcion) {
            case 1 -> {
                System.out.println("--- Lista de productos ---");
                List<ProductoAbstracto> productos = productoDao.listarProductos();
                productos.forEach(System.out::println);
            }
            case 2 ->{
                System.out.println("--- Agregar producto ---");
                System.out.println("Ingrese el nombre del producto: ");
                String nombre = sc.nextLine();
                System.out.println("Ingrese la descripcion del producto: ");
                String descripcion = sc.nextLine();
                System.out.println("Ingrese el precio del producto: ");
                Double precio = Double.parseDouble(sc.nextLine());
                System.out.println("Ingrese el stock del producto: ");
                Integer stock = Integer.parseInt(sc.nextLine());
                ProductoAbstracto producto = new Producto(nombre, descripcion, precio, stock);
                Boolean agregar = productoDao.agregarProducto(producto);
                if (agregar) {
                    System.out.println("El producto se ha agregado correctamente" + producto);
                }
                else{
                    System.out.println("El producto no se ha agregado correctamente" + producto);
                }
            }
            case 3 -> {
                System.out.println("Ingrese el id del producto: ");
                Integer id = Integer.parseInt(sc.nextLine());
                ProductoAbstracto producto = new Producto(id);
                Boolean encontrado = productoDao.buscarProducto(producto);
                if (encontrado) {
                    System.out.println("\nProducto encontrado: " + producto);
                }
                else {
                    System.out.println("\nProducto no encontrado");
                }
            }
            case 4 -> {
                System.out.println("Ingrese el id del producto: ");
                Integer id = Integer.parseInt(sc.nextLine());
                ProductoAbstracto producto = new Producto(id);
                Boolean modificado = productoDao.modificarPrecio(producto);
                if (modificado) {
                    System.out.println("\nProducto modificado: " + producto);
                }
                else {
                    System.out.println("\nProducto no modificado");
                }
            }
            case 5 -> {
                System.out.println("Ingrese el id del producto: ");
                Integer id = Integer.parseInt(sc.nextLine());
                ProductoAbstracto producto = new Producto(id);
                Boolean modificado = productoDao.modificarStock(producto);
                if (modificado) {
                    System.out.println("\nProducto modificado: " + producto);
                }
                else {
                    System.out.println("\nProducto no modificado");
                }
            }
            case 6 -> {
                System.out.println("Ingrese el id del producto: ");
                Integer id = Integer.parseInt(sc.nextLine());
                ProductoAbstracto producto = new Producto(id);
                Boolean modificado = productoDao.modificarNombre(producto);
                if (modificado) {
                    System.out.println("\nProducto modificado: " + producto);
                }
                else {
                    System.out.println("\nProducto no modificado");
                }
            }
            case 7 -> {
                System.out.println("Ingrese el id del producto: ");
                Integer id = Integer.parseInt(sc.nextLine());
                ProductoAbstracto producto = new Producto(id);
                Boolean modificado = productoDao.modificarDescripcion(producto);
                if (modificado) {
                    System.out.println("\nProducto modificado: " + producto);
                }
                else {
                    System.out.println("\nProducto no modificado");
                }
            }
            case 8 -> {
                System.out.println("Ingrese el id del producto: ");
                Integer id = Integer.parseInt(sc.nextLine());
                ProductoAbstracto producto = new Producto(id);
                Boolean modificado = productoDao.eliminarProducto(producto);
                if (modificado) {
                    System.out.println("\nProducto eliminado: " + producto);
                }
                else {
                    System.out.println("\nProducto no eliminado");
                }
            }
            case 9 -> {
                System.out.println("--- Lista de productos con bajo stock ---");
                List<ProductoAbstracto> productos = productoDao.productosConBajaStock();
                productos.forEach(System.out::println);
            }
            case 10 -> {
                salir = Boolean.TRUE;
            }
            default -> {
                System.out.println("Opcion no valida");
            }
        }
        return salir;
    }

    private static Integer mostrarMenu(Scanner opcionSeleccionada) {
        System.out.print("""
                              *** Inventario ***
                              \n1. Listar productos
                              \n2. Agregar producto
                              \n3. Buscar producto
                              \n4. Modificar Precio
                              \n5. Modificar stock
                              \n6. Modificar nombre
                              \n7. Modificar descripcion
                              \n8. Eliminar producto
                              \n9. Listar productos con bajo stock
                              \n10. Salir
                              \nSeleccione una opcion:
        """);
        return Integer.parseInt(opcionSeleccionada.nextLine());
    }


}
