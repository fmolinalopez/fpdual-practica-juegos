package es.fpdual.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class UtilidadesJuego {

	public static String leerCadena() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		try {
			str = br.readLine();
		} catch( Exception e ) {
			str = "";
		}
				
		return str;
	}
	
	public static int leerNumero() {
		int num;
		
		try {
			num = Integer.parseInt(leerCadena().trim());
		} catch (Exception e) {
			num = 0;
		}
		
		return num;
	}
	
	public static boolean esPar(int numero) {
		return numero % 2 == 0;
	}
	
	public static boolean esImpar(int numero) {
		return !esPar(numero);
	}
	
	public static int numeroParAleatorio() {
		return new Random().ints(1, 11).filter(UtilidadesJuego::esPar).findFirst().orElse(0);
	}
	
	public static int numeroImparAleatorio() {
		return new Random().ints(1, 11).filter(UtilidadesJuego::esImpar).findFirst().orElse(0);
	}
}
