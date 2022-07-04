package proyectopoo;

import Clases.Curso;
import Clases.Estudiante;
import Clases.OfertaLaboral;
import Clases.Profesor;
import Funciones.Reportes;
import java.io.IOException;
import Vista.*;
/*
    Integrantes:
    
    Francisco Andres Muñoz Alarcon 20.242.456-2
    Anais Monserrat Foix Monardes  20.834.761-6
    Sofia Carolina Menzel Madrid   20.478.743-3
*/
public class ProyectoPOO {
    public static void main(String[] args)throws IOException, InterruptedException { 
        
        Reportes FuncionesReportes = new Reportes();
        Estudiante Estudiantes = new Estudiante();
        Profesor Profesores = new Profesor();
        OfertaLaboral OfertaLaborales = new OfertaLaboral();
        Curso Cursos = new Curso();
        MenuInterfaz menu = new MenuInterfaz();
        int comando = 0 ;
        
        Cursos.leerCursos();
        Estudiantes.LeerEstudiantes(Cursos);
        Profesores.LeerProfesores();
        OfertaLaborales.leerOfertaLaboral();
        
        while (comando != 5){
            menu.setVisible(true);
            comando = menu.getComando();
            int comando2 = 0 ;
            switch(comando)
            {    
                case 1 :
                        MenuAgregarElementos menuAgregar = new MenuAgregarElementos();
                        menuAgregar.setVisible(true);
                        while (comando2 != 5){
                            int flag = 0 ;
                            comando2 = menuAgregar.getComando();
                            switch(comando2)
                            {    
                                case 1 : Estudiantes.CrearEstudiante(Cursos);
                                         flag = 1 ;
                                         break;
                                case 2 : Profesores.CrearProfesor();
                                         flag = 1 ;
                                         break;
                                case 3 : Cursos.CrearCurso();
                                         flag = 1 ;
                                         break;
                                case 4 : OfertaLaborales.CrearOfertaLaboral();
                                         flag = 1 ;
                                         break;
                            }
                            if(flag == 1)
                                break;
                        }
                        break;
                case 2 :
                        MenuImprimirElementos menuImprimir = new MenuImprimirElementos();
                        menuImprimir.setVisible(true);
                        while (comando2 != 5){
                            int flag = 0 ;
                            comando2 = menuImprimir.getComando();
                            switch(comando2)
                            {    
                                case 1 : Estudiantes.mostrarEstudiantes();
                                         flag = 1;
                                         break;
                                case 2 : Profesores.mostrarProfesores();
                                         flag = 1;
                                         break;
                                case 3 : Cursos.mostrarCursos();
                                         flag = 1;
                                         break;
                                case 4 : OfertaLaborales.mostrarOfertasLaborales();
                                         flag = 1;
                                         break;
                            }
                            if(flag == 1)
                                break;
                        }
                        break;
                case 3 :
                        MenuGenerarReporte menuReporte = new MenuGenerarReporte();
                        menuReporte.setVisible(true);
                        while (comando2 != 4){
                            int flag = 0 ;
                            comando2 = menuReporte.getComando();
                            switch(comando2)
                            {    
                                case 1 : FuncionesReportes.GenerarReporteCurso(Cursos,Estudiantes,Profesores,OfertaLaborales);
                                         flag = 1;
                                         break;
                                case 2 : FuncionesReportes.GenerarReporteProfesor(Cursos,Estudiantes,Profesores,OfertaLaborales);
                                         flag = 1;
                                         break;
                                case 3 : FuncionesReportes.GenerarReporteEstudiante(Cursos,Estudiantes,Profesores,OfertaLaborales);
                                         flag = 1;
                                         break;
                            }
                            if(flag == 1)
                                break ;
                        }
                        break;
                case 4:
                       MenuEliminarElementos menuEliminar = new MenuEliminarElementos();
                       menuEliminar.setVisible(true);
                       int flag = 0 ;
                       comando2 = menuEliminar.getComando();
                       while (comando2 != 5){
                           System.out.println("el comando elegido es " + comando2);
                           switch(comando2)
                            {    
                                case 1 : Cursos.ElminarCurso();
                                         flag = 1;
                                         break;
                                case 2 : Profesores.ElminarProfesor();
                                         flag = 1;
                                         break;
                                case 3 : Estudiantes.ElminarEstudiante();
                                         flag = 1;
                                         break;
                                case 4 : OfertaLaborales.EliminarOfertaLaboral();
                                         flag = 1;
                                         break;
                            }
                            if(flag == 1)
                                break ;
                       }
            }
        }
        menu.resetComando();
    }
}
