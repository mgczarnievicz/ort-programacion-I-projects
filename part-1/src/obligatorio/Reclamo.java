/*
 * Autores: Maria Gimena Czarnievicz y Tomas Gallo
 */

package obligatorio;
public class Reclamo {
    private Poliza poliza;
    private int diaSin;
    private int mesSin;
    private int anioSin;
    private int diaAvisoSin;
    private int mesAvisoSin;
    private int anioAvisoSin;
    private int tipoDeSin;
    private int recMonto;   
 

     //set y get del Dia siniestro
    public int getDiaSin() {
        return diaSin;
    }

    public void setDiaSin(int unDiaSin) {
        this.diaSin = unDiaSin;
    }


   //set y get del Mes siniestro
    public int getMesSin() {
        return mesSin;
    }

    public void setMesSin(int unMesSin) {
        this.mesSin = unMesSin;
    }
    
     
    //set y get del Anio siniestro
    public int getAnioSin() {
        return anioSin;
    }

    public void setAnioSin(int unAnioSin) {
        this.anioSin = unAnioSin;
    }
    
    
    //set y get del dia AVISO siniestro
    public int getDiaAvisoSin() {
        return diaAvisoSin;
    }

    public void setDiaAvisoSin(int unDiaAvisoSin) {
        this.diaAvisoSin = unDiaAvisoSin;
    }


     //set y get del Mes AVISO del siniestro
    public int getMesAvisoSin() {
        return mesAvisoSin;
    }

    public void setMesAvisoSin(int unMesAvisoSin) {
        this.mesAvisoSin = unMesAvisoSin;
    }


    //set y get del Anio AVISO del siniestro
    public int getAnioAvisoSin() {
        return anioAvisoSin;
    }

    public void setAnioAvisoSin(int unAnioAvisoSin) {
        this.anioAvisoSin = unAnioAvisoSin;
    }


     //set y get de la poliza
    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza unPoliza) {
        this.poliza = unPoliza;
    }


     //set y get del tipo de siniestro
    public int getTipoDeSin() {
        return tipoDeSin;
    }

    public void setTipoDeSin(int unTipoDeSin) {
        this.tipoDeSin = unTipoDeSin;
    }
     

     //set y get del Monto a Reclamar
    public int getRecMonto() {
        return recMonto;
    }

    public void setRecMonto(int unRecMonto) {
        this.recMonto = unRecMonto;
    }


//creacion del toString//
 @Override
 public String toString(){
     return  "\n--------------------------------------------"+
             "\nRECLAMO"+
             "\n•Tipo de Poliza: " +getTipoDeSin()+
             "\n•Fecha del Siniestro: " +getDiaSin()+"/"+getMesSin()+
                                                   "/"+ getAnioSin()+
             "\n•Fecha de Aviso del Siniestro: "   +getDiaAvisoSin()+
                          "/"+getMesAvisoSin()+"/"+getAnioAvisoSin()+
             "\n•Monto relamado: $"+getRecMonto()+
             "\n--------------------------------------------";
    }

 public Reclamo (){
        this.setPoliza(poliza);
        this.setTipoDeSin(tipoDeSin);
        this.setDiaSin(diaSin);
        this.setMesSin(mesSin);
        this.setAnioSin(anioSin);
        this.setDiaAvisoSin(diaAvisoSin);
        this.setMesAvisoSin(mesAvisoSin);
        this.setAnioAvisoSin(anioAvisoSin);
        this.setRecMonto(recMonto);


}
}
