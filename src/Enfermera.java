/**
 * @Author: Oscar Juarez y Rodrigo Zea
 * @Version: 22.09.17
 * Programacion Orientada a objetos
 * Descripcion: 
 */

public class Enfermera extends Trabajador {
    
    private boolean intensivista;

    public Enfermera(String nombre, String DPI, String NIT, double salario, int turnos, boolean intensivista) {
        super(nombre, DPI, NIT, salario, turnos);
        this.intensivista = intensivista;
    }

    public boolean isIntensivista() {
        return intensivista;
    }
    
    @Override
    public void calcularSalario(double salario, int turnos){
        
        int bono = turnos-4;
        
        if (turnos>=5) {
            
            salario = salario + (500*bono); 
            
        } else {
            
            salario += this.salario;
            
        }
        
    }
    
}
