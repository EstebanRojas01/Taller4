package uniandes.dpoo.aerolinea.modelo.cliente;
import java.util.Iterator;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;


public abstract class Cliente {
	public Cliente() {}

	
	private List<Tiquete> tiquetesSinUsar;
	
	private List<Tiquete> tiquetesUsados;

	
	public abstract String getTipoCliente();
	
	public abstract String getIdentificador();
	
	public void agregarTiquete(Tiquete tiquete){
		tiquetesSinUsar.add(tiquete);
	}

	public int calcularValorTotalTiquetes() {
		int costo = 0;
		for(int i = 0; i<tiquetesSinUsar.size()-1 ;i++) {
			Tiquete tiquete = tiquetesSinUsar.get(i);
			costo += tiquete.getTarifa();
		}
		return costo;
	}

	public void usarTiquetes(Vuelo vuelo) {
		Iterator<Tiquete> tiquetes = vuelo.getTiquetes().iterator();
		
		while(tiquetes.hasNext()) {
			Tiquete tiquete = tiquetes.next();
			if (tiquetesSinUsar.contains(tiquete)) {
				tiquetesSinUsar.remove(tiquete);
			}
			if (!tiquetesUsados.contains(tiquete)) {
				tiquetesUsados.add(tiquete);
			}
		}
	}

}
