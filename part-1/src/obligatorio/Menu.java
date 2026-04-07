/*
 * Autores: Maria Gimena Czarnievicz y Tomas Gallo
 */
package obligatorio;
import java.util.Scanner;

public class Menu {
public static void main(String[] args) {
   int nump;
   int los;
   nump = -1;
   los = -1;
   Scanner on = new Scanner(System.in);

   while (nump != 3) {
       System.out.println("\n---------------------------------------------"
              + "\nIngrese La opcion Deseada:              "
              + "\n"
              + "\n        1- Ingresar Cliente           "
              + "\n        2- Ingresar los 3 reclamos    "
              + "\n        3- Salir del Menu             "
              + "\n---------------------------------------------");
       nump = on.nextInt();

       switch (nump) {
           case 1:
          //para pedir cliente
             Cliente cli;
             System.out.println("\n Ingrese Cliente                  "
                     + "\n---------------------------------------------");
              cli = MetodosMenu.icliente();
              System.out.println("\nCLIENTE");
              System.out.println(cli);
              break;

           case 2:
           //Ingreso Cliente
             Cliente cli1;
             System.out.println("\nIngrese Cliente                  "
                   + "\n---------------------------------------------");
             cli1 = MetodosMenu.icliente();
             System.out.println(cli1);

          //Ingreso Poliza
              Poliza poli;
              System.out.println("\nIngrese Poliza ");
              poli = MetodosMenu.iPoliza(cli1);
              System.out.println(poli);

         //Ingreso los 3 Rclamos
             Reclamo rec1,
             rec2,
             rec3;
             System.out.println( "\n-----------------------------------"+
                                 "----------"+
                                 "\n    Ingrese el Primer Reclamo");
             rec1 = MetodosMenu.iReclamo(poli);
             System.out.println("-----------------------------------"+
                                 "---------");
             System.out.println(rec1);
             System.out.println("\n-----------------------------------"+
                                "---------"
                               +"\n   Ingrese el Segundo Reclamo");
             rec2 = MetodosMenu.iReclamo(poli);
             System.out.println("-----------------------------------"+
                                 "---------");

             System.out.println("\n-----------------------------------"+
                                "---------"
                               +"\n   Ingrese el Tercer Reclamo");
             rec3 = MetodosMenu.iReclamo(poli);
             System.out.println("-----------------------------------"+
                                 "---------");

        //Para saber que tipo de Poliza hay mas
             System.out.println("\n-----------------------------------"+
                                 "----------"
                          + "\nIngrese La opcion Deseada:           "
                          + "\n   Opcion 1 Mostrar Cliente              "
                          + "\n   Opcion 2 Mostrar la poliza            "
                          + "\n   Opcion 3 Mostrar los 3 reclamos       "
                          + "\n   Opcion 4 Mostrar Si el tipo de "
                          + "\n            reclamo hurto o chouqe hay mas"
                          + "\n   Opcion 5 Consulta de pagos            "
                          + "\n   Opcion 6 Volver al menu anterior      "
                          + "\n-----------------------------------"
                          + "----------");
             los = on.nextInt();

            while (los != 6) {
              switch (los) {
                   case 1:
                //Para Mostrar cliente
                    System.out.println(cli1);
                    break;

                   case 2:
                //Muestro la poliza
                    System.out.println(poli);
                    break;

                  case 3:
               //mostrar los 3 reclamos con los datos
                    System.out.println(rec1);
                    System.out.println(rec2);
                    System.out.println(rec3);
                    break;

                   case 4:
               //mostrar si hay mas reclamso de tipo huerto y choque
                    System.out.println(MetodosMenu.TipoMasComun(rec1,
                                               rec2, rec3));
                    break;

                    case 5:
                    // consulta de pagos
                    int ingMes,
                    ingAnio,
                    ingTip;
                    System.out.println("\n-------------------------" +
                                          "----------------------"
                                          + "\nIngrese un Mes  ");

                    ingMes = MetodosMenu.PedirNum(1, 12, "Mes");
                    System.out.println("\n------------------------" +
                                         "-----------------------"
                                            + "\nIngrese Año");
                    ingAnio = MetodosMenu.PedirNum(2000, 2030, "Anio");

                    System.out.println("\n------------------------" +
                                          "------------------------");
                     System.out.println("\n•Ingrese Tipo de Poliza:  "+
                           "\n      1-Responsabilidad Civil          "+
                           "\n      2-Incendio                       "+
                           "\n      3-Hurto                          "+
                           "\n      4-Choque                         "+
                           "\n      5-Vandelismo                     "+
                           "\n      6-Seguro Total                   "+
                           "\n---------------------------------------"+
                           "------");
                    ingTip = MetodosMenu.PedirNum(1, 6,
                                           "tipo de poliza");

                    //Para mostrar la suma Total a Reclamar
                    int montoRec1;
                    int montoRec2;
                    int montoRec3;
                    montoRec1 = MetodosMenu.Monto(ingMes, ingAnio,
                                                 ingTip, poli, rec1);
                    montoRec2 = MetodosMenu.Monto(ingMes, ingAnio,
                                                  ingTip, poli, rec2);
                    montoRec3 = MetodosMenu.Monto(ingMes, ingAnio,
                                                  ingTip, poli, rec3);

                    System.out.println("La suma total a reclamar" +
                                   " es de $ "
                            +MetodosMenu.SumaMonto(rec1, montoRec1,
                                rec2, montoRec2, rec3, montoRec3));
                    break;

                 case 6:
                //Volver al menu anterior
               break;


               }

     System.out.println("\n-----------------------------------"+
                        "---------"
                      + "\n Ingrese La opcion desiada           "
                      + "\n   Opcion 1 Mostrar Cliente            "
                      + "\n   Opcion 2 Mostrar la poliza          "
                      + "\n   Opcion 3 Mostrar los 3 reclamos     "
                      + "\n   Opcion 4 Mostrar Si el tipo de "
                      + "\n            reclamo hurto o chouqe hay mas"
                      + "\n   Opcion 5 Consulta de pagos          "
                      + "\n   Opcion 6 Volver al menu anterior    "
                      + "\n-----------------------------------"+
                        "---------");
    los = MetodosMenu.PedirNum(1, 6, "Una opcion");

    }
    break;

  case 3:
 //terminado
    break;

  default:
// ingrese nuevamente

            }
        }
    }
}


