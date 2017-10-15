/*
 * EditorArchivo.java
 *
 * Created on 04 de mayo de 2005, 11:41 PM
 */

package miLib;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 *
 * @author  Tommy Ponce
 */
public class EditorArchivo {
    RandomAccessFile archivo;
    /** Creates a new instance of EditorArchivo */
    public EditorArchivo(File file)throws IOException {
        archivo=new RandomAccessFile(file,"rw");
    }
    
    public void cerrarArchivo()throws IOException{
        if(archivo!=null)
            archivo.close();
    }
    
    public Aleatorio getRegistro(int c)throws IllegalArgumentException, NumberFormatException,
    IOException{
        Aleatorio registro=new Aleatorio();
        if(c<1 || c>100)
            throw new IllegalArgumentException("Fuera De Rango");
        archivo.seek((c-1)*Aleatorio.T);
        registro.leer(archivo);
        
        return registro;
    }
    
    public void actualizarRegistro(int c, String nom, String ape,double s)
     throws IllegalArgumentException, IOException{
         Aleatorio reg=getRegistro(c);
         if(c==0)
          throw new IllegalArgumentException("La Cuenta no Existe");
       archivo.seek((c-1)*Aleatorio.T);
       reg=new Aleatorio(c,nom,ape,s);
       
       reg.escribir(archivo);
   }
    
    
    public void newRegistro(int n, String nom, String ape,double s)throws IllegalArgumentException,
    IOException{
        Aleatorio registro=getRegistro(n);
        if(registro.getCuenta()!=0)
            throw new IllegalArgumentException("La cuenta ya Exixte");
        
        archivo.seek((n-1)*Aleatorio.T);
        
        registro=new Aleatorio(n,nom,ape,s);
        
        registro.escribir(archivo);
    }

    public void borrarRegistro(int cuenta)throws IllegalArgumentException,IOException{
        Aleatorio registro=getRegistro(cuenta);
        
        if(registro.getCuenta()==0)
            throw new IllegalArgumentException("La Cuenta no existe");
        archivo.seek((cuenta-1)*Aleatorio.T);
        
        registro=new Aleatorio();
        
        registro.escribir(archivo);
    }
    
}
