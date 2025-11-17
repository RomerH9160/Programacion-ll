/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.teleferico;

/**
 *
 * @author HP
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Teleferico {
    public class Persona {
        private String nombre;
        private int edad;
        private double pesoPersona;

    public Persona(String nombre, int edad, double pesoPersona) {
        this.nombre = nombre;
        this.edad = edad;
        this.pesoPersona = pesoPersona;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public double getPesoPersona() { return pesoPersona; }

    public boolean esPreferencial() { return edad < 25 || edad >= 60;}

    @Override
    public String toString() {
        return nombre + " (edad:" + edad + ", peso:" + pesoPersona + ")";
    }

    public class Cabina {
        private int nroCabina;
        private List<Persona> personasABordo;

        public static final int MAX_PERSONAS = 10;
        public static final double MAX_PESO = 850.0;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasABordo = new ArrayList<>();
    }

    public int getNroCabina() { return nroCabina; }

    public List<Persona> getPersonasABordo() { return personasABordo; }

    public boolean puedeAgregarPersona(Persona p) {
        if (personasABordo.size() >= MAX_PERSONAS) return false;
        double pesoActual = pesoTotal();
        return (pesoActual + p.getPesoPersona()) <= MAX_PESO;
    }

    public boolean agregarPersona(Persona p) {
        if (puedeAgregarPersona(p)) {
            personasABordo.add(p);
            return true;
        }
        return false;
    }

    public int cantidadPersonas() { return personasABordo.size(); }

    public double pesoTotal() {
        double s = 0.0;
        for (Persona p : personasABordo) s += p.getPesoPersona();
        return s;
    }

    @Override
    public String toString() {
        return "Cabina#" + nroCabina + " personas=" + personasABordo.size() + " peso=" + pesoTotal();
    }
    }
     public class Linea {
        private String color;
        private Queue<Persona> filaPersonas; // fila de espera
        private List<Cabina> cabinas;
        private int cantidadCabinas; // según diagrama

        public Linea(String color) {
        this.color = color;
        this.filaPersonas = new LinkedList<>();
        this.cabinas = new ArrayList<>();
        this.cantidadCabinas = 0;
    }

    public String getColor() { return color; }

    public void agregarPersonaFila(Persona p) {
        if (p != null) filaPersonas.add(p);
    }

    public Persona sacarPrimeraDeFila() {
        return filaPersonas.poll();
    }

    public void agregarCabina(int nroCabina) {
        Cabina c = new Cabina(nroCabina);
        cabinas.add(c);
        cantidadCabinas = cabinas.size();
    }

    public List<Cabina> getCabinas() { return cabinas; }

    public Queue<Persona> getFilaPersonas() { return filaPersonas; }

    public int getCantidadCabinas() { return cantidadCabinas; }

    // buscar cabina por número
    public Cabina obtenerCabinaPorNumero(int nro) {
        for (Cabina c : cabinas) {
            if (c.getNroCabina() == nro) return c;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Linea " + color + " cabinas=" + cabinas.size() + " fila=" + filaPersonas.size();
    }
    }
     
    public class Linea {
        private String color;
        private Queue<Persona> filaPersonas; // fila de espera
        private List<Cabina> cabinas;
        private int cantidadCabinas; // según diagrama

        public Linea(String color) {
        this.color = color;
        this.filaPersonas = new LinkedList<>();
        this.cabinas = new ArrayList<>();
        this.cantidadCabinas = 0;
    }

    public String getColor() { return color; }

    public void agregarPersonaFila(Persona p) {
        if (p != null) filaPersonas.add(p);
    }

    public Persona sacarPrimeraDeFila() {
        return filaPersonas.poll();
    }

    public void agregarCabina(int nroCabina) {
        Cabina c = new Cabina(nroCabina);
        cabinas.add(c);
        cantidadCabinas = cabinas.size();
    }

    public List<Cabina> getCabinas() { return cabinas; }

    public Queue<Persona> getFilaPersonas() { return filaPersonas; }

    public int getCantidadCabinas() { return cantidadCabinas; }

    // buscar cabina por número
    public Cabina obtenerCabinaPorNumero(int nro) {
        for (Cabina c : cabinas) {
            if (c.getNroCabina() == nro) return c;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Linea " + color + " cabinas=" + cabinas.size() + " fila=" + filaPersonas.size();
    }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

    public class Main {
        public static void main(String[] args) {
            MiTeleferico mt = new Teleferico();

            // Crear cabinas para cada linea
            mt.agregarCabina("Amarillo", 1);
            mt.agregarCabina("Amarillo", 2);
            mt.agregarCabina("Rojo", 1);
            mt.agregarCabina("Verde", 1);
            mt.agregarCabina("Verde", 2);

            // Agregar personas a las filas (mezcla de edades y pesos)
            mt.agregarPersonaFila(new Persona("Ana", 20, 60.0), "Amarillo");   // preferencial
            mt.agregarPersonaFila(new Persona("Luis", 30, 80.0), "Amarillo");  // regular
            mt.agregarPersonaFila(new Persona("Marta", 65, 55.0), "Amarillo"); // preferencial
            mt.agregarPersonaFila(new Persona("Pablo", 40, 90.0), "Rojo");     // regular
            mt.agregarPersonaFila(new Persona("Sofia", 22, 55.0), "Verde");    // preferencial
            mt.agregarPersonaFila(new Persona("Diego", 27, 85.0), "Verde");    // regular

            // a) Agregar la primera persona de la fila a la cabina nroX
            boolean agregado = mt.agregarPrimeraPersonaACabina("Amarillo", 1);
            System.out.println("Se agregó primera persona a cabina Amarillo#1 ? " + agregado);

            // repetir para llenar un poco más
            mt.agregarPrimeraPersonaACabina("Amarillo", 1); // intenta agregar siguiente Ana->Luis
            mt.agregarPrimeraPersonaACabina("Amarillo", 2); // next Marta -> cabina 2

            mt.agregarPrimeraPersonaACabina("Rojo", 1);
            mt.agregarPrimeraPersonaACabina("Verde", 1);
            mt.agregarPrimeraPersonaACabina("Verde", 2);

            // b) Verificar reglas de abordo
            System.out.println("\nVerificando reglas de abordo:");
            var errores = mt.verificarReglasAbordo();
            if (errores.isEmpty()) {
                System.out.println("Todas las cabinas cumplen las reglas.");
            } else {
                System.out.println("Errores encontrados:");
                errores.forEach(System.out::println);
            }

            // c) Calcular ingreso total
            double ingresoTotal = mt.calcularIngresoTotal();
            System.out.println("\nIngreso total de todas las líneas: " + ingresoTotal + " Bs");

            // d) Línea con más ingreso solo con tarifa regular
            Linea lineaMejor = mt.lineaConMasIngresoRegular();
            if (lineaMejor != null) {
                System.out.println("Linea con más ingreso POR TARIFA REGULAR: " + lineaMejor.getColor());
            } else {
                System.out.println("No hay ingresos regulares.");
            }

            // mostrar estado final
            System.out.println("\nEstado final de lineas y cabinas:");
            for (Linea l : mt.getLineas()) {
                System.out.println(l);
                for (Cabina c : l.getCabinas()) {
                    System.out.println("  " + c);
                    for (Persona p : c.getPersonasABordo()) {
                        System.out.println("    - " + p + (p.esPreferencial() ? " (pref)" : " (reg)"));
                    }
                }
            }
        }
    }

    }
    }
}