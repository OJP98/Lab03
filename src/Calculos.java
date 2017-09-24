
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
        
        
        //Aqui se cancelan los dias inexistentes del año, como 29 de febrero, 31 de junio, etc...
        
        matrizM[1][28]=null;
        matrizM[1][29]=null;
        matrizM[1][30]=null;
        matrizM[3][30]=null;
        matrizM[5][30]=null;
        matrizM[8][30]=null;
        matrizM[10][30]=null;
        
        matrizE[1][28]=null;
        matrizE[1][29]=null;
        matrizE[1][30]=null;
        matrizE[3][30]=null;
        matrizE[5][30]=null;
        matrizE[8][30]=null;
        matrizE[10][30]=null;
        
        
    }
    
    /**
     * Muestra los datos del medico y enfermera asignados a un turno en especifico, seleccionado por el usuario.
     * @param texto1: El espacio en donde se va a imprimir el texto
     * @param texto2: Segundo espacio "".
     * @param mes: El numero de columna de la matriz
     * @param dia: El numero de fila de la matriz
     * @param matrizM: Matriz de medicos
     * @param matrizE: Matriz de enfermeras
     * @param fecha: Fecha que se muestra en el programa
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
     * @param matrizM: Matriz de medicos
     * @param matrizE: Matriz de enfermeras
     * @param listaM: lista de medicos
     * @param listaE: lista de enfermeras
     * @param M: Espacio ingresado por el usuario
     * @param E: Espacio ingresado por el usuario
     * @param dia: numero de fila
     * @param mes: numero de columna.
     */
    public void editarTurno(Medico[][] matrizM, Enfermera[][] matrizE, ArrayList<Medico> listaM, ArrayList<Enfermera> listaE, int M, int E, int dia, int mes){
        
        matrizM[mes][dia] = listaM.get(M);
        if(matrizE[mes][dia].isIntensivista() == true && listaE.get(E).isIntensivista() == false){
           JOptionPane.showMessageDialog(null, "La enfermera sustituta debe de ser intensivista", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else{
            
            matrizE[mes][dia].restaTurnos(1);
            matrizM[mes][dia].restaTurnos(1);
            
            matrizE[mes][dia] = listaE.get(E); 
            
            matrizM[mes][dia].sumaTurnos(1);
            matrizE[mes][dia].sumaTurnos(1);
        }
       
                
    }
    
    /**
     * Este metodo obtiene la cantidad de turnos de la enfemera intensivista que ha trabajado mas turnos
     * @param matrizE: Matriz de enfermeras
     * @param listaE: Lista de las enfermeras
     * @return valorM: La posicion de la enfermera con mas turnos realizados
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
     * @param listaE: lista de enfermeras
     * @param valorM: posicion de la lista
     * @return nombre: El nombre de la enfermera
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
     * @param listaE: Lista de enfermeras
     * @param valorM: La posicion de la enfermera con mas turnos
     * @return salario: El salario de dicha enfermera
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
     * @param turnos: Los turnos trabajados por una enfermera
     * @param salario: Salario de la enfermera
     * @return salarioT: EL salario total, incluyendo extras.
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
     * @param listM: Lista de medicos
     * @param listE: Lista de enfermeras
     * @return devengado: El total de todos los trabajadores
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
     * @param matrizM: Matriz de medicos
     * @param matrizE: Matriz de enfermeras
     * @param especialista: el nombre del especialista
     * @param intensivista: El nombre de la intensivista
     * @return contador: el numero de veces que han trabajado juntos
     */
    public int contarVeces(Medico[][] matrizM, Enfermera[][] matrizE, String especialista, String intensivista) {
        
        String nombre1;
        String nombre2;
        int contador = 0;
        
        for (int i = 0; i < matrizM.length; i++) {
            for (int j = 0; j < matrizM[0].length; j++) {
                
                if(!(i==1 && j==28) && !(i==1 && j==29) && !(i==1 && j==30) && !(i==3 && j==30) &&  !(i==5 && j==30) && !(i==8 && j==30) && !(i==10 && j==30)){
                    
                    nombre1 = matrizM[i][j].getNombre();
                    nombre2 = matrizE[i][j].getNombre();

                    if( (nombre1.equals(especialista)) && (nombre2.equals(intensivista)) ) {
                        contador++;
                    }   
                }
            }
        }
        
    return contador;
           
    }

     
        
    }
    
    
    

    
 
   


