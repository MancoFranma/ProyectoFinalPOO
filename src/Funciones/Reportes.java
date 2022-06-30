/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Clases.Curso;
import Clases.Estudiante;
import Clases.OfertaLaboral;
import Clases.Profesor;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author franm
 */
public class Reportes {
    
    public void GenerarReporteCurso(Curso ListaCursos,Estudiante ListaEstudiantes,Profesor ListaProfesores,OfertaLaboral ListaOfertas){
        Scanner Entrada= new Scanner(System.in);
        int Opcion ;
        System.out.println("Generar el reporte del curso:");
        for(int i = 0 ; i < ListaCursos.Cursos.size();i++){
            System.out.println(i + 1 + ": "  +ListaCursos.Cursos.get(i).getNombre());
        }
        System.out.println(ListaCursos.Cursos.size());
        Opcion = Entrada.nextInt();
        if(Opcion - 1 > ListaCursos.Cursos.size() ){
            System.out.println("Opcion Ingresada no es valida");
            return ;
        }
        try{
            String Ruta = "./Reportes/Curso_"+ListaCursos.Cursos.get(Opcion-1).getNombre()+".txt";
            File file = new File(Ruta);
            if (!file.exists()) {
                    file.createNewFile();
            }
            PrintWriter printWriter = new PrintWriter("./Reportes/Curso_"+ListaCursos.Cursos.get(Opcion-1).getNombre()+".txt");
            printWriter.println("Nombre del Curso: " + ListaCursos.Cursos.get(Opcion).getNombre());
            printWriter.println("Categoria del Curso: " + ListaCursos.Cursos.get(Opcion).getCategoria());
            printWriter.println("Clave del Curso: " + ListaCursos.Cursos.get(Opcion).getClaveCurso());
            printWriter.println("Fecha Inicio del Curso: " + ListaCursos.Cursos.get(Opcion).getFechaInicio());
            printWriter.println("Fecha Termino del Curso: " + ListaCursos.Cursos.get(Opcion).getFechaTermino());
            int x = 1 , y = 1 ;
            printWriter.println("");
            printWriter.println("Profesores que imparten el curso:");
            for(int j=0;j<ListaProfesores.Profesores.size();j++){
                for(int l=0;l<ListaProfesores.Profesores.get(j).getSize();l++){
                    if(ListaProfesores.Profesores.get(j).getCursos(l).equals(ListaCursos.Cursos.get(Opcion).getNombre())){
                        printWriter.print(y + ")\n" + ListaProfesores.Profesores.get(Opcion).DarDatos(1));
                        printWriter.println(" ");
                        y++;
                    }
                }
            }
            if(y==1)
                printWriter.println("NO HAY PROFESORES EN ESTE CURSO"); 
            printWriter.println("");
            printWriter.println("Alumnos del curso:");
            for(int j=0;j<ListaEstudiantes.Estudiantes.size();j++){
                for(int l=0; l<ListaEstudiantes.Estudiantes.get(j).getSizeCursosMatriculados();l++){
                    if(ListaEstudiantes.Estudiantes.get(j).getCursosMatriculados().get(l).getNombre().equals(ListaCursos.Cursos.get(Opcion).getNombre())){
                        printWriter.println(x + ")\n Nombre: " + ListaEstudiantes.Estudiantes.get(j).getNombre());
                        printWriter.println(" Apellido: " + ListaEstudiantes.Estudiantes.get(j).getApellido());
                        printWriter.println(" Rut: " + ListaEstudiantes.Estudiantes.get(j).getRut());
                        printWriter.println(" Mail: " + ListaEstudiantes.Estudiantes.get(j).getMail());
                        printWriter.println(" ");
                        x=x+1;
                    }
                }
            }
            if(x==1)
                printWriter.println("NO HAY ALUMNOS EN ESTE CURSO");       
            printWriter.close();
        } catch (Exception  e){
            e.printStackTrace();
        }
        
    }

    public void GenerarReporteProfesor(Curso ListaCursos,Estudiante ListaEstudiantes,Profesor ListaProfesores,OfertaLaboral ListaOfertas) {
        Scanner Entrada= new Scanner(System.in);
        int Opcion ;
        System.out.println("Generar el reporte del Profesor:");
        for(int i = 0 ; i < ListaProfesores.Profesores.size();i++){
            System.out.println(i + 1 + ": "  +ListaProfesores.Profesores.get(i).DarDatos());
        }
        Opcion = Entrada.nextInt()-1;
        if(Opcion > ListaProfesores.Profesores.size() ){
            System.out.println("Opcion Ingresada no es valida");
            return ;
        }
        try{
            String Ruta = "./Reportes/Profesor_"+ListaProfesores.Profesores.get(Opcion).getNombre()+".txt";
            File file = new File(Ruta);
            if (!file.exists()) {
                    file.createNewFile();
            }
            PrintWriter printWriter = new PrintWriter("./Reportes/Profesor_"+ListaProfesores.Profesores.get(Opcion).getNombre()+".txt");
            printWriter.println("Datos del Profesor:");
            printWriter.println("");
            printWriter.println(ListaProfesores.Profesores.get(Opcion).DarDatos(1));
            printWriter.println(" Curso que imparte: ");
            printWriter.println("");
            for(int i=0; i<ListaProfesores.Profesores.get(Opcion).getSize();i++)
                printWriter.println(i+1+") " + ListaProfesores.Profesores.get(Opcion).getCursos(i)); 
            printWriter.close();
        } catch (Exception  e){
            e.printStackTrace();
        }
    }
    
    public void GenerarReporteEstudiante(Curso ListaCursos,Estudiante ListaEstudiantes,Profesor ListaProfesores,OfertaLaboral ListaOfertas){
        Scanner Entrada= new Scanner(System.in);
        int Opcion ;
        System.out.println("Generar el reporte del Estudiante:");
        for(int i = 0 ; i < ListaEstudiantes.Estudiantes.size();i++){
            System.out.println(i + 1 + ": "  +ListaEstudiantes.Estudiantes.get(i).DarDatos());
        }
        Opcion = Entrada.nextInt()-1;
        if(Opcion > ListaEstudiantes.Estudiantes.size() ){
            System.out.println("Opcion Ingresada no es valida");
            return ;
        }
        try{
            String Ruta = "./Reportes/Estudiante_"+ListaEstudiantes.Estudiantes.get(Opcion).getNombre()+".txt";
            File file = new File(Ruta);
            if (!file.exists()) {
                    file.createNewFile();
            }
            PrintWriter printWriter = new PrintWriter("./Reportes/Estudiante_"+ListaEstudiantes.Estudiantes.get(Opcion).getNombre()+".txt");
            printWriter.println("Datos del Estudiante:");
            printWriter.println(ListaEstudiantes.Estudiantes.get(Opcion).DarDatos(1));
            for(int i=0; i<ListaEstudiantes.Estudiantes.get(Opcion).getSizeCursosMatriculados();i++)
                printWriter.println(i+1+") " + ListaEstudiantes.Estudiantes.get(Opcion).getCursosMatriculados().get(i).getNombre());
            printWriter.close();
        } catch (Exception  e){
            e.printStackTrace();
        }
    }
    
}
