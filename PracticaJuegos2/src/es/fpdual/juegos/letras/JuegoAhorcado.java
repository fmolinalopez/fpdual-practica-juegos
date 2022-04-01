package es.fpdual.juegos.letras;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import es.fpdual.juegos.Juego;
import es.fpdual.utils.UtilidadesJuego;


public class JuegoAhorcado extends Juego {

	private final String palabraAdivinar;
	
	private String palabraClave;
	
	private final List<String> letrasIntroducidas = new ArrayList<>();
	
	public JuegoAhorcado(String palabraAdivinar) {
		super(7);
		this.palabraAdivinar = palabraAdivinar;
	}

	@Override
	public void jugar() {
		boolean acierto = false;
		mostrarLetrasIntroducidas();
		
		if (Objects.isNull(this.palabraClave)) {
			this.muestraNombre();
		}
		
		if (Objects.isNull(this.palabraClave) || this.palabraClave.equals("")) {
			this.palabraClave = this.palabraAdivinar.replaceAll("[a-zA-Z]", "-");
		}
		StringBuilder sbPalabraClave = new StringBuilder(this.palabraClave);
		String letraIntroducida;
		
		do {
			this.muestraInfo();
			letraIntroducida = UtilidadesJuego.leerCadena();
		} while (!this.letraValida(letraIntroducida));
		
		if (this.palabraAdivinar.contains(letraIntroducida)) {
			StringBuilder sbTemporal = new StringBuilder(this.palabraAdivinar);
			do {
				int indiceCoincidencia = sbTemporal.indexOf(letraIntroducida);
				sbTemporal.setCharAt(indiceCoincidencia, '-');
				sbPalabraClave.setCharAt(indiceCoincidencia, letraIntroducida.charAt(0));
			} while (sbTemporal.toString().contains(letraIntroducida));
			
			this.palabraClave = sbPalabraClave.toString();
			System.out.println("Correcto, la letra está en la palabra: " + palabraClave);
			letrasIntroducidas.add(letraIntroducida);
			acierto = true;
		} else {
			System.out.println("La letra introducida no está en la palabra");
			letrasIntroducidas.add(letraIntroducida);
		}
		
		if (this.palabraClave.equalsIgnoreCase(this.palabraAdivinar)) {
			System.out.println("Has ganado!!");
		} else {
			if (acierto) {
				this.pintarAhorcado();
				jugar();
			} else {
				if (this.quitaVida()) {
					this.pintarAhorcado();
					jugar();
				}
			}
			
		}
	}
	
	public boolean letraValida(String cadenaIntroducida) {
		return cadenaIntroducida.trim() != "" && cadenaIntroducida.length() == 1 && !this.letrasIntroducidas.contains(cadenaIntroducida);
	}
	
	@Override
	public void muestraNombre() {
		System.out.println("El ahorcado!");
	}

	@Override
	public void muestraInfo() {
		System.out.println("Adivina la palabra: " + this.palabraClave);
		System.out.println("Introduce una letra");
	}

	public void pintarAhorcado() {
		
		switch (this.getNumeroVidasRestantes()) {
		case 6:
			System.out.println(
					" ___\r\n" + 
					" |   |\r\n" + 
					" |   \r\n" + 
					" |\r\n" + 
					" |");
			break;
		case 5:
			System.out.println(
					" ___\r\n" + 
					" |   |\r\n" + 
					" |   O\r\n" + 
					" |\r\n" + 
					" |");
			break;
		case 4:
			System.out.println(
					" ___\r\n" + 
					" |   |\r\n" + 
					" |  \\O\r\n" + 
					" |\r\n" + 
					" |");
			break;
		case 3:
			System.out.println(
					" ___\r\n" + 
					" |   |\r\n" + 
					" |  \\O/\r\n" + 
					" |\r\n" + 
					" |");
			break;
		case 2:
			System.out.println(
					" ___\r\n" + 
					" |   |\r\n" + 
					" |  \\O/\r\n" + 
					" |   |\r\n" + 
					" |");
			break;
		case 1:
			System.out.println(
					" ___\r\n" + 
					" |   |\r\n" + 
					" |  \\O/\r\n" + 
					" |   |\r\n" + 
					" |  /");
			break;
		case 0:
			System.out.println(
					" ___\r\n" + 
					" |   |\r\n" + 
					" |  \\O/\r\n" + 
					" |   |\r\n" + 
					" |  / \\ ");
			break;

		}
	}
	
	public void mostrarLetrasIntroducidas() {
		if (this.letrasIntroducidas.isEmpty()) {
			return;
		}
		
		IntStream.range(0, this.letrasIntroducidas.size()).forEach(i -> 
			System.out.print(i+1 + "-" + this.letrasIntroducidas.get(i) + ", ")
		);
		
		System.out.println();
	}
}
