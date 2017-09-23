
import java.util.ArrayList;
import java.util.Random;

/**
 * @Author: Oscar Juarez y Rodrigo Zea
 * @Version: 22.09.17
 * Programacion Orientada a objetos
 * Descripcion: 
 */

public class Calculos {
    
    private String[][] Matriz;
    public static ArrayList<Trabajador> listaCalculos = new ArrayList<Trabajador>();
    
    
    /**
     * Metodo que asigna todos los turnos del persona de Guardia
     */
    public void asignarTurnos(Trabajador[][] matriz, ArrayList<Trabajador> lista){
        
        Random generadorRandom = new Random();
        int numeroRandom;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                
                numeroRandom = generadorRandom.nextInt(lista.size());    
                
                if (lista.get(numeroRandom) instanceof Medico) {
                    matriz[i][j] = lista.get(numeroRandom);
                }
                
            }            
        }        
    }
    
    /*
    public String imprimirDatos(Trabajador[][] matriz, int mes, int dia){
        
        String nombre, DPI, NIT, colegiado, cadena = "";
        double salario;
        int tiempoTrabajando;
        boolean especialista, intensivista;
        
        nombre = matriz[mes][dia].getNombre();
        DPI = matriz[mes][dia].getDPI();
        NIT = matriz[mes][dia].getNIT();
        salario = matriz[mes][dia].getSalario();
        
        if (matriz[mes][dia] instanceof Medico) {
            
            colegiado = matriz[mes][dia].getColegiado;
            
            if (especialista==true){
                
            }
            
        }
        
        return nombre;
    }
        */
    
}


