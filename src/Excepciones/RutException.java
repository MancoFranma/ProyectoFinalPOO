/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author sofia
 */
public class RutException extends RuntimeException{
    
    public RutException() {
        super("Ese no es un formato de rut, por favor que sea formato 1.111.111-1 o 11.111.111-1");
    }
}
