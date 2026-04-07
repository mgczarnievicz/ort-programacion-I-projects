/*
 * Autores: Maria Gimena Czarnievicz y Tomas Gallo
 */

package obligatorio;
public class Poliza {
    //Defino mis variables//
    private Cliente cliente;
    private String matricula;
    private int monto;
    private int tipoDePoliza;
    private int vencAnio;
    private int vencMes;
    int a=0;

    
    /*set y get del cliente*/
    public Cliente getCliente(){
        return cliente;
        }
    public void setCliente(Cliente unCliente){
        cliente= unCliente;
        }

    /*set y get del matricula*/
    public String getMatricula(){
        return matricula;
        }
    public void setMatricula(String unaMatricula){
        matricula= unaMatricula;
        }

    /*set y get del monto*/
    public int getMonto(){
        return monto;
        }
    public void setMonto(int unMonto){
        monto= unMonto;
        }
    /*set y get del tipo de poliza*/
    public int getTipoDePoliza(){
        return tipoDePoliza;
        }
    public void setTipoDePoliza(int unTipoDePoliza){
        tipoDePoliza= unTipoDePoliza;
        }

    /*set y get del vencimiento anio*/
    public int getVencAnio(){
        return vencAnio;
        }
    public void setVencAnio(int unVencAnio){
        vencAnio= unVencAnio;
        }

    /*set y get del vencimiento mes*/
    public int getVencMes(){
        return vencMes;
        }
    public void setVencMes(int unVencMes){
        vencMes= unVencMes;
        }


 //creacion del toString para manejar los datos del cliente
 @Override
 public String toString(){
        return "\n---------------------------------------------"+
                "\nPOLIZA"+
                "\n•CLIENTE: "+"\n"+getCliente()+
                "\n•Matricula: " +this.getMatricula().toUpperCase()+
                "\n•Tipo De Poliza: "+this.getTipoDePoliza()+
                "\n•Monto De Aseguracion: "+this.getMonto()+
                "\n•Fecha De Vencimeiento MM/AA: "+this.getVencMes()+"/" +
                                                      this.getVencAnio()+
                "\n---------------------------------------------";
    }

public Poliza (){
    this.setMatricula(matricula);
    this.setMonto(monto);
    this.setTipoDePoliza(tipoDePoliza);
    this.setVencMes(vencMes);
    this.setVencAnio(vencAnio);
    
}
}
