package Clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Estudiante extends Persona{

    //Atributos
    
    private ArrayList<Curso> ArrayListCursosMatriculados;
    HashMap<String, Curso>CursosMatriculados;

    public Estudiante() {
        CursosMatriculados=new HashMap<String, Curso>();
        ArrayListCursosMatriculados= new ArrayList<Curso>();
    }

    public Curso getCursoMatriculado(String Clave){
        return CursosMatriculados.get(Clave);
    }
    
    public ArrayList <Curso> getCursosMatriculados(){
        return ArrayListCursosMatriculados;
    }

    public void setArrayListCursosMatriculados(Curso Cursos1){
        ArrayListCursosMatriculados.add(Cursos1);
    }
    
    public void setCursoMapa(Curso Curso){
        CursosMatriculados.put(Curso.getClaveCurso(), Curso);
    }
    
    public int getSizeCursosMatriculados(){
        return ArrayListCursosMatriculados.size();
    }
    
    public Curso buscarCursoPorClave(String Clave){
        return CursosMatriculados.get(Clave);
    }
    
    public String DarDatos(int i){
        return ("\n Nombre: "+Nombre+"\n"+" Apellido: "+Apellido+"\n"+" Rut: "+Rut+"\n"+" Mail: "+Mail+"\nCursos Que asiste:\n\n");
    }
    
}