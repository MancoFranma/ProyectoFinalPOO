package Funciones;

import java.io.*;
import java.util.*;

public class CSV
{
    // VARIABLES DE INSTANCIA
    private BufferedReader file;
    private String currentLine;

    // CONSTRUCTOR

    /**
     * Constructor de la clase CSV, usada para instanciar una variable con Nombre especifico
     * 
     * @param name Nombre del archivo
     * @throws FileNotFoundException Error de archivo no encontrado
     */
    public CSV(String name) throws FileNotFoundException
    {
      this.file =new BufferedReader(new FileReader("./Entradas/"+name+".csv"));
    }
    
    /**
     * Constructor de la clase CSV, usada para instanciar una variable con Nombre y Ruta especifica
     * 
     * @param ruta Direccion del archivo en carpeta
     * @param archivo Nombre del archivo
     * @throws FileNotFoundException Error de archivo no encontrado
     */
    public CSV(String ruta,String archivo) throws FileNotFoundException
    {
        this.file =new BufferedReader(new FileReader(ruta+archivo));
    }
    
    /**
     * Constructor de la clase CSV, usada para instanciar una variable
     */
    public CSV()
    {
    }

    // METODOS / FUNCIONES

    /**
     * Metodo que entrega la Primera linea del CSV
     * 
     * @return Primera linea del CSV
     * @throws IOException Error de I/O
     */
    public String firstLine() throws IOException
    {
        return nextLine();
    }
    
    /**
     * Metodo que entrega la siguiente linea del CSV
     * 
     * @return Linea siguiente del CSV
     * @throws IOException Error de I/O
     */
    public String nextLine() throws IOException
    {
        this.currentLine =this.file.readLine();
        //System.out.println("hola: "+this.currentLine);
        return(this.currentLine);
    }
    
    /**
     * Metodo que entrega el dato del campo en una linea del CSV
     * 
     * @param line Linea del CSV
     * @param field Campo de la linea del CSV
     * @return Dato del campo del CSV
     */
    public String get_csvField(String line,int field)
    {
        Scanner s = new Scanner(line);
        //System.out.println("Line: "+line);
        int index =(0);
        s.useDelimiter(";");
        String output;
        
        while(s.hasNext())
        {
            output =(s.next());
            //System.out.println("output: "+output);
            if((output.charAt(0))==('\"'))
            {
                while (true)
                {
                    if ((output.charAt((output.length())-1))==('\"'))
                    {
                        break;
                    }
                    output =(output+","+(s.next()));
                }
            }
            
            if (index==field)
            {
                s.close();
                return(output);
            }
            index =(index+1);
        }
        //System.out.println("Campo "+field+" no Existe");
        s.close();
        return(null);
    }

    /**
     * Metodo que entrega el dato del campo en una linea del CSV
     * 
     * @param field Campo de la linea del CSV
     * @param line Linea del CSV
     * @return Dato del campo del CSV
     */
    public String get_csvField(int field,String line)
    {
        Scanner s = new Scanner(line);
        int index =(0);
        s.useDelimiter(";");
        String output;
        
        while(s.hasNext())
        {
            output =(s.next());
            if((output.charAt(0))==('\"'))
            {
                while (true)
                {
                    output =(output+","+(s.next()));
                    if ((output.charAt((output.length())-1))==('\"'))
                    {
                        break;
                    }
                }
            }
            
            if (index==field)
            {
                return(output);
            }
            index =(index+1);
        }
        //System.out.println("Campo "+field+" no Existe");
        return(null);
    }
    
    /**
     * Metodo que cierra el archivo CSV
     * 
     * @throws IOException Error de I/O
     */
    public void close() throws IOException
    {
        file.close();
    }
}
