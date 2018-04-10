package Cifrado;

public class Parametro {

	private String valor;

	public Parametro(String valor) {
		this.valor = valor;
	}

	public boolean esOperacionGrande() {
		return (this.valor.equals("-f") || this.valor.equals("-t") );
	}
	
	public boolean esOperacionArchivoleer() {
		return (this.valor.equals("-f"));
	}

	public boolean esNumeroEntero() {
		try {
			@SuppressWarnings("unused")
			int numero = Integer.parseInt(this.valor);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	public String getValor() {
		return this.valor;
	}
}
