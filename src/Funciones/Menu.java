package Funciones;

import Funciones.Funciones;
import java.util.Scanner;

public class Menu {
    public int Menu(){
        /*Se debe hacer un menu ́ para el sistema con las siguientes funcionalidades: (1) 
        Agregar (Create Elemento (s)), (2)
        Mostrar por pantalla listado de elementos, para cada una de las dos colecciones anidadas.*/
        int Opcion;
        Funciones prueba = new Funciones();
        Scanner Entrada= new Scanner(System.in);
        System.out.println("BIENVENIDO A ...");
        System.out.println("1.- Agregar un elemento");        
        System.out.println("2.- Mostrar elementos");
        System.out.println("3.- Generar Reporte");
        System.out.println("4.- Terminar Programa");
        Opcion=Entrada.nextInt();
        if(Opcion==1){
            System.out.println("¿Qué desea agregar?");
            System.out.println("1.- Alumno");
            System.out.println("2.- Profesor");
            System.out.println("3.- Curso");
            System.out.println("4.- Oferta Laboral");
            Opcion=Entrada.nextInt();
            switch(Opcion)
            {    
                case 1 : return 1;
                case 2 : return 2;
                case 3 : return 3;
                case 4 : return 4;
            }
        }
        else if(Opcion==2){
            System.out.println("¿Qué desea imprimir?");
            System.out.println("1.- Listado de alumnos");
            System.out.println("2.- Listado de profesores");
            System.out.println("3.- Listado de cursos");
            System.out.println("4.- Listado de Ofertas Laborales");
            Opcion=Entrada.nextInt();
            switch(Opcion)
            {    
                case 1 : return 5;
                case 2 : return 6;
                case 3 : return 7;
                case 4 : return 8;
            }
        }
        else if (Opcion==3){
            System.out.println("¿Qué desea Generar Reporte?");
            System.out.println("1.- Reporte de Curso");
            System.out.println("2.- Reporte de Profesor");
            System.out.println("3.- Reporte de Estudiante");
            Opcion=Entrada.nextInt();
            switch(Opcion)
            {    
                case 1 : return 9;
                case 2 : return 10;
                case 3 : return 11;
            }
            
        }
        else if (Opcion==4){
            return 12;
        }
        else{
            System.out.println("OPCIÓN INCORRECTA");
        }
        return 13;
    }
}
