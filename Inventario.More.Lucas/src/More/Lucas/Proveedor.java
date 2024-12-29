package More.Lucas;

public class Proveedor {
    private String nombre;
    private String contacto;

    public Proveedor(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
    }
    
    public static boolean sonIguales(Proveedor p1, Proveedor p2)
    {
        return p1.nombre.equals(p2.nombre) && p1.contacto.equals(p2.contacto);
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
    public String getInformacionProveedor()
    {
        return this.getNombre()+" - "+this.getContacto();
    }
}
