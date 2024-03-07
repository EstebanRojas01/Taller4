package uniandes.dpoo.aerolinea.modelo;

public class Avion {
	private int capacidad;
	
	private String nombre;
	
	public Avion(int capacidad, String nombre) {
		super();
		this.capacidad = capacidad;
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;}

	public int getCapacidad() {
		return capacidad;}


}
