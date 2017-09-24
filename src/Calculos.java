
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * @Author: Oscar Juarez y Rodrigo Zea
 * @Version: 22.09.17
 * Programacion Orientada a objetos
 * Descripcion: Clase encargada de realizar todos los calculos que lleven logica del programa.
 */

public class Calculos {
    
    private String[][] Matriz;
    Medico medico = new Medico();
    Enfermera enfermera = new Enfermera();
    public static ArrayList<Medico> listaCalculosM = new ArrayList<Medico>();
    public static ArrayList<Enfermera> listaCalculosE = new ArrayList<Enfermera>();
    
    /**
     * Asigna los turnos de forma aleatoria al "calendario" de meses y dias.
     * @param matrizM
     * @param matrizE
     * @param listaM
     * @param listaE
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
    
    /**
     * Muestra los datos del medico y enfermera asignados a un turno en especifico, seleccionado por el usuario.
     * @param texto1
     * @param texto2
     * @param mes
     * @param dia
     * @param matrizM
     * @param matrizE
     * @param fecha
     */
    public void mostrarTurnos(JTextArea texto1, JTextArea texto2, int mes, int dia, Medico[][] matrizM, Enfermera[][] matrizE, JLabel fecha){
        
        int Mes = mes+1;
        
        String String1 = medico.imprimirDatosM(matrizM, mes, dia);
        String String2 = enfermera.imprimirDatosE(matrizE, mes, dia);
        
        texto1.setText(String1);
        texto2.setText(String2);
        fecha.setText(dia+1 + " / " + Mes + " / 2017");
        
    }
    
    /**
     * Si el usuario desea cambiar al medico o enfermera de un turno, este metodo le permite cambiar uno o ambos trabajadores en un turno especifico
     * @param matrizM
     * @param matrizE
     * @param listaM
     * @param listaE
     * @param M
     * @param E
     * @param dia
     * @param mes
     */
    public void editarTurno(Medico[][] matrizM, Enfermera[][] matrizE, ArrayList<Medico> listaM, ArrayList<Enfermera> listaE, int M, int E, int dia, int mes){
        
        matrizM[mes][dia] = listaM.get(M);
        if(matrizE[mes][dia].isIntensivista() == true && listaE.get(E).isIntensivista() == false){
           JOptionPane.showMessageDialog(null, "La enfermera sustituta debe de ser intensivista", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else{
            matrizE[mes][dia] = listaE.get(E); 
        }
       
                
    }
    
    /**
     * Este metodo obtiene la cantidad de turnos de la enfemera intensivista que ha trabajado mas turnos
     * @param matrizE
     * @param listaE
     * @return valorM
     */
    public int intensivistaMasTurnos(Enfermera[][] matrizE, ArrayList<Enfermera> listaE){
        
        ArrayList<Integer> turnosE = new ArrayList<Integer>();
        
        int valorM = 0;
        
        for(Enfermera x: listaE){            
            if(x.isIntensivista()) {                
                turnosE.add(x.getTurnos());                
            }           
        }
        
        valorM = Collections.max(turnosE);
        
        return valorM;
    }
    
    /**
     * Este metodo obtiene el nombre de la enfermera intensivista que ha trabajado mas turnos
     * @param listaE
     * @param valorM
     * @return nombre
     */
    public String nombreIntensivista(ArrayList<Enfermera> listaE, int valorM){
        
        String nombre="";
        
        for (int k = 0; k < listaE.size(); k++) {
            if((listaE.get(k).getTurnos() == valorM) && (listaE.get(k).isIntensivista()==true)){
                nombre = listaE.get(k).getNombre();
            }
        }
        
        return nombre;
    }
    
    /**
     * Este metodo obtiene el salario base de la enfermera intensivista que ha trabajado mas turnos
     * @param listaE
     * @param valorM
     * @return salario
     */
    public double SalarioIntensivista(ArrayList<Enfermera> listaE, int valorM){
        double salario = 0;
        
        for (int k = 0; k < listaE.size(); k++) {
            if(listaE.get(k).getTurnos() == valorM && listaE.get(k).isIntensivista()){
                salario = listaE.get(k).getSalario();
            }
        }
        
        return salario;
    }
    
    /**
     * Este metodo obtiene el salario anual de la enfermera intensivista que ha trabajado mas turnos
     * @param turnos
     * @param salario
     * @return salarioT
     */
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
    
    /**
     * Calcula cuanto es el total a pagar por turnos trabajados de mas de todos los trabajadores
     * @param listM
     * @param listE
     * @return devengado
     */
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
    
    /**
     * Cuenta cuantas veces encuentra una pareja de medico/enfermera especificada por el usuario
     * @param matrizM
     * @param matrizE
     * @param especialista
     * @param intensivista
     * @return contador
     */
    public int contarVeces(Medico[][] matrizM, Enfermera[][] matrizE, String especialista, String intensivista) {
        
        String nombre1;
        String nombre2;
        int contador = 0;
        
        for (int i = 0; i < matrizM.length; i++) {
            for (int j = 0; j < matrizM[0].length; j++) {
                
                nombre1 = matrizM[i][j].getNombre();
                nombre2 = matrizE[i][j].getNombre();
                
                if( (nombre1.equals(especialista)) && (nombre2.equals(intensivista)) ) {
                    contador++;
                }                
            }
        }

        return contador;
        
    }
    
    
    
}
    
 
   


