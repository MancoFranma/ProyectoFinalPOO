package proyectopoo;

import Funciones.Menu;
import Funciones.Funciones;
import java.io.IOException;
import Vista.*;
import java.util.concurrent.TimeUnit;

/*
    Integrantes:
    
    Francisco Andres Muñoz Alarcon 20.242.456-2
    Anais Monserrat Foix Monardes  20.834.761-6
    Sofia Carolina Menzel Madrid   20.478.743-3
*/

public class ProyectoPOO {
    public static void main(String[] args)throws IOException, InterruptedException { 
        Funciones prueba = new Funciones();
        prueba.leerCursos();
        prueba.LeerProfesores();     
        prueba.LeerEstudiantes();     
        prueba.leerOfertaLaboral();
        MenuInterfaz menu = new MenuInterfaz(prueba);
        int comando = 0 ;
        
        while (comando != 4){
            menu.setVisible(true);
            TimeUnit.SECONDS.sleep(10);
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
                                case 1 : prueba.CrearEstudiante();
                                         flag = 1 ;
                                         break;
                                case 2 : prueba.CrearProfesor();
                                         flag = 1 ;
                                         break;
                                case 3 : prueba.CrearCurso();
                                         flag = 1 ;
                                         break;
                                case 4 : prueba.CrearOfertaLaboral();
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
                                case 1 : prueba.mostrarEstudiantes();
                                         flag = 1;
                                         break;
                                case 2 : prueba.mostrarProfesores();
                                         flag = 1;
                                         break;
                                case 3 : prueba.mostrarCursos();
                                         flag = 1;
                                         break;
                                case 4 : prueba.mostrarOfertasLaborales();
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
                                case 1 : prueba.GenerarReporteCurso();
                                         flag = 1;
                                         break;
                                case 2 : prueba.GenerarReporteProfesor();
                                         flag = 1;
                                         break;
                                case 3 : prueba.GenerarReporteEstudiante();
                                         flag = 1;
                                         break;
                            }
                            if(flag == 1)
                                break ;
                        }
                        break;
            }
        }
    }    
}
