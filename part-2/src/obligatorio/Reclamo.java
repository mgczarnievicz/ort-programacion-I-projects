/*
 * Autores: Maria Gimena Czarnievicz y Tomas Manuel Gallo
 */
package obligatorio;

public class Reclamo implements Comparable<Reclamo> {

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

    @Override
    public int compareTo(Reclamo unRec) {
        //Primero Ordeno por nombre
        int salida;
        if (this.getPoliza().getCliente().getNombre().compareToIgnoreCase(unRec.getPoliza().getCliente().getNombre()) == 0) {
            //Comparo los Anios
            if (this.getAnioSin() == unRec.getAnioSin()) {
                //Comparo los Mese
                if (this.getMesSin() == unRec.getMesSin()) {
                    //Compro Los Dias
                    if (this.getDiaSin() == unRec.getDiaSin()) {
                        salida = 0;
                    } else if (this.getDiaSin() > unRec.getDiaSin()) {
                        salida = -1;
                    } else {
                        salida = 1;
                    }
                } else if (this.getMesSin() > unRec.getMesSin()) {
                    salida = -1;
                } else {
                    salida = 1;
                }
            } else if (this.getAnioSin() > unRec.getAnioSin()) {
                salida = -1;
            } else {
                salida = 1;
            }
        } else if (this.getPoliza().getCliente().getNombre().compareToIgnoreCase(unRec.getPoliza().getCliente().getNombre()) > 0) {
            salida = -1;
        } else {
            salida = 1;
        }
        return salida;

    }

//creacion del toString//
    @Override
    public String toString() {
        return "\n------------------------------------------------"
                + "\nRECLAMO"
                +getPoliza()
                + "\n•Tipo de Poliza: " + getTipoDeSin()
                + "\n•Fecha del Siniestro: " + getDiaSin() + "/" + getMesSin()
                + "/" + getAnioSin()
                + "\n•Fecha de Aviso del Siniestro: " + getDiaAvisoSin()
                + "/" + getMesAvisoSin() + "/" + getAnioAvisoSin()
                + "\n•Monto relamado: $" + getRecMonto()
                + "\n------------------------------------------------";
    }

    public Reclamo(Poliza p,int tipoDeSin,int diaSin,int mesSin, int anioSin, int diaAvisoSin, int mesAvisoSin, int anioAvisoSin, int recMonto) {

        this.setPoliza(p);
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
