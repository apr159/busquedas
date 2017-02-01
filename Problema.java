package Vasos;
import java.util.Iterator;
public interface Problema {
	public boolean funcionObjetivo(Estado e);
	public int getH(Estado e);
	public Iterator<EstadoSucesor> funcionSucesor(Estado e);
	public Estado estadoInicial();
}
