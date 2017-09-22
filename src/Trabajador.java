
import java.util.ArrayList;

/**
 * @Author: Oscar Juarez y Rodrigo Zea
 * @Version: 22.09.17
 * Programacion Orientada a objetos
 * Descripcion: 
 */

public class Trabajador {
    
    protected String nombre;
    protected String DPI;
    protected String NIT;
    protected double salario;
    protected int turnos;
    public static ArrayList<Trabajador> listaTrabajadores = new ArrayList<Trabajador>();
    
    public Trabajador(String Nombre, String dpi, String nit, double Salario, int Turnos){
    
        nombre = Nombre;
        DPI = dpi;
        NIT = nit;
        salario = Salario;
        turnos = Turnos;
    }
    
    public Trabajador(){}

    public String getNombre() {
        return nombre;
    }

    public String getDPI() {
        return DPI;
    }

    public String getNIT() {
        return NIT;
    }

    public double getSalario() {
        return salario;
    }

    public int getTurnos() {
        return turnos;
    }
    
    public void calcularSalario(double salario, int turnos){        
        this.salario += salario;        
    }
}
