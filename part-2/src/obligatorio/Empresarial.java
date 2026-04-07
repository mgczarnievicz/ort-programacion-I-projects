/*
 *Autores: Maria Gimena Czarnievicz y Tomas Manuel Gallo
 */
package obligatorio;

public class Empresarial extends Cliente {
    
    private String rut;

    /*set y get del Rut*/
    public String getRut() {
        return rut;
    }

    public void setRut(String unRut) {
        rut = unRut;
    }

    //Constructor
    public Empresarial(String nombre, String direccion, String rut) {
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setRut(rut);
    }

    @Override
    public String toString() {
        super.toString();
        return super.toString()
                + "\n   RUT del cliente: " + getRut();
    }
}
