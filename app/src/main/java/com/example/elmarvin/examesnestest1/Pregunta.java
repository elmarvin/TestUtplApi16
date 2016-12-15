package com.example.elmarvin.examesnestest1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elmarvin on 13/10/16.
 */

public class Pregunta implements Serializable{

    private String encabezado;
    private List<Respuesta> respuestas;

    public Pregunta(String encabezado) {
        this.encabezado = encabezado;
        this.respuestas = new ArrayList<>();
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public void addRespueta(Respuesta r){
        this.respuestas.add(r);
    }

    public int getNroRespuestas(){
        return this.respuestas.size();
    }

    public Respuesta getRespuestaNro(int n){
        return this.respuestas.get(n);
    }

    @Override
    public String toString() {
        String aux = "\""+this.encabezado+"\";";
        for (Respuesta r: this.respuestas){
            if (r.isElegida()){
                aux=aux+r.toString();
            }
        }
        return aux;
    }
}
