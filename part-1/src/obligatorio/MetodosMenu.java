/*
 * Autores: Maria Gimena Czarnievicz y Tomas Gallo
 */

package obligatorio;
import java.util.Scanner;

public class MetodosMenu {

    //Metodo para crear CLINETE
    public static Cliente icliente() {
        Scanner in=new Scanner(System.in);
        Cliente cli;
        String nom, ci1, direc;
        cli=new Cliente();

        //Pido por pantalla el nombre del cliente
        System.out.println("•Ingrese Nombre:");
        nom=in.nextLine();
        cli.setNombre(nom);

        //Pido por pantalla el ci del cliente
        System.out.println("•Ingrese C.I:");
        ci1=in.nextLine();
        cli.setCi(ci1);

        //Pido por pantalla la direccion del cliente
        System.out.println("•Ingrese Direccion:");
        direc=in.nextLine();
        cli.setDireccion(direc);
        

        return cli;

    }

    //Metodo para valorizar
     public static int PedirNum(int min,int max, String texto){
        Scanner on=new Scanner(System.in);
        int numero;
        numero=on.nextInt();
        while(numero>max||numero<min){
            System.out.println("-------------------------------------"+
                               "--------");
            System.out.println("         Ingrese "+texto+" de vuelta");
            System.out.println("Debes ser un mumero entre el "+min+" y "
                                  +max);
            numero=on.nextInt();
        }
        return numero;
    }
    //metodo de validacion
     public static int ValoriDate(int uno, int dos, int tres ){
        int vd;
        vd=tres;
        if (uno>dos){
            --vd;
        }
        else{
           vd =tres;
        }
         return vd;
     }

     //Metodo de cracion de POLIZA
     public static Poliza iPoliza(Cliente cli) {
        //Para poliza
        Poliza poli;
        String mat;
        int mon;
        int tipol=-1,vencpolmes, vencpolanio;
        Scanner in=new Scanner(System.in);
        poli=new Poliza();


        //Pido por pantalla marticula del vehiculo
        System.out.println("\n-----------------------------------------"+
                           "----"+
                           "\n          Ingrese datos de Poliza      "+
                           "\n-----------------------------------------"+
                           "----"+
                           "\n•Ingrese Matricula Del Auto A Asegurar:");
        mat=in.nextLine();
        poli.setMatricula(mat);

        //Pido por pantalla el monta de aseguracion
        System.out.println("\n•Ingrese Monto en pesos $:");
        mon=in.nextInt();
        poli.setMonto(mon);

        //Pido por pantalla el tipo de pliza
        System.out.println("\n•Ingrese Tipo de Poliza:               "+
                           "\n      1-Responsabilidad Civil          "+
                           "\n      2-Incendio                       "+
                           "\n      3-Hurto                          "+
                           "\n      4-Choque                         "+
                           "\n      5-Vandelismo                     "+
                           "\n      6-Seguro Total                   "+
                           "\n---------------------------------------"+
                           "------");
                        tipol=PedirNum(1,6,"Tipo De Poliza");
                        poli.setTipoDePoliza(tipol);

        //Pido por pantalla el vencimiento de poliza
        System.out.println("\n•Ingrese Mes Del Venciminto De La Poliza,"+
                           "\nlas opciones son:" +
                           "\n      1-Enero" +
                           "\n      2-Febrero" +
                           "\n      3-Marzo" +
                           "\n      4-Abril" +
                           "\n      5-Mayo" +
                           "\n      6-Junio" +
                           "\n      7-Julio" +
                           "\n      8-Agosto" +
                           "\n      9-Setiembre" +
                           "\n      10-Octubre" +
                           "\n      11-Noviembre" +
                           "\n      12-Diciembre"+
                           "\n-------------------------------------"+
                           "--------");
        vencpolmes=PedirNum(1,12,"Mes");
        poli.setVencMes(vencpolmes);

        //Pido por pantalla el ano de vencimiento de la poliza
        System.out.println("\n•Ingrese Año De Vencimieto De La Poliza");
        vencpolanio=PedirNum(2000, 2030, "Año");
        poli.setVencAnio(vencpolanio);

        poli.setCliente(cli);
        return poli;
    }


//Metodos de creacion de RECLAMO
public static Reclamo iReclamo(Poliza poli){
    // para ingresear reclamos
    Reclamo recl;
    int tipPoliRec;
    int tipPoli;
    int sumRecl;
    int diaSin, mesSin, anioSin;
    int diaASin,mesASin,anioASin;
    Scanner in=new Scanner(System.in);
    recl=new Reclamo();

    //Pido por pantalla ingreso de reclamo
    //Ingreso del tipo a reclamar de siniestro
    System.out.println("•Ingrese Tipo De Siniestro De Poliza A Reclamar:");
    System.out.println(    "           1-Responsabilidad Civil          "+
                           "\n           2-Incendio                     "+
                           "\n           3-Hurto                        "+
                           "\n           4-Choque                       "+
                           "\n           5-Vandalismo                   "+
                           "\n------------------------------------------"+
                           "---");
        tipPoliRec =PedirNum(1,5,"Tipo De Poliza");
        tipPoli=ValidacionPoliRec(tipPoliRec, poli.getTipoDePoliza());
        recl.setTipoDeSin(tipPoli);

        //Ingreso del dia del siniestro
        System.out.println("\n•Ingrese Dia Del Siniestro:");
        diaSin=PedirNum(1,30,"Dia Del Siniestro");
        recl.setDiaSin(diaSin);

        //Ingreso del mes del siniestro
        System.out.println("\n•Ingrese Mes Del Siniestro, " +
                           "las opciones son:"+
                           "\n      1-Enero" +
                           "\n      2-Febrero" +
                           "\n      3-Marzo" +
                           "\n      4-Abril" +
                           "\n      5-Mayo" +
                           "\n      6-Junio" +
                           "\n      7-Julio" +
                           "\n      8-Agosto" +
                           "\n      9-Setiembre" +
                           "\n      10-Octubre" +
                           "\n      11-Noviembre" +
                           "\n      12-Diciembre"+
                            "\n-------------------------------------"+
                           "--------");
        mesSin = PedirNum(1, 12, "Mes");
        recl.setMesSin(mesSin);

        //Ingreso del anio del siniestro
        System.out.println("\n•Ingrese Año Del Siniestro:");
        int anioMax=ValoriDate( mesSin, poli.getVencMes()
                                    ,poli.getVencAnio());
        anioSin = PedirNum(2000,anioMax ,"Año");
        recl.setAnioSin(anioSin);

        //Ingreso del anio de aviso del siniestro
        System.out.println("\n•Ingrese Año De Aviso Del Siniestro:");
        anioASin = PedirNum(recl.getAnioSin(),poli.getVencAnio(),"año");
        recl.setAnioAvisoSin(anioASin);

           //Ingreso del mes de aviso del siniestro
        System.out.println("\n•Ingrese Mes De Aviso Del Siniestron:"+
                           "\n      1-Enero" +
                           "\n      2-Febrero" +
                           "\n      3-Marzo" +
                           "\n      4-Abril" +
                           "\n      5-Mayo" +
                           "\n      6-Junio" +
                           "\n      7-Julio" +
                           "\n      8-Agosto" +
                           "\n      9-Setiembre" +
                           "\n      10-Octubre" +
                           "\n      11-Noviembre" +
                           "\n      12-Diciembre"+
                            "\n-------------------------------------"+
                           "-------");
       mesASin=PedirMD(recl.getAnioSin(), recl.getAnioAvisoSin(), recl.getMesSin(), 12,  "Mes", poli.getVencMes());
        recl.setMesAvisoSin(mesASin);

        //Ingreso del dia de aviso del siniestro
        System.out.println("\n•Ingrese Dia De Aviso Del Siniestro:");



       diaASin=PedirMD(recl.getMesSin(),recl.getMesAvisoSin(),recl.getDiaSin(), 30, "Dia",30 );
        
       
        recl.setDiaAvisoSin(diaASin);

        //Ingreso del anio de aviso del siniestro
        System.out.println("\n•Ingrese Monto Del Reclamo:");
        sumRecl =PedirNum(0,poli.getMonto(),  " Monto ");
        recl.setRecMonto(sumRecl);

    return recl;
}

private static int PedirMD(int uno, int dos,  int tres , int cuatro, String testo, int cinco){
   int pmd;
    if (uno==dos){
            pmd=PedirNum(tres, cuatro, testo);
            }
        else{
            pmd=PedirNum(1,cinco,testo);
        }

    return pmd;
}

//Validacion de la Poliza del Reclamo
private static int ValidacionPoliRec(int tipPoliRec, int poli){
         int tipoli;
         tipoli=-1;
         if(tipPoliRec==poli||poli==6){
             tipoli=tipPoliRec;
         }
         else{
             while(poli!=tipPoliRec || poli==6){
              System.out.println("¡Tipo de poliza a Reclamar Incorrecto!");
              System.out.println("\n-------------------------------------"+
                           "--------"+
                         "\nIngrese Tipo de Poliza                   "+
                         "\n       1-Responsabilidad Civil           "+
                         "\n       2-Incendio                        "+
                         "\n       3-Hurto                           "+
                         "\n       4-Choque                          "+
                         "\n       5-Vandalismo                      "+
                         "\n-------------------------------------"+
                           "--------");
                tipPoliRec=PedirNum(1, 5, "Tipo de Poliza");
             }
             tipoli=tipPoliRec;
         }
         return tipoli;
     }


   //Metodos para ver si el tipo de poliza huro o choque hay mas
     public static String TipoMasComun(Reclamo rec1, Reclamo rec2,
                                        Reclamo rec3){
         int max, ms;
         String muestro;
         max=0;
         ms=0;
         int tiporec1;
         tiporec1=rec1.getTipoDeSin();
         int tiporec2;
         tiporec2=rec2.getTipoDeSin();
         int tiporec3;
         tiporec3=rec3.getTipoDeSin();

         max=comparo(tiporec1);
         ms=comparo(tiporec2);
         max=ms+max;
         ms=comparo(tiporec3);
         max=ms+max;

         if(max>1){
             muestro="Hay mas reclamo de tipo hurto o choque";
         }
         else{
            muestro="Hay mas de las otras o no hay relcamo tipo hurto o "+
                        "choque";
         }

         return muestro;

     }
     
//Metodo de comparacion de Tipo de poliza
     private static int comparo(int tiporec){
         int mas;
         if(tiporec==3||tiporec==4){
             mas=1;
         }
         else{
             mas=0;
         }
         return mas;
     }
     
    //Validacion de los reclamos
     private static String Validacion(Poliza poli, Reclamo rec){
        String vali;
        int tipol;
        tipol=poli.getTipoDePoliza();
        int polM;
        polM=poli.getVencMes();
        int polA;
        polA=poli.getVencAnio();
        int tiprec;
        tiprec=rec.getTipoDeSin();
        int recM;
        recM=rec.getMesAvisoSin();
        int recA;
        recA=rec.getAnioAvisoSin();
        vali=Comparo(tipol, tiprec, polM, polA, recM, recA);        
                
        return vali;
    }

//Metodo de comparacion
 private static String Comparo(int tipoli, int tiprec, int polM,
                                int polA,int recM, int recA){
    String val;
    if(tipoli==6 || tipoli==tiprec && polM==recM && polA==recA){
                 val="Es valido";           
    }
    else{
        val="No es valido";
    }
   
    return val;
    
}

 //Validez de monto
 public static int Monto(int Mes, int Anio, int numpol, Poliza poli,
                             Reclamo rec){
     String los;
     int yo=0;
     int monpoli=poli.getMonto();
     int monrec=rec.getRecMonto();
     los=Validacion(poli, rec);
     //Validar el numplo con el tipo de poliza
     if(los.equals("Es valido") && monrec<=monpoli){
         yo=rec.getRecMonto();

     }
     else{
       }
     return yo;

 }

 //Metodo para sumar el monto
 public static int SumaMonto(Reclamo rec1, int montoRec1,Reclamo rec2,
                           int montoRec2, Reclamo rec3, int montoRec3){
     int montoTot;
     montoRec1=rec1.getRecMonto();
     montoRec2=rec2.getRecMonto();
     montoRec3=rec3.getRecMonto();
     montoTot = montoRec1 + montoRec2 + montoRec3;
     return montoTot;
 }

}

   