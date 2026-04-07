 /*
 * Autores: Maria Gimena Czarnievicz y Tomas Manuel Gallo
 */
package obligatorio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Metodos {

    //Metodo para valorizar
    public static int PedirNum(int min, int max, String texto) {
        Scanner on = new Scanner(System.in);
        int numero = -1;
        boolean ok = false;
        boolean primeraVez = true;
        while (!ok) {

            while (numero > max || numero < min) {
                if (primeraVez) {
                    System.out.println("•Ingrese " + texto);
                } else {
                    System.out.println("-------------------------------------"
                            + "--------");
                    System.out.println("         Ingrese " + texto + " de vuelta");
                    System.out.println("Debes ser un mumero entre el " + min + " y "
                            + max);
                }
                try {
                    numero = on.nextInt();
                } catch (InputMismatchException e) {
                    on.nextLine();
                }
                primeraVez = false;
            }
            ok = true;
            on.nextLine();
        }
        return numero;
    }

    //para crear CLIENTE
    public static Cliente icliente() {
        Scanner in = new Scanner(System.in);
        Cliente cli = null;
        String nom, ci1, direc, rut;
        int edad;
        Personal per;
        Empresarial emp;
        int tipoCli = -1;

        //Pido por pantalla el tipo de cliente
        boolean ok = false;
        while (!ok) {
            System.out.println("Ingrese el tipo de cliente"
                    + "\n 1- Personal"
                    + "\n 2- Empresarial");
            tipoCli = PedirNum(1, 2, "tipo de cliente");
            ok = true;
        }

        switch (tipoCli) {
            case 1:
                //Pido por pantalla el nombre
                nom = PedirTxto("Nombre");

                // Pido por pantalla la direccion
                direc = PedirTxto("Direccion");

                //Pido por pantalla el ci del cliente
                System.out.println("•Ingrese C.I:");
                ci1 = in.nextLine();

                //Pido por pantalla el ci del cliente
                edad = PedirNum(18, 100, "Edad");

                cli = new Personal(nom, direc, ci1, edad);
                break;

            case 2:
                //Pido por pantalla el Nombre
                nom = PedirTxto("Nombre");

                //Pido por pantalla la direccion
                direc = PedirTxto("Direccion");

                //Pido por pantalla el Rut del cliente
                System.out.println("•Ingrese Rut:");
                rut = in.nextLine();

                cli = new Empresarial(nom, direc, rut);
                break;

            default:
        }
        return cli;
    }

    //Metodo para pedir texto
    public static String PedirTxto(String texto) {
        Scanner in = new Scanner(System.in);
        String texto1 = "";
        while (texto1.trim().equals("")) {
            System.out.println("•Ingrese " + texto);
            texto1 = in.nextLine();
        }
        return texto1;
    }

    //Metodo de cracion de POLIZA
    public static Poliza iPoliza(Cliente cli) {
        Poliza poli;
        String mat = null;
        int mon = -1;
        int tipol = -1, vencpolmes = -1, vencpolanio = -1;
        Scanner in = new Scanner(System.in);
        poli = new Poliza(mat, mon, tipol, vencpolmes, vencpolanio, cli);


        //Pido por pantalla marticula del vehiculo
        System.out.println("\n---------------------------------------"
                + "---------"
                + "\n          Ingrese datos de Poliza      "
                + "\n------------------------------------------------"
                + "\n•Ingrese Matricula Del Auto A Asegurar:");
        mat = in.nextLine();
        poli.setMatricula(mat);

        //Pido por pantalla el monta de aseguracion
        mon = PedirNum(0, Integer.MAX_VALUE, "monto en pesos $:");
        poli.setMonto(mon);

        //Pido por pantalla el tipo de pliza
        System.out.println("\n•Ingrese Tipo de Poliza:               "
                + "\n      1-Responsabilidad Civil          "
                + "\n      2-Incendio                       "
                + "\n      3-Hurto                          "
                + "\n      4-Choque                         "
                + "\n      5-Vandalismo                     "
                + "\n      6-Seguro Total                   "
                + "\n--------------------------------------"
                + "----------");
        tipol = PedirNum(1, 6, "Tipo De Poliza");
        poli.setTipoDePoliza(tipol);

        //Pido por pantalla el vencimiento de poliza
        vencpolmes = PedirNum(1, 12, "Mes Del Vencimiento De La Poliza,"
                + "\nlas opciones son:"
                + "\n      1-Enero"
                + "\n      2-Febrero"
                + "\n      3-Marzo"
                + "\n      4-Abril"
                + "\n      5-Mayo"
                + "\n      6-Junio"
                + "\n      7-Julio"
                + "\n      8-Agosto"
                + "\n      9-Setiembre"
                + "\n      10-Octubre"
                + "\n      11-Noviembre"
                + "\n      12-Diciembre"
                + "\n------------------------------------------------");
        poli.setVencMes(vencpolmes);

        //Pido por pantalla el ano de vencimiento de la poliza
        vencpolanio = PedirNum(2000, 2030, "Año  De Vencimiento De La Poliza");
        poli.setVencAnio(vencpolanio);

        poli.setCliente(cli);
        return poli;
    }

//Metodos de creacion de RECLAMO
    public static Reclamo iReclamo(Poliza poli) {
        Reclamo recl;
        int tipPoliRec;
        int tipPoli;
        int sumRecl;
        int diaSin = 0, mesSin = 0, anioSin = 0;
        int diaASin = 0, mesASin = 0, anioASin = 0;
        Scanner in = new Scanner(System.in);
        recl = new Reclamo(poli, anioASin, diaSin, mesSin, anioSin, diaASin, mesASin, anioASin, mesSin);

        //Ingreso del tipo de Poliza a reclamar
        tipPoliRec = PedirNum(1, 5, "Tipo De Siniestro De Poliza A Reclamar:"
                + "\n           1-Responsabilidad Civil          "
                + "\n           2-Incendio                     "
                + "\n           3-Hurto                        "
                + "\n           4-Choque                       "
                + "\n           5-Vandalismo                   "
                + "\n------------------------------------------"
                + "------");
        tipPoli = ValidacionPoliRec(tipPoliRec, poli.getTipoDePoliza());
        recl.setTipoDeSin(tipPoli);


        boolean texto = false;
        while (texto == false) {
            //Ingreso del dia del siniestro
            diaSin = PedirNum(1, 30, "Dia Del Siniestro");
            recl.setDiaSin(diaSin);

            //Ingreso del mes del siniestro
            mesSin = PedirNum(1, 12, "Mes Del Siniestro, "
                    + "las opciones son:"
                    + "\n      1-Enero"
                    + "\n      2-Febrero"
                    + "\n      3-Marzo"
                    + "\n      4-Abril"
                    + "\n      5-Mayo"
                    + "\n      6-Junio"
                    + "\n      7-Julio"
                    + "\n      8-Agosto"
                    + "\n      9-Setiembre"
                    + "\n      10-Octubre"
                    + "\n      11-Noviembre"
                    + "\n      12-Diciembre"
                    + "\n------------------"
                    + "------------------------------");
            recl.setMesSin(mesSin);

            //Ingreso del anio del siniestro
            anioSin = PedirNum(2000, 2030, "Año Del Siniestro:");
            recl.setAnioSin(anioSin);

            //Meditante el metodo de ValiDate, valorizo que la fecha sea correcta            
            texto = ValiDate(poli.getVencAnio(), poli.getVencMes(), anioSin, mesSin);
        }


        boolean texto1 = false;
        while (texto1 == false) {
            //Ingreso del anio de aviso del siniestro
            anioASin = PedirNum(2000, 2030, "año De Aviso Del Siniestro:");
            recl.setAnioAvisoSin(anioASin);

            //Ingreso del mes de aviso del siniestro
            mesASin = PedirNum(1, 12, "Mes Del Aviso Del Siniestro, "
                    + "las opciones son:"
                    + "\n      1-Enero"
                    + "\n      2-Febrero"
                    + "\n      3-Marzo"
                    + "\n      4-Abril"
                    + "\n      5-Mayo"
                    + "\n      6-Junio"
                    + "\n      7-Julio"
                    + "\n      8-Agosto"
                    + "\n      9-Setiembre"
                    + "\n      10-Octubre"
                    + "\n      11-Noviembre"
                    + "\n      12-Diciembre"
                    + "\n------------------"
                    + "------------------------------");
            recl.setMesAvisoSin(mesASin);

            //Ingreso del dia de aviso del siniestro
            diaASin = PedirNum(1, 30, "Dia De Aviso Del Siniestro:");
            recl.setDiaAvisoSin(diaASin);

            //Meditante el metodo de ValiDateDay, valorizo que la fecha sea correcta
            texto1 = ValiDateDay(anioASin, mesASin, diaASin, anioSin, mesSin, diaSin);
        }

        //Ingreso El Monto a Reclamar
        sumRecl = PedirNum(0, poli.getMonto(), " Monto a reclamar");
        recl.setRecMonto(sumRecl);

        return recl;
    }

    //Metodo para validar, mes y anio
    private static boolean ValiDate(int aniop, int mesp, int anios, int mess) {
        boolean texto;
        texto = true;

        if (aniop > anios) {
            texto = true;
        } else {
            if (aniop == anios) {
                if (mesp > mess) {
                    texto = true;
                } else {
                    if (mesp == mess) {
                        texto = true;
                    } else {
                        texto = false;
                    }
                }
            } else {
                texto = false;
            }
        }
        return texto;
    }

    //Metodo para validar Dia, Mes y Anio
    private static boolean ValiDateDay(int anioAS, int mesAS, int diaAS, int anios, int mess, int dias) {
        boolean texto;
        texto = true;

        if (anioAS > anios) {
            texto = true;
        } else {
            if (anioAS == anios) {
                if (mesAS > mess) {
                    texto = true;
                } else {
                    if (mesAS == mess) {
                        if (diaAS >= dias) {
                            texto = true;
                        } else {
                            texto = false;
                        }
                    } else {
                        texto = false;
                    }
                }
            } else {
                texto = false;
            }
        }
        return texto;
    }

//Validacion de la Poliza del Reclamo
    private static int ValidacionPoliRec(int tipPoliRec, int poli) {
        int tipoli;
        tipoli = -1;
        if (tipPoliRec == poli || poli == 6) {
            tipoli = tipPoliRec;
        } else {
            while (poli != tipPoliRec || poli == 6) {
                System.out.println("¡Tipo de poliza a Reclamar Incorrecto!");
                tipPoliRec = PedirNum(1, 5, "Tipo de Poliza"
                        + "\n       1-Responsabilidad Civil           "
                        + "\n       2-Incendio                        "
                        + "\n       3-Hurto                           "
                        + "\n       4-Choque                          "
                        + "\n       5-Vandalismo                      "
                        + "\n-----------------------------------------"
                        + "-------");
            }
            tipoli = tipPoliRec;
        }
        return tipoli;
    }

    //Metodo de consula de tiempo
    //Se creo una Lista donde se guarda el tiempo transcurrido en dias, para luego ser recorrida y tomar el maximo, minimo y calcular su promedio
    public static void consultaTiempo(Listas l) {
        l.getListaDeConsultaDeTimpo().clear();
        Reclamo rec;
        int difAnio;
        int difMes;
        int diaTot = -1;
        for (int i = 0; i < l.getListaDeReclamos().size(); i++) {
            rec = l.getListaDeReclamos().get(i);
            difAnio = rec.getAnioAvisoSin() - rec.getAnioSin();
            difAnio = difAnio * 360;
            difMes = rec.getMesAvisoSin() - rec.getMesSin();
            difMes = difMes * 30;
            diaTot = difAnio + difMes + rec.getDiaAvisoSin() - rec.getDiaSin();
            l.agregarListaDeConsultaDeTimpo(diaTot);
        }
    }

    //Metodo que muestra por pantalla el minimo, maximo y promedio
    public static void ConsultaMianMaxProm(Listas l) {
        int max, min;
        long prom;
        consultaTiempo(l);
        max = timpoMax(l);
        min = timpoMin(l);
        prom = tiempoProm(l);
        System.out.println("El Timpo Maximo fue: " + max + "dias"
                + "\n El Tiempo Minimo fue: " + min + "dias"
                + "\n El Promedio es: " + prom + "dias"
                + "\n--------------------------------------"
                + "----------");
    }

    //Metodo para calcular el maximo de dias transcurridos
    private static int timpoMax(Listas l) {
        int max;
        max = 0;
        int nro = 0;
        for (int i = 0; i < l.getListaDeConsultaDeTimpo().size(); i++) {
            max = l.getListaDeConsultaDeTimpo().get(i);
            if (nro < max) {
                nro = max;
            } else {
            }
        }
        return nro;
    }

    //Metodo para calcular el minimo de dias transcurridos
    private static int timpoMin(Listas l) {
        int min = 0;
        int nro = 10000;
        for (int i = 0; i < l.getListaDeConsultaDeTimpo().size(); i++) {
            min = l.getListaDeConsultaDeTimpo().get(i);
            if (nro > min) {
                nro = min;
            } else {
            }
        }
        return nro;
    }

    //Metodo para calcular el timpo promedio transcurrido
    private static long tiempoProm(Listas l) {
        long prom = 0;
        long sum;
        long nro = 0;
        for (int i = 0; i < l.getListaDeConsultaDeTimpo().size(); i++) {
            sum = l.getListaDeConsultaDeTimpo().get(i);
            nro = sum + nro;
        }
        int i = l.getListaDeConsultaDeTimpo().size();
        prom = nro / i;
        return prom;
    }

    //Metodo para ver que tipo de sinisetro es mas comun.
    //creamos una nueva lista y fuimos sumando uno a la posicion corresponinte al tipo de poliza
    public static void tipoDeSiniestroMasComun(Listas l) {
        int[] tipoMasComun = new int[6];
        String[] tipoSin = {" ", " <1> Responsabilidad Civil", " <2> Incendio", " <3> Hurto", " <4> Choque", " <5> Vandalismo"};

        for (int i = 0; i < l.getListaDeReclamos().size(); i++) {
            int poli;
            poli = l.getListaDeReclamos().get(i).getTipoDeSin();
            tipoMasComun[poli] = tipoMasComun[poli] + 1;
        }
        int max = 0;
        for (int i = 1; i < tipoMasComun.length; i++) {
            if (max < tipoMasComun[i]) {
                max = tipoMasComun[i];
            }
        }
        for (int i = 1; i < tipoMasComun.length; i++) {
            if (max == tipoMasComun[i]) {
                System.out.println("El siniestro mas comun es:" + tipoSin[i]
                        + "\n--------------------------------------"
                        + "----------");
            }
        }
    }

    //Metodo para calcular el monto a pagar por un tipo de poliza, dando un mes y un anio
    public static int ConsultaDePago(Listas l, int datoM, int datoA, int datoTP) {
        int sumaMon = 0;
        for (int i = 0; i < l.getListaDeReclamos().size(); i++) {
            if (datoM == l.getListaDeReclamos().get(i).getMesSin() && datoA == l.getListaDeReclamos().get(i).getAnioSin() && datoTP == l.getListaDeReclamos().get(i).getTipoDeSin()) {
                sumaMon = sumaMon + l.getListaDeReclamos().get(i).getRecMonto();
            }
        }
        return sumaMon;
    }
}
