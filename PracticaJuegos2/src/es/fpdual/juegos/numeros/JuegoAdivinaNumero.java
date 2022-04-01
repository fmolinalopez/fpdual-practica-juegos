package es.fpdual.juegos.numeros;

import java.util.Random;

import es.fpdual.juegos.Juego;
import es.fpdual.utils.UtilidadesJuego;

public class JuegoAdivinaNumero extends Juego {

	private final Integer numeroAdivinar;
	
	public JuegoAdivinaNumero(Integer numeroVidasIniciales) {
		this(numeroVidasIniciales, new Random().ints(1, 11).findFirst().orElse(0));
	}
	
	protected JuegoAdivinaNumero(Integer numeroVidasIniciales, Integer numeroAdivinar) {
		super(numeroVidasIniciales);
		this.numeroAdivinar = numeroAdivinar;
	}

	@Override
	public void jugar() {
		if (this.getNumeroVidasIniciales().equals(this.getNumeroVidasRestantes())) {
			muestraNombre();
		}
		
		Integer numeroIntroducido = null;
		
		do {
			muestraInfo();
			numeroIntroducido = UtilidadesJuego.leerNumero();
		} while(!numeroValido(numeroIntroducido));
		
		if (numeroIntroducido.equals(this.numeroAdivinar)) {
			System.out.println("Has acertado!!!");
			this.actualizaRecord();
		} else {
			System.out.println("Numero incorrecto");
			muestraPista(numeroIntroducido);
			if (quitaVida()) {
				jugar();
			}
		}
	}
	
	public void muestraPista(Integer numeroIntroducido) {
		if (numeroIntroducido < this.numeroAdivinar) {
			System.out.println("El numero introducido es menor que el numero a adivinar");
		} else {
			System.out.println("El numero introducido es mayor que el numero a adivinar");
		}
	}
	
	public boolean numeroValido(Integer numero) {
		return numero > 0 && numero <= 10;
	}

	@Override
	public void muestraNombre() {
		System.out.println("Adivina el numero!!");
	}

	@Override
	public void muestraInfo() {
		System.out.println("Introduce un numero entre 1 y 10");
	}

}
