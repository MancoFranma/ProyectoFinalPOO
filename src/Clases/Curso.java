package Clases;

public class Curso {

    //Atributos
    private String Nombre;
    private String ClaveCurso;    
    private String FechaInicio;
    private String FechaTermino;
    private String Categoria;
    private int IdProfesor;    
    
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
}
