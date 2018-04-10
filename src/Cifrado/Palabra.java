package Cifrado;

import Analizador.Excepciones;

public class Palabra {
  String palabra = "";

  public Palabra(String palabra) {
    this.palabra = palabra;
  }

  public String getPalabra() {
    return this.palabra;
  }

  public String OpcionAbecedario(String decision, Palabra palabra, Integer cantidad)
      throws Excepciones {
    String nuevapalabra = "";
    for (int i = 0; i < this.palabra.length(); i++) {
      Letra letra = new Letra(this.palabra.charAt(i));
      nuevapalabra += letra.cifrarconunalfabetoenespecifico(decision, cantidad);
    }
    return nuevapalabra;
  }

}
