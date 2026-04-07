/*
 *Autores: Maria Gimena Czarnievicz y Tomas Manuel Gallo
 */
package obligatorio;

public class Personal extends Cliente {

    private String ci;
    private int edad;

    /*set y get del CI*/
    public String getCi() {
        return ci;
    }

    public void setCi(String unaCi) {
        ci = unaCi;
    }

    /*set y get del Edad*/
    public int getEdad() {
        return edad;
    }

    public void setEdad(int unaEdad) {
        edad = unaEdad;
    }

    public Personal(String nombre, String direccion, String ci, int edad) {
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setCi(ci);
        this.setEdad(edad);
    }

    @Override
    public String toString() {
        super.toString();
        return super.toString()
                + "\n   Edad: " + getEdad()
                + "\n   N° De C.I.: " + getCi();
    }
}
