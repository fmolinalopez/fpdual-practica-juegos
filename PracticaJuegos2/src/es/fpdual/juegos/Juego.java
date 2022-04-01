package es.fpdual.juegos;

import es.fpdual.interfaces.Jugable;

public abstract class Juego implements Jugable {

	private final Integer numeroVidasIniciales;
	
	private Integer numeroVidasRestantes;
	
	private Integer record;

	public Juego(Integer numeroVidasIniciales) {
		super();
		this.numeroVidasIniciales = numeroVidasIniciales;
		this.numeroVidasRestantes = numeroVidasIniciales;
		this.record = 0;
	}
	
	public void actualizaRecord() {
		
		if (this.numeroVidasRestantes.equals(this.record)) {
			System.out.println("Has alcanzado el record");
		}
		
		if (this.numeroVidasRestantes > this.record) {
			this.record = this.numeroVidasRestantes;
			System.out.println("Has superado el record!!! Nuevo record: " + this.record);
		}
	}
	
	public void reiniciaPartida() {
		System.out.println("Reiniciando partida");
		this.numeroVidasRestantes = this.numeroVidasIniciales;
		this.record = 0;
	}
	
	public boolean quitaVida() {
		System.out.println("Restando una vida");
		this.numeroVidasRestantes -= 1;
		
		System.out.println("Vidas restantes: " + this.numeroVidasRestantes);
		
		if (this.numeroVidasRestantes <= 0) {
			System.out.println("Has perdido!");
			return false;
		}
		
		return true;
	}

	public Integer getNumeroVidasRestantes() {
		return numeroVidasRestantes;
	}

	public void setNumeroVidasRestantes(Integer numeroVidasRestantes) {
		this.numeroVidasRestantes = numeroVidasRestantes;
	}

	public Integer getRecord() {
		return record;
	}

	public void setRecord(Integer record) {
		this.record = record;
	}

	public Integer getNumeroVidasIniciales() {
		return numeroVidasIniciales;
	}
}
