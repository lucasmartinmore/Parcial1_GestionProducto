package More.Lucas;

public class Recuperatorio_More {

    public static void main(String[] args) {
        Inventario miInventario = new Inventario(5);
        Proveedor p1 = new Proveedor("Alimentos SA", "contacto@alimentossa.com");
        Proveedor p2 = new Proveedor("Tecnología SRL", "ventas@tecnologiasrl.com");

        ProductoAlimenticio a1 = new ProductoAlimenticio("Arroz", 50.75f, p1,
                TipoCategoria.NO_PERECEDERO);
        ProductoElectronico e1 = new ProductoElectronico("Smartphone", 299.99f, p2,
                TipoGarantia.DOS_ANIOS);

        miInventario.agregar(a1);
// YA INGRESADO
        miInventario.agregar(a1);
        miInventario.agregar(e1);

        System.out.println("");
// TRUE
        System.out.println(a1.equals(a1));
// FALSE
        System.out.println(a1.equals(e1));

        System.out.println("");
        System.out.println(Inventario.mostrar(miInventario));
    }
}
