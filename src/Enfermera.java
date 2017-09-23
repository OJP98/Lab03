/**
 * @Author: Oscar Juarez y Rodrigo Zea
 * @Version: 22.09.17
 * Programacion Orientada a objetos
 * Descripcion: 
 */

public class Enfermera extends Trabajador {
    
    private boolean intensivista;
    private int tiempoTrabajando;

    public Enfermera(String nombre, String DPI, String NIT, double salario, int turnos, boolean intensivista, int tiempoTrabajando) {
        super(nombre, DPI, NIT, salario, turnos);
        this.intensivista = intensivista;
        this.tiempoTrabajando = tiempoTrabajando;
    }

    public boolean isIntensivista() {
        return intensivista;
    }

    public int getTiempoTrabajando() {
        return tiempoTrabajando;
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
    
    @Override
    public String imprimirDatos(Trabajador[][] matriz, int mes, int dia){

        String SioNo;
        
        if (intensivista==true) {
            SioNo = "Si";
        } else {
            SioNo = "No";
        }
        
        return super.imprimirDatos(matriz, mes, dia) + "Especialista: " + SioNo + "\n";
        
    }
    
}
