package com.mycompany.ecuacioncuadratica;
import java.util.Scanner;
public class EcuacionCuadratica {
    private double a, b, c;
    public EcuacionCuadratica(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminante(){
        return b * b - 4 * a * c;
    }
    public double getRaiz1(){
        double discriminante = getDiscriminante();
        if (discriminante < 0) return 0;
        return (-b + Math.sqrt(discriminante)) / (2 * a);
    }
    public double getRaiz2(){
        double discriminante = getDiscriminante();
        if (discriminante < 0) return 0;
        return (-b - Math.sqrt(discriminante)) / (2 * a);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        EcuacionCuadratica ecuacion = new EcuacionCuadratica(a, b, c);
        double discriminante = ecuacion.getDiscriminante();
        if (discriminante > 0){
            System.out.printf("La ecuacion tine dos raices %.6f y %.6f%n",
                    ecuacion.getRaiz1(), ecuacion.getRaiz2());
        }else if(discriminante == 0){
            System.out.printf("La ecuacion tiene una raiz %.0f%n", ecuacion.getRaiz1());
        }else{
            System.out.println("La ecuacion tiene  raices Reales");
        }
    }
}
