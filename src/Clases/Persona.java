/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Excepciones.RutException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author franm
 */
public abstract class Persona {
    protected String Nombre;
    protected String Apellido;
    protected String Rut;
    protected String Mail;
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }
    
    public String DarDatos(){
        return (Nombre + " " + Apellido);
    }
    
    /**
     * Esta funcion valida el rut, es decir, que este en el formato correcto
     * @param rut
     * @throws RutException 
     */
    public static void ValidarRut(String rut) throws RutException{
        
        String regularExpression;
        
        regularExpression = "^\\d{1,2}\\.\\d{3}\\.\\d{3}[-][0-9kK]{1}$";
        Pattern pat = Pattern.compile(regularExpression);
        Matcher mat = pat.matcher(rut);
        
        if (mat.matches()) {
            System.out.println("RUT válido");                                                                            
        } else {
            throw new RutException();
        }
    }
}
