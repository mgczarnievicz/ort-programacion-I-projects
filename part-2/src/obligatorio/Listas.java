/*
 * Autores: Maria Gimena Czarnievicz y Tomas Manuel Gallo
 */

package obligatorio;
import java.util.ArrayList;

public class Listas {
    
    // Lista de Clientes
    private ArrayList<Cliente>listaDeClientes;

    public ArrayList<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }
    public void eliminarCliente(Cliente unCliente) {
        this.getListaDeClientes().remove(unCliente);
    }
    public void agregarCliente(Cliente unCliente) {
        this.getListaDeClientes().add(unCliente);
    }


    //Lista de polizas
    private ArrayList<Poliza>listaDePolizas;

    public ArrayList<Poliza> getListaDePolizas() {
        return listaDePolizas;
    }
    public void eliminarPoliza(Poliza unaPoliza) {
        this.getListaDePolizas().remove(unaPoliza);
    }
    public void agregarPoliza(Poliza unaPoliza) {
        this.getListaDePolizas().add(unaPoliza);
    }


    //Lista de reclamos
    private ArrayList<Reclamo>listaDeReclamos;

    public ArrayList<Reclamo> getListaDeReclamos() {
        return listaDeReclamos;
    }
    public void eliminarReclamo(Reclamo unReclamo) {
        this.getListaDeReclamos().remove(unReclamo);
    }
    public void agregarReclamo(Reclamo unReclamo) {
        this.getListaDeReclamos().add(unReclamo);
    }

    
    //Lista de Consulta de Timpos
    private ArrayList<Integer>listaDeConsultaDeTimpo;

    public ArrayList<Integer> getListaDeConsultaDeTimpo() {
        return listaDeConsultaDeTimpo;
    }
    public void eliminarListaDeConsultaDeTimpo(Integer unInteger) {
        this.getListaDeConsultaDeTimpo().remove(unInteger);
    }
    public void agregarListaDeConsultaDeTimpo(Integer unInteger) {
        this.getListaDeConsultaDeTimpo().add(unInteger);
    }



public Listas(){
 listaDeClientes =new ArrayList<Cliente>();
 listaDePolizas =new ArrayList<Poliza>();
 listaDeReclamos =new ArrayList<Reclamo>();
 listaDeConsultaDeTimpo= new ArrayList<Integer>();
}

}

