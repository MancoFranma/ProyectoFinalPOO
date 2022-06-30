package Clases;

import Funciones.CSV;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Curso {

    //Atributos
    private String Nombre;
    private String ClaveCurso;    
    private String FechaInicio;
    private String FechaTermino;
    private String Categoria;
    private int IdProfesor;    
    public ArrayList <Curso> Cursos = new ArrayList <Curso>();
    
    //Accesores
    public String getNombre(){
        return Nombre;
    }
    
    public String getClaveCurso(){
        return ClaveCurso;
    }        
    
    public String getFechaInicio(){
        return FechaInicio;
    }
    
    public String getFechaTermino(){
        return FechaTermino;
    }
    
    public String getCategoria(){
        return Categoria;
    }
    
    public int getIdProfesor(){
        return IdProfesor;
    }
    
    //Mutadores
    public void setNombre(String Nombre1){
        Nombre=Nombre1;
    }
    
    public void setClaveCurso(String ClaveCurso1){
        ClaveCurso=ClaveCurso1;
    }    
    
    public void setFechaInicio(String FechaInicio1){
        FechaInicio=FechaInicio1;
    }
    
    public void setFechaTermino(String FechaTermino1){
        FechaTermino=FechaTermino1;
    }
    
    public void setCategoria(String Categoria1){
        Categoria=Categoria1;
    }
    
    public void setIdProfesor(int IdProfesor1){
        IdProfesor=IdProfesor1;
    }
    
    
    
    public void leerCursos() throws FileNotFoundException, IOException{
        CSV acceso = new CSV("Curso");
        String linea = acceso.firstLine();
        linea = acceso.nextLine();
        while (linea != null) {
            Curso nuevoCurso = new Curso();
            for (int i = 0; i < 7; i++) {
                switch (i) {
                    case 0: {
                        nuevoCurso.setNombre(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 1: {
                        nuevoCurso.setClaveCurso(acceso.get_csvField(linea, i));
                        break;
                    }                    
                    case 2: {
                        nuevoCurso.setFechaInicio(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 3: {
                        nuevoCurso.setFechaTermino(acceso.get_csvField(linea, i));
                        break;   
                    }
                    case 4: {
                        nuevoCurso.setCategoria(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 5: {
                        nuevoCurso.setIdProfesor(Integer.parseInt(acceso.get_csvField(linea, i)));
                        break;
                    }
                }
        }
            Cursos.add(nuevoCurso);
            linea = acceso.nextLine();
            if (linea == null) {
                break;
            }
    }
}
    public void mostrarCursos(){
        System.out.println("Cursos :");
        System.out.println("");
        for(int i=0; i<this.Cursos.size(); i++){
            System.out.print(this.Cursos.get(i).getNombre()+" ");
            System.out.print(this.Cursos.get(i).getClaveCurso()+" ");            
            System.out.print(this.Cursos.get(i).getFechaInicio()+" ");
            System.out.print(this.Cursos.get(i).getFechaTermino()+" ");
            System.out.print(this.Cursos.get(i).getCategoria()+" ");
            System.out.print(this.Cursos.get(i).getIdProfesor()+" ");
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void mostrarCursoDeterminado(int i){
        if (i > Cursos.size()){
            System.out.println("NO EXISTE ESTE CURSO");
        }
        else{
            System.out.println("Curso solicitado por lista: ");
            System.out.println("");
            System.out.print(this.Cursos.get(i).getNombre()+" ");
            System.out.print(this.Cursos.get(i).getClaveCurso()+" ");            
            System.out.print(this.Cursos.get(i).getFechaInicio()+" ");
            System.out.print(this.Cursos.get(i).getFechaTermino()+" ");
            System.out.print(this.Cursos.get(i).getCategoria()+" ");
            System.out.print(this.Cursos.get(i).getIdProfesor()+" ");
            System.out.println(""); 
        }
    }
    
    public void mostrarCursoDeterminado(String claveCurso){
        
        int a = 0 ;
        for(int i=0; i<this.Cursos.size(); i++){
            if (this.Cursos.get(i).getClaveCurso().equals(claveCurso)){
                System.out.println("Curso solicitado por clave del curso: ");
                System.out.println("");
                System.out.print(this.Cursos.get(i).getNombre()+" ");
                System.out.print(this.Cursos.get(i).getClaveCurso()+" ");            
                System.out.print(this.Cursos.get(i).getFechaInicio()+" ");
                System.out.print(this.Cursos.get(i).getFechaTermino()+" ");
                System.out.print(this.Cursos.get(i).getCategoria()+" ");
                System.out.print(this.Cursos.get(i).getIdProfesor()+" ");
                System.out.println("");
                a = 1 ;
                break ;
            }
        }
        if (a == 0){
            System.out.println("NO EXISTE ESTE CURSO");
        }
        System.out.println("");
    }
    
    public void CrearCurso(){
        Scanner Entrada= new Scanner(System.in);
        System.out.println("Ingrese Clave del Curso");
        String DATOSTRING = Entrada.next();
        Curso nuevoCurso = new Curso();
        for(int i=0; i<this.Cursos.size(); i++){    
            if (this.Cursos.get(i).getClaveCurso().equals(DATOSTRING)){
                System.out.println("CURSO YA EXISTE");
                return ;
            }
        }
        nuevoCurso.setClaveCurso(DATOSTRING);
        System.out.println("Ingrese el Nombre del nuevo Curso");
        nuevoCurso.setNombre(Entrada.next());
        System.out.println("Ingrese la Fecha de Inicio del nuevo Curso");
        nuevoCurso.setFechaInicio(Entrada.next());
        System.out.println("Ingrese la Fecha de Termino del nuevo Curso");
        nuevoCurso.setFechaTermino(Entrada.next());
        System.out.println("Ingrese el nombre del la Categoria del nuevo Curso");
        nuevoCurso.setCategoria(Entrada.next());
        System.out.println("Ingrese el numero del ID del profesor que imparte el curso");
        nuevoCurso.setIdProfesor(Entrada.nextInt());
        Cursos.add(nuevoCurso);
    }
    
    
}
