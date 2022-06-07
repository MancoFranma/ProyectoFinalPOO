package Clases;

import Clases.Persona;
import java.util.ArrayList;

public class Profesor extends Persona{

    //Atributos
    private int IdProfesor;    
    private int Edad;
    private ArrayList<String> Cursos;    
        
    static void add(Profesor ProfesorX) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    public Profesor() {
        this.Cursos = new ArrayList<String>();
    }
    
    //Accesores
    
    public int getEdad(){
        return Edad;
    }
    
    public String getCursos(int i){
        return Cursos.get(i);
    }
    
    public int getIdProfesor(){
        return IdProfesor;
    }
    
    //Mutadores
    
    public void setEdad(int Edad1){
        Edad=Edad1;
    }
    
    public void setCursos(String Cursos1){
        Cursos.add(Cursos1);
    }
    
    public void setIdProfesor(int IdProfesor1){
        IdProfesor=IdProfesor1;
    }
    
    public int getSize(){
        return Cursos.size();
    }
    
    public String DarDatos(int a){
        return (" Nombre: "+Nombre+"\n"+" Apellido: "+Apellido+"\n"+" Rut: "+Rut+"\n"+" Mail: "+Mail+"\n"+" Edad: "+Edad+"\n"+" ID PROFESOR: "+IdProfesor+"\n");
    }
    
}
