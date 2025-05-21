package ProductosDAO;

import Productos.ProductoAbstracto;

import java.util.List;

public interface IProductoDao {
    List<ProductoAbstracto> listarProductos();
    Boolean agregarProducto(ProductoAbstracto productoAbstracto);
    Boolean eliminarProducto(ProductoAbstracto productoAbstracto);
    Boolean modificarStock(ProductoAbstracto producto);
    Boolean modificarPrecio(ProductoAbstracto producto);
    Boolean modificarNombre(ProductoAbstracto producto);
    Boolean modificarDescripcion(ProductoAbstracto producto);
    Boolean buscarProducto(ProductoAbstracto producto);
    List<ProductoAbstracto> productosConBajaStock();
}
