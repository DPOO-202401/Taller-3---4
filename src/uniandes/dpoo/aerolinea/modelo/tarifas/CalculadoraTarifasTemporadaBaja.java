package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	
	protected static int COSTO_POR_KM_NATURAL=600;
	protected static int COSTO_POR_KM_CORPORATIVO=900; 	
	protected static double DESCUENTO_GRANDES=0.2;
	protected static double DESCUENTO_MEDIANAS=0.1;
	protected static double DESCUENTO_PEQ=0.02;
	
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	protected int calcularPorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
