package Funciones;

import Clases.Curso;
import Vista.MenuTexto;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionesVentanas {
    
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
