package Clases;

import Funciones.CSV;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OfertaLaboral {
    private String NombreOferta;
    private String Categoria;
    private int Sueldo;
    private ArrayList<String> Requerimientos;  
    public ArrayList <OfertaLaboral> OfertasLaborales = new ArrayList <OfertaLaboral>();

    public OfertaLaboral() {
        this.Requerimientos = new ArrayList<String>();
    }
    
    public String getNombreOferta() {
        return NombreOferta;
    }

    public void setNombreOferta(String NombreOferta) {
        this.NombreOferta = NombreOferta;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public int getSueldo() {
        return Sueldo;
    }

    public void setSueldo(int Sueldo) {
        this.Sueldo = Sueldo;
    }
   
    public String getRequerimientos(int i){
        return Requerimientos.get(i);
    }    

    public void setRequerimientos(String Requerimientos1) {
        Requerimientos.add(Requerimientos1);
    }

    public int getSizeRequerimientos(){
        return Requerimientos.size();
    }
    
    public void leerOfertaLaboral() throws FileNotFoundException, IOException{
        CSV acceso = new CSV("OfertasLaborales");
        String linea = acceso.firstLine();
        linea = acceso.nextLine();
        while (linea != null) {
            OfertaLaboral nuevaOferta = new OfertaLaboral();
            for (int i = 0; i < 7; i++) {
                switch (i) {
                    case 0: {
                        nuevaOferta.setNombreOferta(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 1: {
                        nuevaOferta.setCategoria(acceso.get_csvField(linea, i));
                        break;
                    }                    
                    case 2: {
                        nuevaOferta.setSueldo(Integer.parseInt(acceso.get_csvField(linea, i)));
                        break;
                    }
                    case 3: {
                        String [] OfertasX=acceso.get_csvField(linea, i).split(",");
                        for(int j=0; j<OfertasX.length; j++){
                            nuevaOferta.setRequerimientos(OfertasX[j]);
                        }
                        break;   
                    }                    
                }
        }
            OfertasLaborales.add(nuevaOferta);
            linea = acceso.nextLine();
            if (linea == null) {
                break;
            }
    }
}
    public void mostrarOfertasLaborales(){
        System.out.println("Ofertas Laborales Disponibles:");
        System.out.println("");
        for(int i=0; i<this.OfertasLaborales.size(); i++){
            System.out.print(this.OfertasLaborales.get(i).getNombreOferta()+" ");
            System.out.print(this.OfertasLaborales.get(i).getCategoria()+" ");            
            System.out.print(this.OfertasLaborales.get(i).getSueldo()+" ");
            for(int j=0; j<OfertasLaborales.get(i).getSizeRequerimientos(); j++){
                System.out.print(this.OfertasLaborales.get(i).getRequerimientos(j)+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void mostrarOfertaLaboralDeterminada(int i){
        if (i > OfertasLaborales.size()){
            System.out.println("NO EXISTE ESTA OFERTA LABORAL");
            System.out.println("");
        }
        else{
            System.out.println("Ofertas Laboral buscada por lista: " + i);
            System.out.println("");
            System.out.print(this.OfertasLaborales.get(i).getNombreOferta()+" ");
            System.out.print(this.OfertasLaborales.get(i).getCategoria()+" ");
            System.out.print(this.OfertasLaborales.get(i).getSueldo()+" ");
            for(int j=0; j<OfertasLaborales.get(i).getSizeRequerimientos(); j++){
                System.out.print(this.OfertasLaborales.get(i).getRequerimientos(j)+" ");
            }
            System.out.println("");
        }
    }
    
    public void mostrarOfertaLaboralDeterminada(String nombreOferta){
        int a = 0 ;
        for(int i=0; i<this.OfertasLaborales.size(); i++){
            if(this.OfertasLaborales.get(i).getNombreOferta().equals(nombreOferta)){
                System.out.println("Oferta Laboral solicitada por nombre: ");
                System.out.println("");
                System.out.print(this.OfertasLaborales.get(i).getNombreOferta()+" ");
                System.out.print(this.OfertasLaborales.get(i).getCategoria()+" ");
                System.out.print(this.OfertasLaborales.get(i).getSueldo()+" ");
                for(int j=0; j<OfertasLaborales.get(i).getSizeRequerimientos(); j++){
                    System.out.print(this.OfertasLaborales.get(i).getRequerimientos(j)+" ");
                }
                System.out.println("");
                a = 1 ;
                break ;
            }
        }
        if (a == 0){
            System.out.println("NO EXISTE ESTA OFERTA LABORAL");
        }
        System.out.println("");
    }
    
    public void CrearOfertaLaboral(){
        Scanner Entrada= new Scanner(System.in);
        OfertaLaboral nuevaOfertaLaboral = new OfertaLaboral();
        System.out.println("Ingrese Nombre de la nueva Oferta Laboral");
        String DATOSTRING = Entrada.next();
        for(int i=0; i<this.OfertasLaborales.size(); i++){    
            if (this.OfertasLaborales.get(i).getNombreOferta().equals(DATOSTRING)){
                System.out.println("OFERTA LABORAL YA EXISTE");
                return ;
            }
        }
        nuevaOfertaLaboral.setNombreOferta(DATOSTRING);
        System.out.println("Ingrese la Categoria de la nueva Oferta Laboral");
        nuevaOfertaLaboral.setCategoria(Entrada.next());
        System.out.println("Ingrese el Requerimiento necesario para la nueva Oferta Laboral");
        nuevaOfertaLaboral.setRequerimientos(Entrada.next());
        System.out.println("Ingrese el Sueldo propuesto de la nueva Oferta Laboral");
        nuevaOfertaLaboral.setSueldo(Entrada.nextInt());
        OfertasLaborales.add(nuevaOfertaLaboral);
    }
    
    
}
