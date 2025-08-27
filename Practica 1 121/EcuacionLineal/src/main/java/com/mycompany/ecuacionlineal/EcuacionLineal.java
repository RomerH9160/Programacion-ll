package com.mycompany.ecuacionlineal;
import java.util.Scanner;
public class EcuacionLineal {
    private double a, b, c, d, e, f;
    public EcuacionLineal(double a, double b, double c, double d, double e, double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    public boolean TieneSolucion(){
        return (a * b - b * c) != 0;
    }
    public double getX(){
        return (a * d - b * f)/(a * b - b * c);
    }
    public double getY(){
        return (a * f - e * c)/(a * d - b * c);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese a, b, c, d, e, f: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        double e = scanner.nextDouble();
        double f = scanner.nextDouble();
        EcuacionLineal ecu = new EcuacionLineal(a, b, c, d, e, f);
        if (ecu.TieneSolucion()){
            System.out.printf("x = %.1f, y = %.1f%n", ecu.getX(), ecu.getY());
        } else {
            System.out.println("La ecuacion no tiene soluciones");
        }
    }
}
