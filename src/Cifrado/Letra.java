package Cifrado;

import Analizador.Excepciones;

public class Letra {
  Character letra;
  String alfabetoespaniol = "AÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ";
  String alfabetonumeros = "1234567890";
  String alfabetoingles = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  String alfabetogriego = "ΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩ";
  Abecedario abecedario = new Abecedario(alfabetoespaniol);
  Abecedario abecedarioconnumeros = new Abecedario(alfabetonumeros);
  Abecedario ingles = new Abecedario(alfabetoingles);
  Abecedario griego = new Abecedario(alfabetogriego);

  public Letra(Character letra) {
    this.letra = letra;
  }

  public Character getLetra() {
    return this.letra;
  }

  public Character cambiodecaracter(Abecedario abecedario, Integer cantidad) {
    if (abecedario.perteneceaesteabecedario(this)) {
      return abecedario.cambiarcaracterporcifrado(cantidad, this);
    }
    Abecedario abeminusculas = new Abecedario(abecedario.getAbecedarioenString().toLowerCase());
    if (abeminusculas.perteneceaesteabecedario(this)) {
      return abeminusculas.cambiarcaracterporcifrado(cantidad, this);
    }

    if (abecedarioconnumeros.perteneceaesteabecedario(this)) {
      return abecedarioconnumeros.cambiarcaracterporcifrado(cantidad, this);
    }
    return this.getLetra();
  }

  public Character cifrarconunalfabetoenespecifico(String decision, Integer cantidad)
      throws Excepciones {
    try {
      if (decision.equals("español")) {
        return cambiodecaracter(this.abecedario, cantidad);

      }
      if (decision.equals("ingles")) {
        return cambiodecaracter(this.ingles, cantidad);
      }

      if (decision.equals("griego")) {
        return cambiodecaracter(this.griego, cantidad);
      }
    } catch (Exception e) {
      throw new Excepciones("Abecesario no valido");
    }

    return this.getLetra();

  }

  @Override
  public String toString() {
    return "La letra es " + this.getLetra();
  }

}
