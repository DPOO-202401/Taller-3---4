package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.Map;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	// Atributos
	private String fecha;
	private static Map<String, Tiquete> tiquetes;
	private static Ruta ruta;
	private static Avion avion;

	public String getFecha() 
	{
		return fecha;
	}
	
	public static Ruta getRuta() {
		return ruta;
	}


	public static Avion getAvion() {
		return avion;
	}

	
	// Metodos
	
	public Vuelo(String fecha, Ruta ruta, Avion avion) 
	{
		super();
		this.fecha = fecha;
		this.ruta = ruta;
		this.avion = avion;
	}

	
	public static Collection<Tiquete> getTiquetes( )
    {
        return tiquetes.values();
    }

	public int venderTiquete(Cliente cliente, CalculadoraTarifas  calculadora, int cantidad)
	{
		return -1;
		
	}
	public boolean equals(Object obj) {
		return (this == obj);
		
	}

}
