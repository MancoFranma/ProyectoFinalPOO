/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author sofia
 */
public class FechaException extends Exception{
    
    public FechaException() {
        super("Ese no es un formato de fecha, por favor que sea formato D-M-AAAA o DD-MM-AAAA");
    }
}
