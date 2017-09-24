/**
 * @Author: Oscar Juarez y Rodrigo Zea
 * @Version: 22.09.17
 * Programacion Orientada a objetos
 * Descripcion: Clase heredada de trabajador que crea objetos de tipo enfermera
 */

public class Enfermera extends Trabajador{
    
    private boolean intensivista;
    private int tiempoTrabajando;

    /**
     * Crea un nuevo objeto de tipo enfermera a partir de la clase Trabajador
     * @param nombre
     * @param DPI
     * @param NIT
     * @param salario
     * @param turnos
     * @param intensivista
     * @param tiempoTrabajando
     */
    public Enfermera(String nombre, String DPI, String NIT, double salario, int turnos, boolean intensivista, int tiempoTrabajando) {
        super(nombre, DPI, NIT, salario, turnos);
        this.intensivista = intensivista;
        this.tiempoTrabajando = tiempoTrabajando;
    }
    
    /**
     * Constructor de la clase enfermera sin parametros
     */
    public Enfermera(){}

    /**
     * Devuelve si la enfermera es intensivista o no
     * @return intensivista
     */
    public boolean isIntensivista() {
        return intensivista;
    }

    /**
     * Devuelve el tiempo que lleva trabajando la enfermera
     * @return tiempoTrabajando
     */
    public int getTiempoTrabajando() {
        return tiempoTrabajando;
    }
    
    /**
     * Calcula cuanto salario extra gana una enfermera a partir de sus turnos
     * @param salario
     * @param turnos
     * @return salarioT
     */
    @Override
    public double calcularSalario(double salario, int turnos){
        
        int bono = turnos-5;
        double salarioT=0;
        
        if (turnos>=5) {
            
            salarioT = salario + (500*bono); 
            
        } else {
            
            salarioT += this.salario;
            
        }
        
        return salarioT;
    }
    
    /**
     * Devuelve los datos basicos de una enfermera, su nombre, dpi, nit, salario, y si es intensivista la enfermera o no
     * @param matriz
     * @param mes
     * @param dia
     * @return 
     */
    public String imprimirDatosE(Enfermera[][] matriz, int mes, int dia){

        String SioNo;
        
        if (matriz[mes][dia].isIntensivista()) {
            SioNo = "Si";
        } else {
            SioNo = "No";
        }
        
        return super.imprimirDatos(matriz, mes, dia) + "Intensivista: " + SioNo + "\n";
        
    }
    
}
