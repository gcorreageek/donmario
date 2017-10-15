/*
 * Registro.java
 *
 * Created on 15 de abril de 2005, 10:37 PM
 */

package miLib;
import java.io.Serializable;
/**
 *
 * @author Tommy Ponce
 */
public class Registro implements Serializable{
    private int cuenta;
    private String nombre,apellido;
    private double saldo;
    
    /** Creates a new instance of Registro */
    public Registro() {
        cuenta=0;
        nombre="";
        apellido="";
        saldo=0.0;
    }
    public Registro(int cta,String nom,String ape,double sueldo){
        setCuenta(cta);
        setNom(nom);
        setApellido(ape);
        setSaldo(sueldo);
    }
    
    public void setCuenta(int cta){
        cuenta=cta;
    }
    public int getCuenta(){
        return cuenta;
    }
    
    public void setNom(String nom){
        nombre=nom;
    }
    
    public String getNom(){
        return nombre;
    }
    
    public void setApellido(String ape){
        apellido=ape;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setSaldo(double sueldo){
        saldo=sueldo;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
     
    
}
