package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{

	protected final int COSTO_POR_KM_NATURAL = 600;
	protected final int COSTO_POR_KM_CORPORATIVO = 900;
	protected final double DESCUENTO_PEQ = 0.02;
	protected final double DESCUENTO_MEDIANAS = 0.1;
	protected final double DESCUENTO_GRANDES = 0.2;
	
	public CalculadoraTarifasTemporadaBaja() {}
	
	@Override
	public int calcularCostoBase​(Vuelo vuelo,Cliente cliente) {
		Aeropuerto origen = vuelo.getRuta().getOrigen();
		Aeropuerto destino = vuelo.getRuta().getDestino();
		int distancia = Aeropuerto.calcularDistancia(origen, destino);
		if (cliente.getTipoCliente()=="Natural") {
			return distancia*COSTO_POR_KM_NATURAL;
		}
		else {
			return distancia*COSTO_POR_KM_CORPORATIVO;
		}
	}
	@Override
	public double calcularPorcentajeDescuento​(Cliente cliente) {
		if (cliente.getTipoCliente()=="Corporativo") {
			int tamañoEmpresa = ((ClienteCorporativo) cliente).getTamanoEmpresa();
			if (tamañoEmpresa == 1) {return DESCUENTO_PEQ;}
			else if(tamañoEmpresa == 2) {return DESCUENTO_MEDIANAS;}
			else {return DESCUENTO_GRANDES;}
		
		}		
		return 0;}
}
