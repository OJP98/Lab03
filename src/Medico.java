
import java.util.ArrayList;

/**
 * @Author: Oscar Juarez y Rodrigo Zea
 * @Version: 22.09.17
 * Programacion Orientada a objetos
 * Descripcion: Crea objetos tipo medicos a partir de heredar atributos y metodos de la clase trabajador
 */

public class Medico extends Trabajador{
    
    private boolean especialista;
    private String colegiado;
    
    /**
     * Crea un objeto de tipo medico con los parametros especificados
     * @param nombre
     * @param DPI
     * @param NIT
     * @param salario
     * @param turnos
     * @param especialista
     * @param colegiado
     */
    public Medico(String nombre, String DPI, String NIT, double salario, int turnos, boolean especialista, String colegiado) {
        
        super(nombre, DPI, NIT, salario, turnos);
        this.especialista =  especialista;
        this.colegiado = colegiado;
        
    }
    
    /**
     * Constructor comun sin parametrs
     */
    public Medico(){}

    /**
     * Devuelve si el medico es especialista o no lo es
     * @return especialista
     */
    public boolean isEspecialista() {
        return especialista;
    }

    /**
     * Devuelve el colegiado del medico
     * @return colegiado
     */
    public String getColegiado() {
        return colegiado;
    }
    
    
    /**
     * Calcula el trabajo de un medico a partir de su salario base y los turnos que realizo
     * @param salario
     * @param turnos
     * @return
     */
    @Override
    public double calcularSalario(double salario, int turnos){
        
        int bono = turnos-2;
        double salarioT = 0;
        
        if (turnos>=3) {            
            
            salarioT = this.salario + (900*bono);            
            
        } else {
            salarioT = this.salario;
        }        
        
        return salarioT;
    }
    
    /**
     * Devuelve una cadena de texto con la informacion basica del medico, su nombre, dpi, nit, salario base y si es especialista o no
     * @param matriz: matriz de medicos
     * @param mes: posicion de la columna
     * @param dia: posicion de la fila
     * @return: cadena de texto con los datos del medico
     */
    public String imprimirDatosM(Medico[][] matriz, int mes, int dia){
        
        String Especialista;
        
        if (matriz[mes][dia].isEspecialista()){
            Especialista = "Si";
        } else {
            Especialista = "No";
        }
        
        return super.imprimirDatos(matriz, mes, dia) + "Especialista: " + Especialista + "\n" + "Colegiado: " + matriz[mes][dia].getColegiado();
        
    }
        

        
}
