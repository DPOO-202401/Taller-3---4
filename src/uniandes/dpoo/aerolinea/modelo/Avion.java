package uniandes.dpoo.aerolinea.modelo;

public class Avion {

	private String nombre;
	private int capacidad;
	
	//constructor
	public Avion( String nombre, int capacidad)
	{
		this.capacidad= capacidad;
		this.nombre= nombre; 
	}
	
	
	// Metodos
	public String getNombre() {
		return nombre;
	}
	public int getCapacidad() {
		return capacidad;
	} 
	
	
	
}
