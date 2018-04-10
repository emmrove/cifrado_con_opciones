package Analizador;


public class Excepciones extends Exception {
	
	private String message;

	public Excepciones(String message){
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
}
