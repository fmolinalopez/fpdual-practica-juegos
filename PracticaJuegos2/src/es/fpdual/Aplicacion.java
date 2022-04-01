package es.fpdual;

import es.fpdual.juegos.Juego;
import es.fpdual.juegos.letras.JuegoAhorcado;
import es.fpdual.juegos.numeros.JuegoAdivinaImpar;
import es.fpdual.juegos.numeros.JuegoAdivinaNumero;
import es.fpdual.juegos.numeros.JuegoAdivinaPar;
import es.fpdual.utils.UtilidadesJuego;

public class Aplicacion {
	

	public static void main(String[] args) {
		do {
			Juego juego = eligeJuego();
			juego.jugar();
		}while(preguntaSeguirJugando());
		System.out.println("Sesion finalizada");
	}

	
	public static Juego eligeJuego() {
		Juego[] juegosDisponibles = {new JuegoAdivinaNumero(5), new JuegoAdivinaPar(5), new JuegoAdivinaImpar(5), new JuegoAhorcado("palabra")};
		Integer numeroIntroducido = null;
		
		do {
			System.out.println("____________________________");
			System.out.println("|Elige un juego             |");
			System.out.println("|1 - Adivina el numero      |");
			System.out.println("|2 - Adivina el numero par  |");
			System.out.println("|3 - Adivina el numero impar|");
			System.out.println("|4 - El ahorcado            |");
			System.out.println("|___________________________|");
			numeroIntroducido = UtilidadesJuego.leerNumero();
		} while(!numeroJuegoValido(numeroIntroducido));
		
		return juegosDisponibles[numeroIntroducido-1];
	}
	
	public static boolean numeroJuegoValido(Integer numero) {
		return numero > 0 && numero <= 4;
	}
	
	public static boolean preguntaSeguirJugando() {
		System.out.println("Desea jugar otra vez? Si/No");
		String respuesta = UtilidadesJuego.leerCadena();
		
		return respuesta.equalsIgnoreCase("si") || respuesta.toLowerCase().contains("s");
	}
}
