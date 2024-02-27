package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.LinkedList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;



public abstract class Cliente {

	//Atributos
	private List<Tiquete> tiquete;
	public abstract String getTipoCliente();
	public abstract String getIdentificador();
	
	//Constructor
	public Cliente( ) 
	{
	tiquete = new LinkedList<Tiquete>( );
	}
	
	 public void agregarTiquete( Tiquete tiquete )
	 {
	    this.tiquete.add( tiquete );
	 }
	 
	public int calcularValorTotalTiquetes() {
		int valor=0;
		for (Tiquete tiquete2 : tiquete) {
			valor+= Tiquete.getTarifa();
			
		}
		return valor;
	}
}
