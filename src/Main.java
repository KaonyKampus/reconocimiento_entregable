import java.util.Arrays;
import java.util.Scanner;


public class Main {
    //Método principal donde siempre ejecuto el código
    public static void main(String[] args) {
        //Se declaran tres variables que guarden los métodos secundarios
        String[] nombres = x();
        double[] notas = y();
        double promedio = promedio(notas);

        //Se imprime solo el promedio del curso
        System.out.printf("El promedio del curso es:  %.2f%n", promedio);

        //se muestra los estudiantes que hayan estado por debajo del promedio
        System.out.println("Los estudiantes con las notas mas bajas son: ");
        estudiantesNoAprobados(nombres, notas, promedio);
    }


    //primer método secundario donde quiero hacer la iteración para los nombres de estudiantes
    public static String[] x() {
        Scanner sc = new Scanner(System.in);
        //declaro una variable para definir la cantidad de datos y un array que tenga como parámetro esa cantidad
        int cantidad = 5;
        String[] nombres = new String[cantidad];
        //Hago un ciclo para preguntar por los 5 datos teniendo como condición la variable cantidad que creamos
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Profesor, introduzca el nombre del estudiante " + (i + 1) + ":");
            nombres[i] = sc.nextLine();
        }
        //retornamos el array que tiene toda la información
        return nombres;
    }

    //segundo método secundario
    public static double[] y() {
        Scanner sc = new Scanner(System.in);
        int cantidad = 5;
        double[] notas = new double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            double nota;
            do {
                System.out.println("Profesor, indique las notas de cada estudiante en orden. Estudiante " + (i + 1) + ":");
                nota = sc.nextDouble();
                if (nota < 1.0 || nota > 10.0) {
                    System.out.println("Profesor, por favor ingrese una nota válida entre 1.0 y 10.0");
                } else {
                    break;
                }
                ;
            } while (nota < 1.0 || nota > 10.0);
            notas[i] = nota;
        }
        return notas;
    }

    //tercer método secundario para hacer el promedio del curso
    public static double promedio(double[] notas) {
        double suma = 0;
        for (double nota : notas) {
            suma = +nota;
        }
        return suma / notas.length;
    }

    //cuarto método para mostrar quienes perdieron
    public static void estudiantesNoAprobados(String[] nombres, double[] notas, double promedio) {
        for (int i = 0; i < nombres.length; i++) {
            if (notas[i] < promedio) {
                System.out.println(nombres[i] + "- Nota: " + notas[i]);
            }
        }
    }
}