package com.example.elmarvin.examesnestest1;

import java.io.Serializable;

/**
 * Created by elmarvin on 13/10/16.
 */

public class Respuesta implements Serializable {

    private String encabezado;
    private boolean estado;
    private boolean elegida;

    public Respuesta(String encabezado, boolean estado) {
        this.encabezado = encabezado;
        this.estado = estado;
        this.elegida = false;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isElegida() {
        return elegida;
    }

    public void setElegida(boolean elegida) {
        this.elegida = elegida;
    }



    @Override
    public String toString() {
        String aux="\""+this.encabezado+"\";";
        if (estado){
            aux=aux+"\"Correcta\";";
        }else{
            aux=aux+"\"Incorrecta\";";
        }
        return aux;
    }
}
