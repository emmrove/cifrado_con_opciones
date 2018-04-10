package Analizador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Archivo.LeerArchivo;
import Cifrado.Parametro;

public class Validar {
  private ArrayList<String> parametros = new ArrayList<>();
  private ArrayList<String> comparar = new ArrayList<>();
  private Map<Parametro, Parametro> valores = new HashMap<>();

  public Validar(String[] args) throws Excepciones {
    for (int i = 0; i < args.length; i++) {
      this.parametros.add(args[i]);
    }
    comparar.add("-a");
    comparar.add("-n");
    comparar.add("-f");
    comparar.add("-t");
    comparar.add("-o");
    hacermapa();
  }

  public String dameArgumento(String parametro) {
    for (Parametro c : this.valores.keySet()) {
      if (c.getValor().equals(parametro)) {
        return this.valores.get(c).getValor();
      }
    }

    return "";
  }

  public String dameOperacion() throws FileNotFoundException, IOException {
    for (Parametro c : this.valores.keySet()) {
      if (c.esOperacionGrande()) {
        if (c.esOperacionArchivoleer()) {
          LeerArchivo leer = new LeerArchivo();
          return leer.muestraContenido(this.valores.get(c).getValor());
        }

        return this.valores.get(c).getValor();
      }
    }

    return "";
  }

  public Map<Parametro, Parametro> getMapa() {
    return this.valores;
  }

  public void hacermapa() throws Excepciones {
    for (int i = 0; i < parametros.size(); i++) {
      for (int x = 0; x < comparar.size(); x++) {
        if (parametros.get(i).equals(comparar.get(x)) && (this.argumentodespues(x) == true)) {

          valores.put(new Parametro(comparar.get(x)), new Parametro(parametros.get(i + 1)));
        }
      }
    }

  }

  public boolean argumentodespues(Integer numero) throws Excepciones {
    try {
      parametros.get(numero + 1);
    } catch (Exception e) {
      throw new Excepciones("No es posible si no indicas un valor.");
    }
    return true;
  }

  public void validarParametros() throws Excepciones {

    if (!(this.parametros.size() == 6)) {
      throw new Excepciones("Excepción: NO puede ir campo vacio.");
    }

  }

}
