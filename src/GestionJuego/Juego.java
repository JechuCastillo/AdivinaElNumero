package GestionJuego;

import java.util.Random;

public class Juego {
	//Atributos
	private int numero;
	private int intentos;
	private int rango;
	private Random random = new Random();

	public Juego(int rango, int intentos) {
		this.intentos = intentos;
		this.rango = rango;
		this.numero = random.nextInt(rango) + 1; // Genera un numero random
	}

	//Getters y Setters 
	public int getIntentos() {
		return intentos;
	}

	public int getNumero() {
		return numero;
	}

	public int getRango() {
		return rango;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public boolean intentar(int unNumero) {
		return unNumero == this.numero;
	}

}
