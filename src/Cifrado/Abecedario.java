package Cifrado;

import java.util.ArrayList;

public class Abecedario {

    ArrayList<Character> abecedario = new ArrayList<>();
    String abe = "";

    public Abecedario(String abecedario) {
        this.abe = abecedario;
        alfabetoCompleto(abecedario);
    }

    public String getAbecedarioenString() {
        return this.abe;
    }

    public ArrayList<Character> alfabetoCompleto(String alfabeto) {

        for (int i = 0; i < alfabeto.length(); i++) {
            this.abecedario.add(alfabeto.charAt(i));
        }
        return this.abecedario;
    }

    public boolean perteneceaesteabecedario(Letra letra) {
        return this.getAlfabeto().contains(letra.getLetra());
    }

    public ArrayList<Character> getAlfabeto() {
        return this.abecedario;
    }

    public Character cambiarcaracterporcifrado(Integer cantidad, Letra letra) {
        for (int i = 0; i < this.getAlfabeto().size(); i++) {
            if (this.getAlfabeto().get(i).equals(letra.getLetra()) && (cantidad + i) < this.getAlfabeto().size()) {
                return this.getAlfabeto().get(i + cantidad);
            }
            if (this.getAlfabeto().get(i).equals(letra.getLetra())) {
                return this.getAlfabeto().get((i + cantidad) % this.getAlfabeto().size());
            }
        }
        return letra.getLetra();
    }
    
    public Character cambiarcaracterpordescifrado(Integer cantidad, Letra letra) {
        for (int i = this.getAlfabeto().size(); i > 0; i--) {
            if (this.getAlfabeto().get(i).equals(letra.getLetra()) && (cantidad - i) < this.getAlfabeto().size()) {
                return this.getAlfabeto().get(i - cantidad);
            }
            if (this.getAlfabeto().get(i).equals(letra.getLetra())) {
                return this.getAlfabeto().get((i - cantidad) % this.getAlfabeto().size());
            }
        }
        return letra.getLetra();
    }

    public String toString() {
        String representacion = "";
        for (int x = 0; x < this.abecedario.size(); x++) {
            representacion += this.abecedario.get(x) + "\n";
        }
        return representacion;
    }

}
