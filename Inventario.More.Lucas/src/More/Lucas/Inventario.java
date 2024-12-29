package More.Lucas;

import java.util.ArrayList;

public class Inventario {
    private int capacidad;
    private ArrayList <Producto> productos;

    public Inventario(int capacidad) {
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }
   
    public Inventario()
    {
        this(3);
    }
    
    public  boolean sonIguales(Producto p1)
    {
        boolean rta = false;
        for(Producto producto : productos)
        {
            if(producto.equals(p1))
            {
                rta = true;
            }
        }
        return rta;
    }
    
    public void agregar(Producto p1)
    {
        if(this.productos.size() < this.capacidad && this.sonIguales(p1)==false)
        {
            this.productos.add(p1);
            System.out.println("Producto agregado exitosamente!...");
        }
        else if(this.sonIguales(p1))
        {
            System.out.println("El Producto ya se encuentra agregado, reintente nuevamente otro producto!...");
        }
        else
        {
            System.out.println("No se encuentra espacio disponible para el producto!...");
        }
    }
    
    private double getPrecio(TipoProducto tipoProducto)
    {
        double precioTotal=0.0;
        for(Producto producto : this.productos)
        {
            switch(tipoProducto)
            {
               case ALIMENTICIOS:
                   if(producto instanceof ProductoAlimenticio)
                   {
                       precioTotal += producto.getPrecio();
                   }
                   break;
               case ELECTRONICOS:
                   if(producto instanceof ProductoElectronico)
                   {
                       precioTotal += producto.getPrecio();
                   }
                   break;
               case TODOS:
                   precioTotal += producto.getPrecio();
                   break;
            }         
        }
        return precioTotal;
    }
    
    public double getPrecioDeAlimenticios()
    {
        return this.getPrecio(TipoProducto.ALIMENTICIOS);
    }
    
    public double getPrecioDeElectronico()
    {
        return this.getPrecio(TipoProducto.ELECTRONICOS);
    }
    
    public double getPrecioTotal()
    {
        return this.getPrecio(TipoProducto.TODOS);
    }
    
     public static String mostrar(Inventario i1)
    {
        StringBuilder cadena = new StringBuilder();
        cadena.append("---Inventario-----\n").append("Capacidad Maxima: ").append(i1.capacidad).append(" | ").append("productos disponibles: \n");
        i1.productos.forEach(producto -> cadena.append(producto.toString()).append("\n"));
        cadena.append("Precio Total: ").append(i1.getPrecioTotal());
        return cadena.toString();
    }  
}
