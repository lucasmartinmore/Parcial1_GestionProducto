package More.Lucas;
import java.util.Objects;

public class ProductoElectronico extends Producto{
public TipoGarantia garantia;

    public ProductoElectronico(String nombre, float precio, Proveedor proveedor, TipoGarantia garantia   ) {
        super(nombre, precio, proveedor);
        this.garantia = garantia;
    }
    
     @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append(super.toString()).append("Garantia: ").append(this.garantia).append(" | ");
      return cadena.toString(); 
    }
    
     @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj instanceof ProductoElectronico otroProducto)
        {
            rta = super.equals(obj) && this.garantia == otroProducto.garantia;    
        }
        return rta;
    }  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.garantia);
        return hash;
    }
    
    
    

}
