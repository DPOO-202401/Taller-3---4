package uniandes.dpoo.aerolinea.tiquetes;

import java.util.Collection;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	
	
	private static int	tarifa;
	private boolean	usado;
	private String codigo;
	private Cliente	cliente;
	private Vuelo vuelo;
	
	


	public Tiquete(String codigo, Vuelo vuelo, Cliente cliente, int tarifa, boolean usado) {
		super();
		Tiquete.tarifa = tarifa;
		this.usado = usado;
		this.codigo = codigo;
		this.cliente = cliente;
		this.vuelo = vuelo;
	}

	

	public static int getTarifa() {
		return tarifa;
	}


	public String getCodigo() {
		return codigo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public Vuelo getVuelo() {
		return vuelo;
	}



	public void marcarComoUsado() {
		usado = true;
		
	}






	
}
