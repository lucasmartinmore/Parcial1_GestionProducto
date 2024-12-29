package More.Lucas;
import java.util.Objects;

public class ProductoAlimenticio extends Producto {
    public TipoCategoria categoria;

    public ProductoAlimenticio(String nombre, float precio, Proveedor proveedor, TipoCategoria categoria) {
        super(nombre, precio, proveedor);
        this.categoria = categoria;
    }
    
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append(super.toString()).append("Categoria: ").append(this.categoria).append(" | ");
      return cadena.toString(); 
    }
    
     @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj instanceof ProductoAlimenticio otroProducto)
        {
            rta = super.equals(obj) && this.categoria == otroProducto.categoria;    
        }
        return rta;
    }  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.categoria);
        return hash;
    }
    
}
