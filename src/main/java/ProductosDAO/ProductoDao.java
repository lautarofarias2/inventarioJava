package ProductosDAO;

import Productos.Producto;
import Productos.ProductoAbstracto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Conexion.Conexion.getConnection;

public class ProductoDao implements IProductoDao {
    Scanner sc = new Scanner(System.in);

    @Override
    public List<ProductoAbstracto> listarProductos() {
        List<ProductoAbstracto> listaProducto = new ArrayList<ProductoAbstracto>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "SELECT * FROM producto ORDER BY id";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ProductoAbstracto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                listaProducto.add(producto);
            }
        }catch (Exception e){
            System.out.println("Error al listar productos" + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion" + e.getMessage());
            }
        }
        return listaProducto;
    }

    @Override
    public Boolean agregarProducto(ProductoAbstracto producto) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "INSERT INTO producto(nombre,descripcion,precio,stock) VALUES(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.execute();
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println("El producto no pudo ser agregado" + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion" + e.getMessage());
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean eliminarProducto(ProductoAbstracto productoAbstracto) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "DELETE FROM producto WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, productoAbstracto.getId());
            ps.execute();
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el producto" + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion" + e.getMessage());
            }
        }
    return Boolean.FALSE;
    }

    @Override
    public Boolean modificarStock(ProductoAbstracto producto) {
        System.out.println("Ingrese el stock: ");
        Integer stockNuevo = Integer.parseInt(sc.nextLine());
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "UPDATE producto SET stock = ? WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, stockNuevo);
            ps.setInt(2, producto.getId());
            ps.execute();
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println("No se pudo modificar el stock" + e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion" + e.getMessage());
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean modificarPrecio(ProductoAbstracto producto){
        System.out.println("Ingrese el precio en decimal: ");
        String input = sc.nextLine();
        Double precioNuevo = Double.parseDouble(input);
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "UPDATE producto SET precio = ? WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setDouble(1, precioNuevo);
            ps.setInt(2, producto.getId());
            ps.execute();
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println("No se pudo modificar el precio" + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion" + e.getMessage());
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean modificarNombre(ProductoAbstracto producto) {
        System.out.println("Ingrese el nombre: ");
        String nombreNuevo = sc.nextLine();
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "UPDATE producto SET nombre = ? WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreNuevo);
            ps.setInt(2, producto.getId());
            ps.execute();
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println("No se pudo modificar el nombre" + e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion" + e.getMessage());
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean modificarDescripcion(ProductoAbstracto producto) {
        System.out.println("Ingrese el descripcion: ");
        String descripcionNuevo = sc.nextLine();
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "UPDATE producto SET descripcion = ? WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, descripcionNuevo);
            ps.setInt(2, producto.getId());
            ps.execute();
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println("No se pudo modificar la descripcion" + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Erro al cerrar la conexion" + e.getMessage());
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean buscarProducto(ProductoAbstracto producto) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "SELECT * FROM producto WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getId());
            rs = ps.executeQuery();
            if (rs.next()){
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                return Boolean.TRUE;
            }
        } catch (Exception e) {
            System.out.println("Producto no encontrado" + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion" + e.getMessage());
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public List<ProductoAbstracto> productosConBajaStock() {
        List<ProductoAbstracto> listaProducto = new ArrayList<ProductoAbstracto>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "SELECT * FROM producto WHERE stock <= 0 ORDER BY id";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ProductoAbstracto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                listaProducto.add(producto);
            }
        }catch (Exception e){
            System.out.println("Error al listar productos" + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion" + e.getMessage());
            }
        }
        return listaProducto;
    }

    public static void main(String[] args){
        IProductoDao productoDao = new ProductoDao();

//        System.out.println("Lista de productos");
//        List<ProductoAbstracto> listaProductos = productoDao.listarProductos();
//        listaProductos.forEach(System.out::println);

//        Buscar producto
//        ProductoAbstracto producto = new Producto(2);
//        System.out.println("Producto: " + producto);;
//        Boolean encontrado = productoDao.buscarProducto(producto);
//        if(encontrado){
//            System.out.println("Producto: " + producto);
//        }
//        else{
//            System.out.println("Producto no encontrado " + producto);
//        }
//        Agregar Producto

//        ProductoAbstracto producto = new Producto("mouse", "hardware para pc", 5000.0, 12);
//        System.out.println("Agregar Producto");
//        Boolean encontrado = productoDao.agregarProducto(producto);
//        if(encontrado){
//            System.out.println("El producto se ha agregado correctamente" + producto);
//        }
//        else{
//            System.out.println("El producto no se ha agregado correctamente" + producto);
//        }

        // Modificar stock
//        ProductoAbstracto producto = new Producto(2);
//        System.out.println("Producto: " + producto);
//        Boolean encontrado = productoDao.buscarProducto(producto);
//        System.out.println("Producto encontrado: " + encontrado);
//        encontrado = productoDao.modificarStock(producto);
//        List<ProductoAbstracto> listaProductos = productoDao.listarProductos();
//        listaProductos.forEach(System.out::println);

        //Modifica precio
//        ProductoAbstracto producto = new Producto(2);
//        System.out.println("Producto: " + producto);
//        Boolean encontrado = productoDao.buscarProducto(producto);
//        System.out.println("Producto encontrado: " + encontrado);
//        encontrado = productoDao.modificarPrecio(producto);
//        List<ProductoAbstracto> listaProductos = productoDao.listarProductos();
//        listaProductos.forEach(System.out::println);

        //Modificar nombre
//        ProductoAbstracto producto = new Producto(2);
//        System.out.println("Producto: " + producto);
//        Boolean encontrado = productoDao.buscarProducto(producto);
//        System.out.println("Producto encontrado: " + encontrado);
//        encontrado = productoDao.modificarNombre(producto);
//        List<ProductoAbstracto> listaProductos = productoDao.listarProductos();
//        listaProductos.forEach(System.out::println);

        //Modificar descripcion
//        ProductoAbstracto producto = new Producto(2);
//        System.out.println("Producto: " + producto);
//        Boolean encontrado = productoDao.buscarProducto(producto);
//        System.out.println("Producto encontrado: " + encontrado);
//        encontrado = productoDao.modificarDescripcion(producto);
//        List<ProductoAbstracto> listaProductos = productoDao.listarProductos();
//        listaProductos.forEach(System.out::println);

        //Eliminar producto
//        ProductoAbstracto producto = new Producto(2);
//        System.out.println("Producto: " + producto);
//        Boolean encontrado = productoDao.buscarProducto(producto);
//        System.out.println("Producto encontrado: " + encontrado);
//        encontrado = productoDao.eliminarProducto(producto);
//        List<ProductoAbstracto> listaProductos = productoDao.listarProductos();
//        listaProductos.forEach(System.out::println);

        // Lista de producto con bajo stock
        System.out.println("Lista de productos con baja stock");
        ProductoAbstracto producto1 = new Producto("Monitor", "pantalla para pc", 450000.0, 0);
        ProductoAbstracto producto2 = new Producto("Iphone 16", "smartphone", 500000.0, 0);
        productoDao.agregarProducto(producto1);
        productoDao.agregarProducto(producto2);
        List<ProductoAbstracto> listaProductos = productoDao.productosConBajaStock();
        listaProductos.forEach(System.out::println);

    }
}
