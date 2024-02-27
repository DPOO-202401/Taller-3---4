package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class  CalculadoraTarifas  {

	//Atributos
	public static final double IMPUESTO= 0.28;
	//Metodos
	public int calcularTarifa(Vuelo vuelo, Cliente cliente)
	{
		return -1;
	}
	protected abstract int  calcularCostoBase(Vuelo vuelo, Cliente cliente);
	protected abstract int  calcularPorcentajeDescuento(Cliente cliente);
	protected abstract int  calcularDistanciaVuelos(Ruta ruta);
	protected abstract int  calcularValorImpuestos(int costoBase);
	
}
