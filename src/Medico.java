/**
 * @Author: Oscar Juarez y Rodrigo Zea
 * @Version: 22.09.17
 * Programacion Orientada a objetos
 * Descripcion: 
 */

public class Medico extends Trabajador{
    
    private boolean especialista;
    private String colegiado;
    
    public Medico(String nombre, String DPI, String NIT, double salario, int turnos, boolean especialista, String colegiado) {
        
        super(nombre, DPI, NIT, salario, turnos);
        this.especialista =  especialista;
        this.colegiado = colegiado;
        
    }

    public boolean isEspecialista() {
        return especialista;
    }

    public String getColegiado() {
        return colegiado;
    }
    
    
    @Override
    public void calcularSalario(double salario, int turnos){
        
        int bono = turnos-2;
        
        if (turnos>=3) {            
            
            salario = this.salario + (900*bono);            
            
        } else {
            salario += this.salario;
        }
        
    }
    
}
