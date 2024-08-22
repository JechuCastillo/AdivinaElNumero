package GestionJuego;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean ejecucion = true;
		int numero;
		while (ejecucion) {
			menu();
			numero = obtenerInt();
			if (numero == 1) {
				jugar();
			} else if (numero == 2) {
				System.out.println("Juego finalizado");
				ejecucion = false;
			} else {
				System.out.println("Opción no valida");
			}
		}
	}

	public static int obtenerInt() {
		boolean conseguido = false;
		int nro=0;
		Scanner sc = new Scanner(System.in);
		while (!conseguido) {
			try {
				nro = sc.nextInt();
				conseguido =true;
			} catch (InputMismatchException e) {
				System.out.println("Por favor ingrese un numero");
				sc.next();
				System.out.println("Ingrese valor: ");
			}
		}
		return nro;
	}

	public static void menu() {
		System.out.println(" ------------------------");
		System.out.println("|      Bienvenido a      |");
		System.out.println("|    ADIVINA EL NUMERO   |");
		System.out.println("|1- Jugar		 |");
		System.out.println("|2- Salir		 |");
		System.out.println(" ------------------------");
	}

	public static void jugar() {
		Juego juego;
		int dificultad = elegirDificultad();
		switch (dificultad) {
		//Segun la dificultad elegida crea el juego con dicha dificultad
		case 1:
			juego = new Juego(20, 5);
			break;
		case 2:
			juego = new Juego(100, 7);
			break;
		case 3:
			juego = new Juego(1000, 10);
			break;
		default:
			juego = new Juego(10, 1);
			break;
		}

		// Ejecución del juego
		boolean adivinado = false;
		int numero = 0;
		while (juego.getIntentos() > 0 && !adivinado) {
			System.out
					.println("Intentos:" + juego.getIntentos() + "				" + "Entre 1 y " + juego.getRango());
			System.out.println("			 " + numero);
			System.out.println("Ingrese un numero: ");
			numero = obtenerInt();
			if (juego.intentar(numero)) {
				System.out.println("Felicidades adivinaste el numero!");
				adivinado = true;
			} else {
				//Reduce la cantidad de intentos
				juego.setIntentos(juego.getIntentos() - 1);
				if (juego.getIntentos() > 0) {
					//Si aun hay intentos le da pistas al jugador
					if (juego.getNumero() > numero) {
						System.out.println("Tu número es muy bajo");
					} else {
						System.out.println("Tu número es muy alto");
					}
				}else {
					System.out.println("Perdiste el juego");
				}
			}
		}
		System.out.println();
	}

	public static int elegirDificultad() {
		int numero = -1;
		System.out.println("****Elija la dificultad****");
		boolean elegida = false;
		while (!elegida) {
			System.out.println("1- Fácil (5 intentos y el numero esta entre 1 y 20");
			System.out.println("2- Normal (7 intentos y el numero esta entre 1 y 100)");
			System.out.println("3- Difícil(10 intentos y el numero esta entre 1 y 1000)");
			System.out.println("4- KAMIKAZE(1 intento y el numero esta entre 1 y 10)");
			numero = obtenerInt();
			//Validacion de la dificultad elegida
			if (numero > 4 || numero < 1) {
				System.out.println("OPCION NO VALIDA");
			} else {
				elegida = true;
			}
		}
		return numero;
	}
}
