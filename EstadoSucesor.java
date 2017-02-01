package Vasos;

public class EstadoSucesor 
{
	private EstadoVasosAgua estado;
	private String accion;
	private int costo;
	
	public EstadoSucesor(EstadoVasosAgua estado, String accion, int costo)
	{
		this.estado = estado;
		this.accion = accion;
		this.costo= costo;
	}
	public EstadoVasosAgua getEstado()
	{
		return estado;
	}
	
	public String getAccion()
	{
		return accion;
	}
	public int getCosto(){
		return costo;
	}
	public String toString(){
		return estado.toString();
	}
}
