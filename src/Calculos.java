
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * @Author: Oscar Juarez y Rodrigo Zea
 * @Version: 22.09.17
 * Programacion Orientada a objetos
 * Descripcion: 
 */

public class Calculos {
    
    private String[][] Matriz;
    Medico medico = new Medico();
    Enfermera enfermera = new Enfermera();
    public static ArrayList<Medico> listaCalculosM = new ArrayList<Medico>();
    public static ArrayList<Enfermera> listaCalculosE = new ArrayList<Enfermera>();
    
    
    /**
     * Metodo que asigna todos los turnos del persona de Guardia
     */
    public void asignarTurnos(Medico[][] matrizM, Enfermera[][] matrizE, ArrayList<Medico> listaM, ArrayList<Enfermera> listaE){
        
        Random generadorRandom = new Random();
        int numeroRandom;
        
        for (int i = 0; i < matrizM.length; i++) {
            for (int j = 0; j < matrizM[0].length; j++) {
                
                numeroRandom = generadorRandom.nextInt(listaM.size());    
                matrizM[i][j] = listaM.get(numeroRandom);
                }
                
            }
        
        for (int i = 0; i < matrizE.length; i++) {
            for (int j = 0; j < matrizE[0].length; j++) {
                
                numeroRandom = generadorRandom.nextInt(listaE.size());
                matrizE[i][j] = listaE.get(numeroRandom);    
            }      
        }  
    }
    
    public void mostrarTurnos(JTextArea texto1, JTextArea texto2, int mes, int dia, Medico[][] matrizM, Enfermera[][] matrizE, JLabel fecha){
        
        int Mes = mes+1;
        
        String String1 = medico.imprimirDatosM(matrizM, mes, dia);
        String String2 = enfermera.imprimirDatosE(matrizE, mes, dia);
        
        texto1.setText(String1);
        texto2.setText(String2);
        fecha.setText(dia+1 + " / " + Mes + " / 2017");
        
    }
    
    public void editarTurno(Medico[][] matrizM, Enfermera[][] matrizE, ArrayList<Medico> listaM, ArrayList<Enfermera> listaE, int M, int E, int dia, int mes){
        
        matrizM[mes][dia] = listaM.get(M);
        matrizE[mes][dia] = listaE.get(E);
                
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
   


