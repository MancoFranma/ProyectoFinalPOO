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
    
    /**
     * En esta funcion se crea un reporte, en el cual se  buscara un curso en 
     * particular, el cual sera elegido por el usuario, entonces se muestran 
     * los datos de este a traves de un archivo bloc de notas (txt)
     * 
     * @param ListaCursos se usara para buscar todos los cursos.
     * @param ListaEstudiantes se usara para buscar todos los estudiantes.
     * @param ListaProfesores se usara para buscar a todos los profesores.
     * @param ListaOfertas se usara para buscar todas las pfertas laborales.
     */
    public void GenerarReporteCurso(Curso ListaCursos,Estudiante ListaEstudiantes,Profesor ListaProfesores,OfertaLaboral ListaOfertas){
        Scanner Entrada= new Scanner(System.in);
        int Opcion ;
        System.out.println("Generar el reporte del curso:");
        for(int i = 0 ; i < ListaCursos.getCursos().size();i++){
            System.out.println(i + 1 + ": "  +ListaCursos.getCursos().get(i).getNombre());
        }
        System.out.println(ListaCursos.getCursos().size());
        Opcion = Entrada.nextInt();
        if(Opcion - 1 > ListaCursos.getCursos().size() ){
            System.out.println("Opcion Ingresada no es valida");
            return ;
        }
        try{
            String Ruta = "./Reportes/Curso_"+ListaCursos.getCursos().get(Opcion-1).getNombre()+".txt";
            File file = new File(Ruta);
            if (!file.exists()) {
                    file.createNewFile();
            }
            PrintWriter printWriter = new PrintWriter("./Reportes/Curso_"+ListaCursos.getCursos().get(Opcion-1).getNombre()+".txt");
            printWriter.println("Nombre del Curso: " + ListaCursos.getCursos().get(Opcion).getNombre());
            printWriter.println("Categoria del Curso: " + ListaCursos.getCursos().get(Opcion).getCategoria());
            printWriter.println("Clave del Curso: " + ListaCursos.getCursos().get(Opcion).getClaveCurso());
            printWriter.println("Fecha Inicio del Curso: " + ListaCursos.getCursos().get(Opcion).getFechaInicio());
            printWriter.println("Fecha Termino del Curso: " + ListaCursos.getCursos().get(Opcion).getFechaTermino());
            int x = 1 , y = 1 ;
            printWriter.println("");
            printWriter.println("Profesores que imparten el curso:");
            for(int j=0;j<ListaProfesores.getProfesores().size();j++){
                for(int l=0;l<ListaProfesores.getProfesores().get(j).getSize();l++){
                    if(ListaProfesores.getProfesores().get(j).getCursos(l).equals(ListaCursos.getCursos().get(Opcion).getNombre())){
                        printWriter.print(y + ")\n" + ListaProfesores.getProfesores().get(Opcion).DarDatos(1));
                        printWriter.println(" ");
                        y++;
                    }
                }
            }
            if(y==1)
                printWriter.println("NO HAY PROFESORES EN ESTE CURSO"); 
            printWriter.println("");
            printWriter.println("Alumnos del curso:");
            for(int j=0;j<ListaEstudiantes.getEstudiantes().size();j++){
                for(int l=0; l<ListaEstudiantes.getEstudiantes().get(j).getSizeCursosMatriculados();l++){
                    if(ListaEstudiantes.getEstudiantes().get(j).getCursosMatriculados().get(l).getNombre().equals(ListaCursos.getCursos().get(Opcion).getNombre())){
                        printWriter.println(x + ")\n Nombre: " + ListaEstudiantes.getEstudiantes().get(j).getNombre());
                        printWriter.println(" Apellido: " + ListaEstudiantes.getEstudiantes().get(j).getApellido());
                        printWriter.println(" Rut: " + ListaEstudiantes.getEstudiantes().get(j).getRut());
                        printWriter.println(" Mail: " + ListaEstudiantes.getEstudiantes().get(j).getMail());
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

    /**
     * En esta funcion se crea un reporte, en el cual se  buscara un profesor en 
     * particular, el cual sera elegido por el usuario, entonces se muestran 
     * los datos de este a traves de un archivo bloc de notas (txt)
     * 
     * @param ListaCursos se usara para buscar todos los cursos.
     * @param ListaEstudiantes se usara para buscar todos los estudiantes.
     * @param ListaProfesores se usara para buscar a todos los profesores.
     * @param ListaOfertas se usara para buscar todas las pfertas laborales.
     */
    public void GenerarReporteProfesor(Curso ListaCursos, Estudiante ListaEstudiantes, Profesor ListaProfesores, OfertaLaboral ListaOfertas) {
        Scanner Entrada= new Scanner(System.in);
        int Opcion ;
        System.out.println("Generar el reporte del Profesor:");
        for(int i = 0 ; i < ListaProfesores.getProfesores().size();i++){
            System.out.println(i + 1 + ": "  +ListaProfesores.getProfesores().get(i).DarDatos());
        }
        Opcion = Entrada.nextInt()-1;
        if(Opcion > ListaProfesores.getProfesores().size() ){
            System.out.println("Opcion Ingresada no es valida");
            return ;
        }
        try{
            String Ruta = "./Reportes/Profesor_"+ListaProfesores.getProfesores().get(Opcion).getNombre()+".txt";
            File file = new File(Ruta);
            if (!file.exists()) {
                    file.createNewFile();
            }
            PrintWriter printWriter = new PrintWriter("./Reportes/Profesor_"+ListaProfesores.getProfesores().get(Opcion).getNombre()+".txt");
            printWriter.println("Datos del Profesor:");
            printWriter.println("");
            printWriter.println(ListaProfesores.getProfesores().get(Opcion).DarDatos(1));
            printWriter.println(" Curso que imparte: ");
            printWriter.println("");
            for(int i=0; i<ListaProfesores.getProfesores().get(Opcion).getSize();i++)
                printWriter.println(i+1+") " + ListaProfesores.getProfesores().get(Opcion).getCursos(i)); 
            printWriter.close();
        } catch (Exception  e){
            e.printStackTrace();
        }
    }
    
    /**
     * En esta funcion se crea un reporte, en el cual se  buscara un estudiante 
     * en particular, el cual sera elegido por el usuario, entonces se muestran 
     * los datos de este a traves de un archivo bloc de notas (txt)
     * 
     * @param ListaCursos se usara para buscar todos los cursos.
     * @param ListaEstudiantes se usara para buscar todos los estudiantes.
     * @param ListaProfesores se usara para buscar a todos los profesores.
     * @param ListaOfertas se usara para buscar todas las pfertas laborales.
     */
    public void GenerarReporteEstudiante(Curso ListaCursos,Estudiante ListaEstudiantes,Profesor ListaProfesores,OfertaLaboral ListaOfertas){
        Scanner Entrada= new Scanner(System.in);
        int Opcion ;
        System.out.println("Generar el reporte del Estudiante:");
        for(int i = 0 ; i < ListaEstudiantes.getEstudiantes().size();i++){
            System.out.println(i + 1 + ": "  +ListaEstudiantes.getEstudiantes().get(i).DarDatos());
        }
        Opcion = Entrada.nextInt()-1;
        if(Opcion > ListaEstudiantes.getEstudiantes().size() ){
            System.out.println("Opcion Ingresada no es valida");
            return ;
        }
        try{
            String Ruta = "./Reportes/Estudiante_"+ListaEstudiantes.getEstudiantes().get(Opcion).getNombre()+".txt";
            File file = new File(Ruta);
            if (!file.exists()) {
                    file.createNewFile();
            }
            PrintWriter printWriter = new PrintWriter("./Reportes/Estudiante_"+ListaEstudiantes.getEstudiantes().get(Opcion).getNombre()+".txt");
            printWriter.println("Datos del Estudiante:");
            printWriter.println(ListaEstudiantes.getEstudiantes().get(Opcion).DarDatos(1));
            for(int i=0; i<ListaEstudiantes.getEstudiantes().get(Opcion).getSizeCursosMatriculados();i++)
                printWriter.println(i+1+") " + ListaEstudiantes.getEstudiantes().get(Opcion).getCursosMatriculados().get(i).getNombre());
            printWriter.close();
        } catch (Exception  e){
            e.printStackTrace();
        }
    }
    
}
