package Clases;

import java.util.ArrayList;

public class OfertaLaboral {
    private String NombreOferta;
    private String Categoria;
    private int Sueldo;
    private ArrayList<String> Requerimientos;    

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
}
