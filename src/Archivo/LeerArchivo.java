package Archivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivo {

  public String muestraContenido(String archivo) throws FileNotFoundException, IOException {
    String cadena;
    String auxiliar = "";
    FileReader f = new FileReader(archivo);
    BufferedReader b = new BufferedReader(f);
    while ((cadena = b.readLine()) != null) {
    	auxiliar += cadena;
    	auxiliar += "\n";
     }
    
    b.close();
    return auxiliar;
  }
  
}