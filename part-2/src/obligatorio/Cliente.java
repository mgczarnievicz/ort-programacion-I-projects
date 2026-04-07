/*
 * Autores: Maria Gimena Czarnievicz y Tomas Manuel Gallo
 */
package obligatorio;

public abstract class Cliente {

    //defino mis variables//
    private String nombre;
    private String direccion;

    /*set y get del nombre*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }

    /*set y get de la direcccion*/
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String unaDireccion) {
        direccion = unaDireccion;
    }

//creacion del toString//
    @Override
    public String toString() {
        return  "\n   Nombre : " + getNombre()
                + "\n   Direccion: " + getDireccion();
    } 
}
