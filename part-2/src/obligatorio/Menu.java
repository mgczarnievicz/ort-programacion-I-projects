/*
 * Autores: Maria Gimena Czarnievicz y Tomas Manuel Gallo
 */
package obligatorio;

import java.util.Collections;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int num;
        Listas l = new Listas();
        num = -1;             
        
        Scanner in = new Scanner(System.in);
        while (num != 0) {
            num = Metodos.PedirNum(0, 8, "la opcion deseada "
                    + "\n 1-Ingresar Cliente"
                    + "\n 2-Registrar Poliza"
                    + "\n 3-Registrar Reclamo"
                    + "\n 4-Consulta de Pagos"
                    + "\n 5-Mostrar Listado"
                    + "\n 6-Consulta de Tiempo Maximo, Promedio y Minimo de Reclamo"
                    + "\n 7-Dar Baja de Poliza"
                    + "\n 8-Tipo de Siniestro mas comun"
                    + "\n 0-Terminar"
                    + "\n------------------------------------------------");


            switch (num) {

                case 1:
                    //Ingresar Cliente
                    Cliente cli;
                    System.out.println("Ingrese Un Cliente");
                    cli = Metodos.icliente();
                    l.agregarCliente(cli);
                    break;

                case 2:
                    //Registrar una POLIZA a un Cliente a seleccionar
                    Cliente clim;
                    Poliza poli;
                    int numcli;
                    if (l.getListaDeClientes().isEmpty()) {
                        System.out.println("Ingrese Al Menos Un Cliente Primero");
                        in.nextLine();
                    } else {
                        for (int i = 0; i < l.getListaDeClientes().size(); i++) {
                            clim = l.getListaDeClientes().get(i);
                            System.out.println(i + 1 + "-" + clim);
                        }
                        numcli = Metodos.PedirNum(1, l.getListaDeClientes().size(), "el numero correspondiente al cliente deseado");
                        poli = Metodos.iPoliza(l.getListaDeClientes().get(numcli - 1));
                        l.agregarPoliza(poli);
                    }
                    break;

                case 3:
                    //Ingresar un RECLAMO a una Poliza a seleccionar
                    Poliza poli1;
                    Reclamo rec;
                    int numpoli;
                    if (l.getListaDePolizas().isEmpty()) {
                        System.out.println("Ingrese una Poliza primero");
                        in.nextLine();
                    } else {
                        for (int i = 0; i < l.getListaDePolizas().size(); i++) {
                            poli1 = l.getListaDePolizas().get(i);
                            System.out.println(i + 1 + "-" + poli1);
                        }
                        numpoli = Metodos.PedirNum(1, l.getListaDePolizas().size(), "el numero correspondiente a la poliza deseada");
                        rec = Metodos.iReclamo(l.getListaDePolizas().get(numpoli - 1));
                        l.agregarReclamo(rec);
                    }
                    break;

                case 4:
                    //CONSULTA DE PAGO
                    //pido un mes, un anio y un tipo de poliza
                    int ingMes;
                    int ingAnio;
                    int ingTip;
                    int sumaMonto;
                    if (l.getListaDeReclamos().isEmpty()) {
                        System.out.println("Ingrese al menos un Reclamo");
                        in.nextLine();
                    } else {
                        ingMes = Metodos.PedirNum(1, 12, "Mes");
                        
                        ingAnio = Metodos.PedirNum(2000, 2030, "Año");

                        ingTip = Metodos.PedirNum(1, 5,
                                "tipo de poliza"
                                + "\n      1-Responsabilidad Civil          "
                                + "\n      2-Incendio                       "
                                + "\n      3-Hurto                          "
                                + "\n      4-Choque                         "
                                + "\n      5-Vandalismo                     "
                                + "\n--------------------------"
                                + "----------------------");
                        sumaMonto = Metodos.ConsultaDePago(l, ingMes, ingAnio, ingTip);
                        System.out.println("La Suma total reclamada es $" + sumaMonto);
                    }
                    break;

                case 5:
                    //LISTADO
                    Reclamo recv;
                    if (l.getListaDeReclamos().isEmpty()) {
                        System.out.println("Ingrese al menos un Reclamo");
                        in.nextLine();
                    } else {
                        Collections.sort(l.getListaDeReclamos());
                        for (int i = 0; i < l.getListaDeReclamos().size(); i++) {
                            recv = l.getListaDeReclamos().get(i);
                            System.out.println(i + 1 + "-" + recv);
                        }
                    }
                    break;

                case 6:
                    //Consulta de timpo MAXIMO
                    if (l.getListaDeReclamos().isEmpty()) {
                        System.out.println("Ingrese al menos un reclamo");
                        in.nextLine();
                    } else {
                        Metodos.ConsultaMianMaxProm(l);
                    }
                    break;

                case 7:
                    //BAJA de Poliza
                    Poliza poli2;
                    poli2 = null;
                    int numpoli1;
                    if (l.getListaDePolizas().isEmpty()) {
                        System.out.println("Ingrese una Poliza");
                        in.nextLine();
                    } else {
                        //Muestro la lista de Polizas
                        for (int i = 0; i < l.getListaDePolizas().size(); i++) {
                            poli2 = l.getListaDePolizas().get(i);
                            System.out.println(i + 1 + "-" + poli2);
                        }

                        //Eligo la poliza a eliminar
                        numpoli1 = Metodos.PedirNum(1, l.getListaDePolizas().size(), "el numero correspondiente a la poliza deseada");
                        poli2 = l.getListaDePolizas().get(numpoli1 - 1);
                        char confirmacion = ' ';
                        while (confirmacion != 's' && confirmacion != 'n') {
                            System.out.println("Esta seguro de eliminar dicha poliza"
                                    + "\n Presione s, si esta seguro"
                                    + "\n Presione n, si no esta seguro.");
                            confirmacion = in.nextLine().charAt(0);
                            switch (confirmacion) {
                                case 'n':
                                    confirmacion = 'n';
                                    break;

                                case 's':
                                    //Elimino los Reclamos contra la poliza dada de baja
                                    for (int i = l.getListaDeReclamos().size() - 1; i >= 0; i--) {
                                        recv = l.getListaDeReclamos().get(i);
                                        if (poli2.equals(recv.getPoliza())) {
                                            l.eliminarReclamo(recv);
                                        }
                                    }
                                    confirmacion = 's';
                                    //Elimino la Poliza
                                    l.eliminarPoliza(poli2);
                                    break;
                            }
                        }
                    }
                    break;


                case 8:
                    //Tipo de Simiestro MAS COMUN
                    if (l.getListaDeReclamos().isEmpty()) {
                        System.out.println("Ingrese por los menos un Reclamo");
                        in.nextLine();
                    } else {
                        Metodos.tipoDeSiniestroMasComun(l);
                    }
                    break;

                default:
            }
        }
    }
}
