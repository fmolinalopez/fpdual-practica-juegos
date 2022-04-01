package es.fpdual.juegos.numeros;

import es.fpdual.utils.UtilidadesJuego;

public class JuegoAdivinaPar extends JuegoAdivinaNumero {

	public JuegoAdivinaPar(Integer numeroVidasIniciales) {
		super(numeroVidasIniciales, UtilidadesJuego.numeroParAleatorio());
	}

	@Override
	public boolean numeroValido(Integer numero) {
		return super.numeroValido(numero) && UtilidadesJuego.esPar(numero);
	}

	@Override
	public void muestraNombre() {
		System.out.println("Adivina el numero par!");
	}

	@Override
	public void muestraInfo() {
		System.out.println("Introduce un numero par entre 1 y 10");
	}
}
