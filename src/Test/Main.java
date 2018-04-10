package Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import Analizador.Excepciones;
import Analizador.Validar;
import Cifrado.Palabra;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, Excepciones {
                String[] arg = {"-a", "ingles", "-t", "ejemplo de oracion", "-n", "0"};
        Validar analizador = new Validar(arg);
        try {
            analizador.validarParametros();
        } catch (Excepciones e) {
            System.out.println(e.getMessage());
            return;
        }

        Palabra palabraminu = new Palabra(analizador.dameOperacion());
        System.out.println(palabraminu.OpcionAbecedario(analizador.dameArgumento("-a"), palabraminu,
                Integer.parseInt(analizador.dameArgumento("-n"))));

    }

}
