/**
 * @Author: Oscar Juarez y Rodrigo Zea
 * @Version: 22.09.17
 * Programacion Orientada a objetos
 * Descripcion: 
 */

public class Enfermera extends Trabajador{
    
    private boolean intensivista;
    private int tiempoTrabajando;

    public Enfermera(String nombre, String DPI, String NIT, double salario, int turnos, boolean intensivista, int tiempoTrabajando) {
        super(nombre, DPI, NIT, salario, turnos);
        this.intensivista = intensivista;
        this.tiempoTrabajando = tiempoTrabajando;
    }
    
    public Enfermera(){}

    public boolean isIntensivista() {
        return intensivista;
    }

    public int getTiempoTrabajando() {
        return tiempoTrabajando;
    }
    
    
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
