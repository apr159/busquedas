package busquedas;

import java.util.Iterator;

public class ProblemaVasosAgua {
	public boolean funcionObjetivo(Estado e){
		...
		return false;
	}
	public int getH(Estado e){
		return 0;
	}
	public Iterator<EstadoSucesor> funcionSucesor(Estado e){
		ArrayList<EstadoSucesor> sucesores = new ArrayList<EstadoSucesor>();
		EstadoVasosAgua estado = (Estado)e;

		// LLenar el vaso 1
		if (estado.vaso1<4){
			sucesores.add(new EstadoSucesor(
					new EstadoVasosAgua(4,estado.vaso2),
					"Llenar vaso 1",
					1));
		}
		...

		return sucesores.iterator();

	}
	public Estado estadoInicial(){
		return new EstadoVasosAgua(4,3);
	}
}
