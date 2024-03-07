package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.cliente.*;
import uniandes.dpoo.aerolinea.modelo.*;


public abstract class CalculadoraTarifas {
	public CalculadoraTarifas() {}

	public static final double IMPUESTO = 0.28;
	
	protected abstract int calcularCostoBase​(Vuelo vuelo,Cliente cliente);
	
	
	protected abstract double calcularPorcentajeDescuento​(Cliente cliente);
	
	public int calcularTarifa​(Vuelo vuelo,Cliente cliente) {
		int costoBase = calcularCostoBase​(vuelo,cliente);
		double descuento = calcularPorcentajeDescuento​(cliente);
		int impuestos = calcularValorImpuestos​(costoBase);
		return (int) ((costoBase+impuestos)*(1-descuento));}
	
	protected int calcularDistanciaVuelo​(Ruta ruta) {
		return Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino());}
	
	protected int calcularValorImpuestos​(int costoBase) {
		int valorMasImpuestos = (int) (costoBase*(IMPUESTO));
		return valorMasImpuestos;}
	
}