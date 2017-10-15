/*
 * Aleatorio.java
 *
 * Created on 19 de abril de 2005, 12:59 AM
 */

package miLib;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author  Tommy Ponce
 */
public class Aleatorio extends Registro {
    
	public static final int T=72;
    
    /** Creates a new instance of Aleatorio */
    public Aleatorio() {
        super(0,"","",0.0);
    }
    
    public Aleatorio(int c,String N,String A,double s){
        super(c,N,A,s);
        
    }
    
    public void leer(RandomAccessFile archivo)throws IOException{
        setCuenta(archivo.readInt());
        setNom(leerNombre(archivo));
        setApellido(leerNombre(archivo));
        setSaldo(archivo.readDouble());
    }
    
    private String leerNombre(RandomAccessFile archivo)throws IOException{
        char nombre[]=new char[15],temp;
        
        for(int i=0;i<nombre.length;i++){
            temp=archivo.readChar();
            nombre[i]=temp;
        }
        return new String(nombre).replace('\0',' ');
    }
    
    public void escribir(RandomAccessFile archivo)throws IOException{
        archivo.writeInt(getCuenta());
        escribirNombre(archivo,getNom());
        escribirNombre(archivo,getApellido());
        archivo.writeDouble(getSaldo());
    }
    private void escribirNombre(RandomAccessFile archivo,String nombre)throws IOException{
        StringBuffer bufer=null;
        
        if(nombre!=null)
            bufer=new StringBuffer(nombre);
        else
            bufer=new StringBuffer(15);
        
        bufer.setLength(15);
        archivo.writeChars(bufer.toString());
    }
}
