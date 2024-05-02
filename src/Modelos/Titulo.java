package Modelos;

import Excepciones.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

public class Titulo {

    private String nombre;
    private int fechaLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;

    private int totalDeLasEvaluaciones;

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaLanzamiento = Integer.valueOf(miTituloOmdb.year());
        if (miTituloOmdb.runtime().contains("N/A")){
            throw new ErrorEnConversionDeDuracionException("No pude convertir la duracion, porque contiene un N/A");
        }
        this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().substring(0,3).replace(" ",""));
    }


    public void muestraFichaTecnica(){
        System.out.println("El nombre de la pelicula es: "+ nombre);
        System.out.println("Su fecha de lanzamiento es: "+ fechaLanzamiento);
        System.out.println("La duracion es minutos es: "+ getDuracionEnMinutos());


    }

    public void evalua(double nota){
        sumaDeLasEvaluaciones = sumaDeLasEvaluaciones + nota;
        totalDeLasEvaluaciones++;

    }

    public double calculaMedia(){
        return sumaDeLasEvaluaciones /totalDeLasEvaluaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public double getSumaDeLasEvaluaciones() {
        return sumaDeLasEvaluaciones;
    }

    public int getTotalDeLasEvaluaciones() {
        return totalDeLasEvaluaciones;
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", duracion=" + duracionEnMinutos +
                '}';
    }
}
