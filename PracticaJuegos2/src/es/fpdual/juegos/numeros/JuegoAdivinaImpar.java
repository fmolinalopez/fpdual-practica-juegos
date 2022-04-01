package es.fpdual.juegos.numeros;

import es.fpdual.utils.UtilidadesJuego;

public class JuegoAdivinaImpar extends JuegoAdivinaNumero {

	public JuegoAdivinaImpar(Integer numeroVidasIniciales) {
		super(numeroVidasIniciales, UtilidadesJuego.numeroImparAleatorio());
	}

	@Override
	public boolean numeroValido(Integer numero) {
		return super.numeroValido(numero) && UtilidadesJuego.esImpar(numero);
	}

	@Override
	public void muestraNombre() {
		System.out.println("Adivina el numero impar!");
	}

	@Override
	public void muestraInfo() {
		System.out.println("Introduce un numero impar entre 1 y 10");
	}
}
