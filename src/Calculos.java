
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
                listaM.get(numeroRandom).sumaTurnos(1);
                }
                
            }
        
        for (int i = 0; i < matrizE.length; i++) {
            for (int j = 0; j < matrizE[0].length; j++) {
                
                numeroRandom = generadorRandom.nextInt(listaE.size());
                matrizE[i][j] = listaE.get(numeroRandom);    
                listaE.get(numeroRandom).sumaTurnos(1);
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
        if(matrizE[mes][dia].isIntensivista() == true && listaE.get(E).isIntensivista() == false){
           JOptionPane.showMessageDialog(null, "La enfermera sustituta debe de ser intensivista", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else{
            matrizE[mes][dia] = listaE.get(E); 
        }
       
                
    }
    
    public int intensivistaMasTurnos(Enfermera[][] matrizE, ArrayList<Enfermera> listaE){
        int[] turnosE = new int[2];
        
        /*for (int i = 0; i < matrizE.length; i++) {
            for (int j = 0; j < matrizE[0].length; j++) {
                if(matrizE[i][j].isIntensivista()){
                    turnosE[i] = matrizE[i][j].getTurnos();
                }
            }
        }*/
        
        for (int i = 0; i < listaE.size(); i++) {
            for (int j = 0; j < turnosE.length; j++) {
              if(listaE.get(i).isIntensivista()){
                turnosE[j] = listaE.get(i).getTurnos();
                }  
            }
            
        }
        
        Arrays.sort(turnosE);
        int valorM = turnosE[0];
        
        return valorM;
    }
    
    public String nombreIntensivista(ArrayList<Enfermera> listaE, int valorM){
        String nombre="";
        
        for (int k = 0; k < listaE.size(); k++) {
            if(listaE.get(k).getTurnos() == valorM && listaE.get(k).isIntensivista()){
                nombre = listaE.get(k).getNombre();
            }
        }
        
        return nombre;
    }
    
    public double SalarioIntensivista(ArrayList<Enfermera> listaE, int valorM){
        double salario = 0;
        
        for (int k = 0; k < listaE.size(); k++) {
            if(listaE.get(k).getTurnos() == valorM && listaE.get(k).isIntensivista()){
                salario = listaE.get(k).getSalario();
            }
        }
        
        return salario;
    }
    
    public double SalarioExtraIntensivista(int turnos, double salario){
       int bono = turnos-5;
       double salarioT = 0;
        
        if (turnos>=5) {
            
            salarioT = (salario*12) + (500*bono); 
            
        } else {
            
            salarioT = salario*12;
            
        }
        
        return salarioT;
    }
    
    public double devengado(ArrayList<Medico> listM, ArrayList<Enfermera> listE){
        double devengado = 0;
        double salarioM = 0, salarioE = 0;
        
        for (int i = 0; i < listM.size(); i++) {
            salarioM = listM.get(i).calcularSalario(listM.get(i).getSalario(), listM.get(i).getTurnos());
            salarioE = listE.get(i).calcularSalario(listE.get(i).getSalario(), listE.get(i).getTurnos());
            
            devengado += salarioM + salarioE;
        }
        
        return devengado;
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
   


