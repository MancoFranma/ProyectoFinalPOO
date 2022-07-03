package Clases;

import Excepciones.FechaException;
import Excepciones.RutException;
import Funciones.CSV;
import Vista.MenuTexto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Curso {

    //Atributos
    private String Nombre;
    private String ClaveCurso;    
    private String FechaInicio;
    private String FechaTermino;
    private String Categoria;
    private int IdProfesor;    
    private ArrayList <Curso> Cursos = new ArrayList <Curso>();
    
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

    public ArrayList<Curso> getCursos() {
        return Cursos;
    }

    public void setCursos(ArrayList<Curso> Cursos) {
        this.Cursos = Cursos;
    }
    
    /**
     * Esta funcion verifica que la fecha escrita siga el formato DD-MM-AAAA.
     * @param fecha es el String que se recibe.
     * @throws Excepciones.FechaException
     */
    public void ValidarFecha(String fecha) throws FechaException{
        
        String regularExpression;
        
        regularExpression = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
        Pattern pat = Pattern.compile(regularExpression);
        Matcher mat = pat.matcher(fecha);
        
        if (mat.matches()) {
            System.out.println("fecha válida");                                                                            
        } else {
            throw new FechaException();
        }
    }
    
    /**
     * Esta funcion lee los cursos en el archivo excel, en el orden
     * nombre, clave del curso, fecha de inicio, fecha de termino, categoria e 
     * id profesor, es decir lee casilla por casilla, en caso de que la proxima
     * casilla este vacia, termina.
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
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
    /**
     *  Esta funcion muestra los cursos registrados, los imprime por consola.
     */
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
    
    /**
     * Esta funcion muestra un curso en especifico (siempre y cuando este en el 
     * ArrayList), el cual elige el usuario.
     * 
     * @param i se usa como indice, para mostrar un curso determinado del ArrayList.
     */
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
    
    /**
     * Esta funcion muestra un curso por su clave 
     * (siempre y cuando esté en el ArrayList, es decir registrado, 
     * en caso de que no lo este, muestra un mensaje por pantalla indicandolo), 
     * el cual elige el usuario y se muestra por consola.
     * 
     * @param claveCurso es una variable la cual almacenara la clave del curso.
     */
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
    
    /**
     * Esta funcion crea un curso (desde consola), ingresando en un orden
     * correspondiente, la clave del curso (con la cual se busca si ya esta
     * registrado, si lo esta, no se agrega y si no esta, se sigue el registro), nombre,
     * fecha inicio, fecha termino, categoria e id profesor, después de todo el ingreso
     * se crea un objeto de tipo 'Curso' y se agrega.
     */
    public void CrearCurso(){
        Scanner Entrada= new Scanner(System.in);
        String DATOSTRING = this.ObtenerTexto("Ingrese Clave del Curso");
        Curso nuevoCurso = new Curso();
        for(int i=0; i<this.Cursos.size(); i++){    
            if (this.Cursos.get(i).getClaveCurso().equals(DATOSTRING)){
                System.out.println("CURSO YA EXISTE");
                return ;
            }
        }
        nuevoCurso.setClaveCurso(DATOSTRING);
        nuevoCurso.setNombre(this.ObtenerTexto("Ingrese el Nombre del nuevo Curso"));
        nuevoCurso.setFechaInicio(this.ObtenerTexto("Ingrese la Fecha de Inicio del nuevo Curso"));
        try{
            this.ValidarFecha(nuevoCurso.getFechaInicio() );
        } catch (FechaException ex) {
            ex.printStackTrace();
            return;
        }
        nuevoCurso.setFechaTermino(this.ObtenerTexto("Ingrese la Fecha de Termino del nuevo Curso"));
        try {
            this.ValidarFecha(nuevoCurso.getFechaTermino() );
        } catch (FechaException ex) {
            ex.printStackTrace();
            return;
        }
        nuevoCurso.setCategoria(this.ObtenerTexto("Ingrese el nombre del la Categoria del nuevo Curso"));
        nuevoCurso.setIdProfesor(Integer.valueOf(this.ObtenerTexto("Ingrese el numero del ID del profesor que imparte el curso")));
        Cursos.add(nuevoCurso);
    }
    
    /**
     * Esta es una funcion que permite eliminar un curso.
     */
    public void ElminarCurso(){
        
        System.out.println("Que curso desea eliminar");
        for (int i = 0; i < this.Cursos.size(); i++)
        {
            System.out.println((i + 1) + ") " + this.Cursos.get(i).ClaveCurso + " " + this.Cursos.get(i).Nombre);
        }
        int opcion = Integer.parseInt(this.ObtenerTexto("Elija uno"));
        this.Cursos.remove(opcion-1);
    }
    
    public String ObtenerTexto(String TextoEscribir){
        String texto = null;
        MenuTexto menutexto = new MenuTexto(TextoEscribir);
        menutexto.setVisible(true);
        while(texto == null){
            texto = menutexto.getTextoSacado();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(texto!=null)
                System.out.println("TEXTO Guardado");
        }
        menutexto.dispose();
        return texto;
    }
    
}
