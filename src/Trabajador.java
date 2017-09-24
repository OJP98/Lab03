
import java.util.ArrayList;


/**
 * @Author: Oscar Juarez y Rodrigo Zea
 * @Version: 22.09.17
 * Programacion Orientada a objetos
 * Descripcion: Clase padre de Enfermera y medico, crea un nuevo objeto de tipo trabajador
 */

public class Trabajador {
    
    protected String nombre;
    protected String DPI;
    protected String NIT;
    protected double salario;
    protected int turnos;
    
    /**
     * Crea un nuevo objeto de tipo Trabajador con los parametros especificados
     * @param Nombre
     * @param dpi
     * @param nit
     * @param Salario
     * @param Turnos
     */
    public Trabajador(String Nombre, String dpi, String nit, double Salario, int Turnos){
    
        nombre = Nombre;
        DPI = dpi;
        NIT = nit;
        salario = Salario;
        turnos = Turnos;
    }
    
    /**
     * Constructor sin parametros, crea un objeto de Trabajador vacio
     */
    public Trabajador(){}

    /**
     * Devuelve el nombre del trabajador
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el DPI del trabajador
     * @return DPI
     */
    public String getDPI() {
        return DPI;
    }

    /**
     * Devuelve el NIT del trabajador
     * @return
     */
    public String getNIT() {
        return NIT;
    }

    /**
     * Devuelve el salario base del trabajador
     * @return
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Devuelve los turnos trabajados por un trabajador
     * @return
     */
    public int getTurnos() {
        return turnos;
    }
    
    /**
     * Suma la cantidad de turnos indicados por el usuario a la cantidad actual de turnos
     * @param i: cantidad de turnoss
     */
    public void sumaTurnos(int i){
        turnos += i;
    }
    
    /**
     * Resta la cantidad de turnos indicada por el usuario a la cantidad actual de turnos
     * @param i: cantidad de turnos
     */
    public void restaTurnos(int i){
        turnos -= i;
    }
    
    /**
     * Calcula cual es el salario total de un trabajador sin especificar si es medico o enfermera
     * @param salario
     * @param turnos
     * @return salario
     */
    public double calcularSalario(double salario, int turnos){        
        this.salario += salario;    
        
        return salario;
    }
    
    /**
     * Devuelve una cadena de datos con la informacion basica del trabajador, su nombre, dpi, nit y su salario base
     * @param matriz
     * @param mes
     * @param dia
     * @return cadena
     */
    public String imprimirDatos(Trabajador[][] matriz, int mes, int dia) {
        
        String cadena = "";
        
        cadena = "Nombre: " + matriz[mes][dia].getNombre() + "\n" + "DPI: " + matriz[mes][dia].getDPI() + "\n" + "NIT: " + matriz[mes][dia].getNIT() + "\n" + "Salario: Q " + matriz[mes][dia].getSalario() + "\n";
        
        return cadena;
    }
}
