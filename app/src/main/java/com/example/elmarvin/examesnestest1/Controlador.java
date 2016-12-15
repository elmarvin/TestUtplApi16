package com.example.elmarvin.examesnestest1;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elmarvin on 13/10/16.
 */

public class Controlador implements Serializable{

    private String cedula;
    private List<Pregunta> preguntas;
    private int pregunta_actual;
    private double calificacion_cuantitativa;
    private String calificacion_cualitativa;
    private int positivas;
    private int negativas;
    private int nosabe;
    private static final String DEFICIENTE = "DEFICIENTE";
    private static final String REGULAR = "REGULAR";
    private static final String BUENO = "BUENO";

    public Controlador() {
        this.cedula = "";
        this.preguntas = new ArrayList<>();
        this.pregunta_actual = 0;
        this.calificacion_cuantitativa = 0;
        this.positivas = 0;
        this.negativas = 0;
        this.nosabe = 0;
        this.calificacion_cualitativa = "hola";
        this.testAritmetico();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public int getPregunta_actual() {
        return pregunta_actual;
    }

    public void setPregunta_actual(int pregunta_actual) {
        this.pregunta_actual = pregunta_actual;
    }

    public double getCalificacion_cuantitativa() {
        this.calificacion_cuantitativa = (positivas*10)/Double.valueOf(nroPreguntas());
        return calificacion_cuantitativa;
    }

    public String getCalificacion_cuantitativa_string() {
        this.calificacion_cuantitativa = (positivas*10)/Double.valueOf(nroPreguntas());
        if(String.valueOf(this.calificacion_cuantitativa).length()>4){
            return String.valueOf(this.calificacion_cuantitativa).substring(0,3);
        }else{
            return String.valueOf(this.calificacion_cuantitativa);
        }
    }

    public void setCalificacion_cuantitativa(double calificacion_cuantitativa) {
        this.calificacion_cuantitativa = calificacion_cuantitativa;
    }

    public String getCalificacion_cualitativa() {
        if (getCalificacion_cuantitativa()<4){
            this.calificacion_cualitativa=DEFICIENTE;

        }
        if (getCalificacion_cuantitativa()>=4 & getCalificacion_cuantitativa()<8){
            this.calificacion_cualitativa=REGULAR;

        }
        if (getCalificacion_cuantitativa()>=8){
            this.calificacion_cualitativa=BUENO;

        }
        return this.calificacion_cualitativa;
    }

    public void setCalificacion_cualitativa(String calificacion_cualitativa) {
        this.calificacion_cualitativa = calificacion_cualitativa;
    }

    public int getPositivas() {
        return positivas;
    }

    public void setPositivas(int positivas) {
        this.positivas = positivas;
    }

    public void setMasUnoPositivas() {
        this.positivas = positivas+1;
    }

    public void setMasUnoNegativas() {
        this.negativas = negativas+1;
    }

    public void setNegativas(int negativas) {
        this.negativas = negativas;
    }

    public int getNegativas() {
        return negativas;
    }

    public int getNosabe() {
        return nosabe;
    }

    public void setNosabe(int nosabe) {
        this.nosabe = nosabe;
    }

    public void setMasUnoNoSabe() {
        this.nosabe = nosabe+1;
    }

    public void setMasUnoPreguntaActual(){
        this.pregunta_actual = this.pregunta_actual+1;
    }

    public void addPregunta(Pregunta p){
        this.preguntas.add(p);
    }

    public Pregunta getPreguntaNro(int n){
        return this.preguntas.get(n);
    }

    public int nroPreguntas(){ return this.preguntas.size(); }

    public Pregunta getPreguntaActual(){
        return this.preguntas.get(this.pregunta_actual);
    }

    public void testAritmetico(){
        Pregunta p0 = new Pregunta("¿Qué número es 30% de 75?");
        p0.addRespueta(new Respuesta("45", false));
        p0.addRespueta(new Respuesta("22,50", true));
        p0.addRespueta(new Respuesta("0,4", false));
        p0.addRespueta(new Respuesta("75,3", false));
        p0.addRespueta(new Respuesta("Ninguna", false));
        p0.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p0);

        Pregunta p1 = new Pregunta("En una aula de cuarto grado el profesor realiza 8 grupos de tres alumnos en cada uno y sobran dos alumnos del total. ¿Cuántos alumnos hay en el aula?");
        p1.addRespueta(new Respuesta("26", true));
        p1.addRespueta(new Respuesta("24", false));
        p1.addRespueta(new Respuesta("6", false));
        p1.addRespueta(new Respuesta("16", false));
        p1.addRespueta(new Respuesta("Ninguna", true));
        p1.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p1);

        Pregunta p2 = new Pregunta("Cuando Carlos nació, su hermano Miguel tenía 5 años, ¿después de cuántos años la suma de las edades de ellos dos es 19 años?");
        p2.addRespueta(new Respuesta("24", false));
        p2.addRespueta(new Respuesta("5", false));
        p2.addRespueta(new Respuesta("19", false));
        p2.addRespueta(new Respuesta("7", true));
        p2.addRespueta(new Respuesta("Ninguna", false));
        p2.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p2);

        Pregunta p3 = new Pregunta("Si Manuel hace tres años tenía 15 años, ¿cuántos tendrá dentro de 8 años?");
        p3.addRespueta(new Respuesta("3", false));
        p3.addRespueta(new Respuesta("15", false));
        p3.addRespueta(new Respuesta("8", false));
        p3.addRespueta(new Respuesta("26", true));
        p3.addRespueta(new Respuesta("Ninguna", false));
        p3.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p3);

        Pregunta p4 = new Pregunta("¿Qué número nos resulta de sumar 4 con su mitad y con el doble de su mitad?");
        p4.addRespueta(new Respuesta("4", false));
        p4.addRespueta(new Respuesta("2", false));
        p4.addRespueta(new Respuesta("10", true));
        p4.addRespueta(new Respuesta("8", false));
        p4.addRespueta(new Respuesta("Ninguna", false));
        p4.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p4);

        Pregunta p5 = new Pregunta("¿Cuál es el resultado de multiplicar 6 por su doble?");
        p5.addRespueta(new Respuesta("6", false));
        p5.addRespueta(new Respuesta("12", false));
        p5.addRespueta(new Respuesta("36", false));
        p5.addRespueta(new Respuesta("72", true));
        p5.addRespueta(new Respuesta("Ninguna", false));
        p5.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p5);

        Pregunta p6 = new Pregunta("¿Cuál es el resultado de sumar 6 con su tercera parte y el triple de su tercera parte?");
        p6.addRespueta(new Respuesta("14", true));
        p6.addRespueta(new Respuesta("6", false));
        p6.addRespueta(new Respuesta("2", false));
        p6.addRespueta(new Respuesta("18", false));
        p6.addRespueta(new Respuesta("Ninguna", false));
        p6.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p6);

        Pregunta p7 = new Pregunta("¿A la edad que tiene Rosita se le multiplica por 5, y a este resultado se le agrega 3. Si al dividir esta última suma entre 2 se obtiene 19. ¿Cuál es la edad  de Rosita?");
        p7.addRespueta(new Respuesta("5", false));
        p7.addRespueta(new Respuesta("2", false));
        p7.addRespueta(new Respuesta("3", false));
        p7.addRespueta(new Respuesta("7", true));
        p7.addRespueta(new Respuesta("Ninguna", true));
        p7.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p7);

        Pregunta p8 = new Pregunta("¿Si 40 libros cuestan lo mismo que 20 cuadernos, y 18 lápices lo mismo que 4 borradores, ¿cuántos cuadernos nos pueden dar por 60 lápices, si el precio de 30 libros equivale a 40 borradores?");
        p8.addRespueta(new Respuesta("5", true));
        p8.addRespueta(new Respuesta("40", false));
        p8.addRespueta(new Respuesta("10", false));
        p8.addRespueta(new Respuesta("15", false));
        p8.addRespueta(new Respuesta("Ninguna", false));
        p8.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p8);

        Pregunta p9 = new Pregunta("¿Milagros pagó 8750 $ por un automóvil, 830 $ por cambio de llantas y 200 $ por afinarlo. Después lo alquiló durante dos años a razón de 1500 $ por trimestre, y luego lo vendió por 7750 $. ¿Cuánto ganó Milagros?");
        p9.addRespueta(new Respuesta("7750", false));
        p9.addRespueta(new Respuesta("268", false));
        p9.addRespueta(new Respuesta("9970", true));
        p9.addRespueta(new Respuesta("6750", false));
        p9.addRespueta(new Respuesta("Ninguna", false));
        p9.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p9);

        Pregunta p10 = new Pregunta("Un empleado ha sido contratado por 15 meses, tiempo por el cual se le ha ofrecido pagar $3240 y un televisor. Cumplidos los ocho meses, el empleado renunció al trabajo, y recibió como paga $1560 y el televisor. ¿En cuánto estaba valorizado el televisor?");
        p10.addRespueta(new Respuesta("400", false));
        p10.addRespueta(new Respuesta("250", false));
        p10.addRespueta(new Respuesta("360", true));
        p10.addRespueta(new Respuesta("415", false));
        p10.addRespueta(new Respuesta("Ninguna", false));
        p10.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p10);

        Pregunta p11 = new Pregunta("En un distrito de Arequipa que tiene 40'000 habitantes, un camión cisterna reparte 20 litros de  agua por segundo. Averigüe cuánto recibirá de agua cada habitante en un día");
        p11.addRespueta(new Respuesta("41.3", false));
        p11.addRespueta(new Respuesta("43.2", true));
        p11.addRespueta(new Respuesta("42.3", false));
        p11.addRespueta(new Respuesta("40.1", false));
        p11.addRespueta(new Respuesta("Ninguna", false));
        p11.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p11);

        Pregunta p12 = new Pregunta("En una ferretería tienen un stock de 84m de alambre, y diario cortan 7m. ¿En cuántos días habrán cortado todo el alambre?");
        p12.addRespueta(new Respuesta("11", true));
        p12.addRespueta(new Respuesta("12", false));
        p12.addRespueta(new Respuesta("9", false));
        p12.addRespueta(new Respuesta("7", false));
        p12.addRespueta(new Respuesta("Ninguna", false));
        p12.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p12);

        Pregunta p13 = new Pregunta("Andrea, Braulio, Carlos, Dante y Esteban están sentados formando una ronda, en el orden indicado. Andrea dice el número 53, Braulio el 52, Carlos el 51, Dante el 50, y así sucesivamente. ¿Quién dice el numero 1?");
        p13.addRespueta(new Respuesta("Andrea", false));
        p13.addRespueta(new Respuesta("Braulio", false));
        p13.addRespueta(new Respuesta("Esteban", false));
        p13.addRespueta(new Respuesta("Carlos", true));
        p13.addRespueta(new Respuesta("Ninguna", false));
        p13.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p13);

        Pregunta p14 = new Pregunta("Pedro vive a 200 km de su lugar de trabajo. Prevé salir de casa a las 9 horas y conducir a la velocidad de 50 km/hora. ¿A qué hora llegará al trabajo?");
        p14.addRespueta(new Respuesta("10h00", false));
        p14.addRespueta(new Respuesta("13h00", true));
        p14.addRespueta(new Respuesta("19h00", false));
        p14.addRespueta(new Respuesta("22h00", false));
        p14.addRespueta(new Respuesta("Ninguna", false));
        p14.addRespueta(new Respuesta("No entiende", false));
        this.addPregunta(p14);
    }

    public void guardarControlador2(){
        try
        {
            File ruta_sd_global = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
            //File ruta_sd_app_musica = getExternalFilesDir(Environment.DIRECTORY_MUSIC);

            File f = new File(ruta_sd_global.getAbsolutePath(), "prueba_sd.txt");

            BufferedWriter bw;
                bw = new BufferedWriter(new FileWriter(f, true));
                bw.write(this.toString()+"\n");
                bw.close();
            Log.i("Ficheros", "Fichero SD creado!");
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", ex.getLocalizedMessage());
        }
    }

    public void guardarControladorPrueba(){

        try
        {
            File ruta_sd_global = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
            //File ruta_sd_app_musica = getExternalFilesDir(Environment.DIRECTORY_MUSIC);

            File f = new File(ruta_sd_global.getAbsolutePath(), "test.csv");

            OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));

            fout.write(this.toString());

            fout.close();

            Log.i("Ficheros", "Fichero SD creado!");
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", ex.getLocalizedMessage());
        }

    }

    @Override
    public String toString() {
        String aux = "\""+this.cedula+"\";";
        for (Pregunta p : this.preguntas) {
            aux=aux+p.toString();
        }
        aux=aux+"\""+getPositivas()+"\";"
                +"\""+getNegativas()+"\";"
                +"\""+getNosabe()+"\";"
                +"\""+getCalificacion_cuantitativa()+"\";"
                +"\""+getCalificacion_cualitativa()+"\"\n";
        return aux;
    }
}
