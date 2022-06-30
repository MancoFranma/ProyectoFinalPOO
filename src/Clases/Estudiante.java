package Clases;

import Funciones.CSV;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Estudiante extends Persona{

    //Atributos
    
    private ArrayList<Curso> ArrayListCursosMatriculados;
    HashMap<String, Curso>CursosMatriculados;
    public ArrayList <Estudiante> Estudiantes = new ArrayList <Estudiante>();

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
    
    public void LeerEstudiantes(Curso Cursos) throws IOException {
        CSV acceso = new CSV("Estudiante");
        String linea = acceso.firstLine();
        linea = acceso.nextLine();
        while (linea != null) {
            Estudiante nuevoEstudiante = new Estudiante();
            for (int i = 0; i < 5; i++) {
                switch (i) {
                    case 0: {
                        nuevoEstudiante.setNombre(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 1: {
                        nuevoEstudiante.setApellido(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 2: {
                        nuevoEstudiante.setRut(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 3: {
                        nuevoEstudiante.setMail(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 4: {                        
                        String [] ClaveCursos=acceso.get_csvField(linea, i).split(",");
                        for (int j = 0; j < ClaveCursos.length; j++) {
                            for (int k = 0; k < Cursos.Cursos.size(); k++) {
                                if (Cursos.Cursos.get(k).getNombre().equals(ClaveCursos[j])) {                                                                        
                                    nuevoEstudiante.setArrayListCursosMatriculados(Cursos.Cursos.get(k));
                                    nuevoEstudiante.setCursoMapa(Cursos.Cursos.get(k));
                                }
                            }
                        }
                    }
                }
            }
            Estudiantes.add(nuevoEstudiante);
            linea = acceso.nextLine();
            if (linea == null) {
                break;
            }
        }
    }
    
    public void mostrarEstudiantes(){
        System.out.println("ESTUDIANTES :");
        System.out.println("");
        for(int i=0; i<this.Estudiantes.size(); i++){
            System.out.print(this.Estudiantes.get(i).getNombre()+" ");
            System.out.print(this.Estudiantes.get(i).getApellido()+" ");
            System.out.print(this.Estudiantes.get(i).getRut()+" ");
            System.out.print(this.Estudiantes.get(i).getMail()+" ");
            for(int j=0; j<Estudiantes.get(i).getSizeCursosMatriculados(); j++){
                System.out.print(this.Estudiantes.get(i).getCursosMatriculados().get(j).getNombre()+" , ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void mostrarEstudianteDeterminado(int i){
        if (i > Estudiantes.size()){
            System.out.println("NO EXISTE ESTE ESTUDIANTE");
        }
        else{
            System.out.println("Estudiante solicitado por numero de la lista: ");
            System.out.print(this.Estudiantes.get(i).getNombre()+" ");
            System.out.print(this.Estudiantes.get(i).getApellido()+" ");
            System.out.print(this.Estudiantes.get(i).getRut()+" ");
            System.out.print(this.Estudiantes.get(i).getMail()+" ");
            for(int j=0; j<Estudiantes.get(i).getSizeCursosMatriculados(); j++){
                System.out.print(this.Estudiantes.get(i).getCursosMatriculados().get(j)+" ");
            }
            System.out.println("");
            System.out.println("");
        }
    }
    
    public void mostrarEstudianteDeterminado(String Rut){
        int a = 0 ;
        for(int i=0; i<this.Estudiantes.size(); i++){
            if (this.Estudiantes.get(i).getRut().equals(Rut)){
                System.out.println("Estudiante solicitado por RUT: ");
                System.out.print(this.Estudiantes.get(i).getNombre()+" ");
                System.out.print(this.Estudiantes.get(i).getApellido()+" ");
                System.out.print(this.Estudiantes.get(i).getRut()+" ");
                System.out.print(this.Estudiantes.get(i).getMail()+" ");
                for(int j=0; j<Estudiantes.get(i).getSizeCursosMatriculados(); j++){
                    System.out.print(this.Estudiantes.get(i).getCursosMatriculados().get(j)+" ");
                }
                System.out.println("");
                a = 1 ;
            }
        }
        if(a == 0){
            System.out.println("NO EXISTE ESTE ESTUDIANTE");
        }
        System.out.println("");
    }
    
    public void CrearEstudiante(Curso Cursos){
        Scanner Entrada= new Scanner(System.in);
        System.out.println("Ingrese RUT");
        String DATOSTRING = Entrada.next();
        Estudiante nuevoEstudiante = new Estudiante();
        for(int i=0; i<this.Estudiantes.size(); i++){    
            if (this.Estudiantes.get(i).getRut().equals(DATOSTRING)){
                System.out.println("ESTUDIANTE YA EXISTE");
                return ;
            }
        }
        nuevoEstudiante.setRut(DATOSTRING);
        System.out.println("Ingrese el Nombre del nuevo Estudiante");
        nuevoEstudiante.setNombre(Entrada.next());
        System.out.println("Ingrese el Apellido del nuevo Estudiante");
        nuevoEstudiante.setApellido(Entrada.next());
        System.out.println("Ingrese el mail del nuevo Estudiante");
        nuevoEstudiante.setMail(Entrada.next());
        System.out.println("Ingrese el numero de cursos que asiste el Estudiante");
        int DATOINT = Entrada.nextInt();
        Curso CursosX = new Curso();
        for (int i = 0 ; i < DATOINT ; i++){
            System.out.println("Ingrese la Clave del curso nr"+i+ " que asiste el estudiante");
            DATOSTRING =(Entrada.next());
            for (int j = 0 ; j < Cursos.Cursos.size();j++){
                if(Cursos.Cursos.get(j).getClaveCurso().equals(DATOSTRING)){
                    nuevoEstudiante.setArrayListCursosMatriculados(Cursos.Cursos.get(j));
                    nuevoEstudiante.setCursoMapa(Cursos.Cursos.get(j));
                    break;
                }
                else{
                    CursosX.setClaveCurso(DATOSTRING);
                    System.out.println("Ingrese el nombre del curso nr" +i+ " que asiste el estudiante");
                    CursosX.setNombre(Entrada.next());
                    System.out.println("Ingrese la Fecha de Inicio del curso nr"+i+ " que asiste el estudiante");
                    CursosX.setFechaInicio(Entrada.next());
                    System.out.println("Ingrese la Fecha de Termino del curso nr"+i+ " que asiste el estudiante");
                    CursosX.setFechaTermino(Entrada.next());
                    System.out.println("Ingrese la categoria que pertenece el curso nr"+i+" que asiste el estudiante");
                    CursosX.setCategoria(Entrada.next());
                    System.out.println("Ingrese el ID del profesor que impartira el curso nr"+i+" que asiste el estudiante");
                    CursosX.setIdProfesor(Entrada.nextInt());
                    Cursos.Cursos.add(CursosX);
                    nuevoEstudiante.setArrayListCursosMatriculados(CursosX);
                    nuevoEstudiante.setCursoMapa(CursosX);
                }
            }
        }
        Estudiantes.add(nuevoEstudiante);
    }
    
    public void MostrarAlumnoConCursosEntreNyM(){
        Scanner Entrada = new Scanner (System.in);
        System.out.println("Ingrese un número para empezar el rango de números que abarcará la variable 'n': ");
        int n = Entrada.nextInt();
        System.out.println("Ingrese un número para terminar el rango de números que abarcará la variable 'm' (que sea mayor que 'n'): ");
        int m = Entrada.nextInt();
        for (int i = 0; i < this.Estudiantes.size(); i++){
            if ((this.Estudiantes.get(i).getCursosMatriculados().size() >= n) && (this.Estudiantes.get(i).getCursosMatriculados().size() <= m)){
                System.out.println("El estudiante " + this.Estudiantes.get(i).getNombre() + " " + this.Estudiantes.get(i).getApellido() + " tiene " + this.Estudiantes.get(i).getCursosMatriculados().size() + " cursos matriculados");
            }
        }
    }
    
}