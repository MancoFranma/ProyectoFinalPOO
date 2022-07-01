package Clases;

import Clases.Persona;
import Funciones.CSV;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Profesor extends Persona{

    //Atributos
    private int IdProfesor;    
    private int Edad;
    private ArrayList<String> Cursos;
    public ArrayList <Profesor> Profesores = new ArrayList <Profesor>();
        
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
    
    /**
     * En esta funcion de agregan profesores a traves de la lectura en un excel,
     * se lee casilla por casilla, los datos correspondientes, como id profesor,
     * nombre, apellido, rut, edad, mail y cursos que dicta, luego el
     * profesor se agrega a un ArrayList, en caso de que la casilla siguiente a 
     * la de la ultima lectura este vacia, se termina la lectura.
     * 
     * @throws IOException 
     */
    public void LeerProfesores() throws IOException {
        CSV acceso = new CSV("Profesor");
        String linea = acceso.firstLine();
        linea = acceso.nextLine();
        while (linea != null) {
            Profesor nuevoProfesor = new Profesor();
            for (int i = 0; i < 7; i++) {
                switch (i) {
                    case 0: {
                        nuevoProfesor.setIdProfesor(Integer.parseInt(acceso.get_csvField(linea, i)));
                        break;
                    }
                    case 1: {
                        nuevoProfesor.setNombre(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 2: {
                        nuevoProfesor.setApellido(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 3: {
                        nuevoProfesor.setRut(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 4: {
                        nuevoProfesor.setEdad(Integer.parseInt(acceso.get_csvField(linea, i)));
                        break;
                    }
                    case 5: {
                        nuevoProfesor.setMail(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 6: {
                        String [] CursosX=acceso.get_csvField(linea, i).split(",");
                        for(int j=0; j<CursosX.length; j++){
                            nuevoProfesor.setCursos(CursosX[j]);
                        }                        
                        break;
                    }
                }
            }
            Profesores.add(nuevoProfesor);
            linea = acceso.nextLine();
            if (linea == null) {
                break;
            }
        }
    }
    
    /**
     * En esta funcion se muestran todos los profesores registrados, con sus 
     * datos correspondientes, estos se muestran por consola, como el 
     * id profesor, nombre, apellido, rut, edad, mail y cursos que dicta.
     */
    public void mostrarProfesores(){
        System.out.println("PROFESORES :");
        System.out.println("");
        for(int i=0; i<this.Profesores.size(); i++){
            System.out.print(this.Profesores.get(i).getIdProfesor()+" ");
            System.out.print(this.Profesores.get(i).getNombre()+" ");
            System.out.print(this.Profesores.get(i).getApellido()+" ");
            System.out.print(this.Profesores.get(i).getRut()+" ");
            System.out.print(this.Profesores.get(i).getEdad()+" ");
            System.out.print(this.Profesores.get(i).getMail()+" ");
            for(int j=0; j<Profesores.get(i).getSize(); j++){
                System.out.print(this.Profesores.get(i).getCursos(j)+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    /**
     * Esta funcion muestra a un profesor determinado, en caso de no existir, 
     * se muestra un mensaje por consola indicando su nula existencia, en caso
     * de existir se imprimen sus datos correspondientes.
     * 
     * @param i refiere al profesor elegido por el usuario, es el indice en el
     * cual se encontrara el profesor en el ArrayList.
     */
    public void mostrarProfesores(int i){
        if (i > Profesores.size()){
            System.out.println("NO EXISTE ESTE PROFESOR");
        }
        else{    
            System.out.println("Profesor buscado por lista: ");
            System.out.print(this.Profesores.get(i).getIdProfesor()+" ");
            System.out.print(this.Profesores.get(i).getNombre()+" ");
            System.out.print(this.Profesores.get(i).getApellido()+" ");
            System.out.print(this.Profesores.get(i).getRut()+" ");
            System.out.print(this.Profesores.get(i).getEdad()+" ");
            System.out.print(this.Profesores.get(i).getMail()+" ");
            for(int j=0; j<Profesores.get(i).getSize(); j++){
                System.out.print(this.Profesores.get(i).getCursos(j)+" ");
            }
            System.out.println("");
        }
    }
    
    /**
     * En esta funcion se crea un profesor ingresando sus datos por consola,
     * se pide en orden, partiendo por el rut, se busca si este profesor ya
     * existe, en caso de existir se imprime por pantalla que ya existe y se
     * cancela el proceso, en caso de no existir, se siguen pidiendo sus datos 
     * para ala agregacion, id profesor, nombr, apellido, edad, mail y un curso
     * el cual va a dictar (de principio).
     */
    public void CrearProfesor(){
        Scanner Entrada= new Scanner(System.in);
        System.out.println("Ingrese RUT");
        String DATOSTRING = Entrada.next();
        Profesor nuevoProfesor = new Profesor();
        for(int i=0; i<this.Profesores.size(); i++){    
            if (this.Profesores.get(i).getRut().equals(DATOSTRING)){
                System.out.println("PROFESOR YA EXISTE");
                return ;
            }
        }
        nuevoProfesor.setRut(DATOSTRING);
        System.out.println("Ingrese el ID del nuevo Profesor");
        nuevoProfesor.setIdProfesor(Entrada.nextInt());
        System.out.println("Ingrese el Nombre del nuevo Profesor");
        nuevoProfesor.setNombre(Entrada.next());
        System.out.println("Ingrese el Apellido del nuevo Profesor");
        nuevoProfesor.setApellido(Entrada.next());
        System.out.println("Ingrese la Edad del nuevo Profesor");
        nuevoProfesor.setEdad(Entrada.nextInt());
        System.out.println("Ingrese el mail del nuevo Profesor");
        nuevoProfesor.setMail(Entrada.next());
        System.out.println("Ingrese el nombre del curso que imparte el profesor");
        nuevoProfesor.setCursos(Entrada.next());
        Profesores.add(nuevoProfesor);
    }
    
    /**
     * En esta funcion se muestra al profesor con mas cursos, imprimiendo por
     * pantalla el nombre, cantidad de cursos y los cursos que dicta.
     */
    public void MostrarProfesorMasCursos(){
        int i, j, masCursos = 0, indiceProfesorMasCursos = 0;
        for(i = 0; i < this.Profesores.size(); i++){
            if (masCursos < this.Profesores.get(i).getSize()){
                masCursos = this.Profesores.get(i).getSize();
                indiceProfesorMasCursos = i;
        }
        System.out.println("El profesor con más cursos es:");
        System.out.println("Nombre Profesor: "+this.Profesores.get(indiceProfesorMasCursos));
        System.out.println("Con la cantidad de " + masCursos + " cursos");
        System.out.println("Los cuales son:");
        for (i = 0; i < this.Profesores.get(indiceProfesorMasCursos).getCursos(i).length(); i++){
            // no sé cómo imprimir los cursos del profesor
            System.out.println((i+1) + ") "+this.Profesores.get(indiceProfesorMasCursos).getCursos(i));
        }
        }
    }
    
}
