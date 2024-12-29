package More.Lucas;


import java.util.Objects;
import java.util.Random;

public abstract class Producto {
    protected Proveedor proveedor;
    protected int cantidadEnStock;
    protected String nombre;
    protected float precio;
    protected static Random generadorDeStock;
    
    static
    {
        generadorDeStock = new Random();
    }

    public Producto(String nombre,float precio,Proveedor proveedor) {
        this.proveedor = proveedor;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = 0;
    }
    
    public Producto(String nombre, float precio, String nombreProveedor, String contactoProveedor) {
        this(nombre, precio, new Proveedor(nombreProveedor, contactoProveedor));
    }
    
    public int getCantidadEnStock() {
        if (cantidadEnStock == 0) {
            cantidadEnStock = generadorDeStock.nextInt(491) + 10; // 10-500
        }
        return cantidadEnStock;
    }

    public float getPrecio() {
        return precio;
    }
    
     private static String mostrar(Producto p1)
    {
        StringBuilder cadena = new StringBuilder();
        cadena.append("Proveedor: ").append(p1.proveedor.getInformacionProveedor()).append(" | ");
        cadena.append("Cantidad stock: ").append(p1.cantidadEnStock).append(" | ");
        cadena.append("Nombre Producto: ").append(p1.nombre).append(" | ");
        cadena.append("Precio: ").append(p1.precio).append(" | ");
        return cadena.toString();
    }

    public static boolean sonIguales(Producto p1, Producto p2) {
        return p1.nombre.equals(p2.nombre) && Proveedor.sonIguales(p1.proveedor, p2.proveedor);
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if (obj instanceof Producto producto)
        {
            rta = Producto.sonIguales(this, producto);
        }
        return rta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.proveedor);
        hash = 59 * hash + this.cantidadEnStock;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Float.floatToIntBits(this.precio);
        return hash;
    }

    @Override
    public String toString() {
        return mostrar(this);
    }   
}

    
 
