
import java.util.ArrayList;

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
    
    public Medico(){}

    public boolean isEspecialista() {
        return especialista;
    }

    public String getColegiado() {
        return colegiado;
    }
    
    
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
