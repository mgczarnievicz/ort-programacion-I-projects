/*
 * Autores: Maria Gimena Czarnievicz y Tomas Gallo
 */

package obligatorio;
public class Cliente {
   
    //defino mis variables//
    private String nombre;
    private String ci;
    private String direccion;
    /*set y get del nombre*/
    public String getNombre(){
        return nombre;
        }
    public void setNombre(String unNombre){
        nombre= unNombre;
        }
    /*set y get del CI*/
    public String getCi(){
        return ci;
        }
    public void setCi(String unaCi){
        ci=unaCi;
        }
    /*set y get de la direcccion*/
    public String getDireccion(){
        return direccion;
        }
    public void setDireccion(String unaDireccion){
        direccion=unaDireccion;
        }

//creacion del toString//
@Override
public String toString(){
        return  "---------------------------------------------" +
                "\n•Nombre Del cliente: " +getNombre()+           ""+
                "\n•Numero De Ci: " +getCi()+                     ""+
                "\n•Direccion: " +getDireccion()+                 ""+
                "\n---------------------------------------------";
                }

public Cliente (){
    this.setNombre(nombre);
    this.setCi(ci);
    this.setDireccion(direccion);
}
}
