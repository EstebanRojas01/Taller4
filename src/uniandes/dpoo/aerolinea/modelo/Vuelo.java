package uniandes.dpoo.aerolinea.modelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import java.util.Collection;
import java.util.Map;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;



public class Vuelo {
	private String fecha;
	
	private Ruta ruta;

	private Avion avion;

	private Map<String,Tiquete> tiquetes;


	public Vuelo(String fecha, Ruta ruta, Avion avion) {
		super();
		this.fecha = fecha;
		this.ruta = ruta;
		this.avion = avion;
	}
	
	public Ruta getRuta() {
		return ruta;
	}
	public String getFecha() {
		return fecha;
	}
	
	public Avion getAvion() {
		return avion;
	}
	public Collection<Tiquete> getTiquetes(){
		return tiquetes.values();
	}
	int venderTiquetes​(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException {
		
		int tarifas = 0;
		Vuelo vuelo = new Vuelo(fecha, ruta, avion);
		if (cantidad>avion.getCapacidad()) {throw new VueloSobrevendidoException(vuelo);}
		
		for(int i=0;i<=cantidad;i++) {
		
		int tarifa = calculadora.calcularTarifa​(vuelo, cliente);
		tarifas+=tarifa;

		Tiquete tiquete = GeneradorTiquetes.generarTiquete(vuelo, cliente, tarifa);
		tiquetes.put(tiquete.getCodigo(), tiquete);}
		return tarifas;}
	
	public boolean equals​(Object obj) {
		return false;
		
	}



}
