package com.mycompany.estadistica;
import java.util.Scanner;
public class Estadistica {
    private double[] datos;
    public Estadistica(double[] datos){
        this.datos = datos;
    }
    public double promedio(){
        double suma = 0;
        for (double dato : datos){
            suma += dato;
        }
        return suma / datos.length;
    }
    public double desviacion(){
        double promedio = promedio();
        double SumaCuadrados = 0;
        for (double dato : datos){
            SumaCuadrados += Math.pow(dato - promedio, 2);
        }
        return Math.sqrt(SumaCuadrados / (datos.length - 1));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numeros = new double[10];
        System.out.println("Ingrese 10 numeros: ");
        for (int i = 0; i < 10; i++){
            numeros[i] = scanner.nextDouble();
        }
        Estadistica stats = new Estadistica(numeros);
        System.out.printf("El promedio es %.2f%n", stats.promedio());
        System.out.printf("La desviacion estandar es %.5f%n", stats.desviacion());
    }
}
