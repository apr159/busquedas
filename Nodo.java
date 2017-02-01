package Vasos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
public class Nodo 
{
	private EstadoVasosAgua estado;
	private String accion;
	private int costoRuta;
	private Nodo padre;
	private int profundidad;
	
	public Nodo(EstadoVasosAgua e)
	{
		estado =e;
		accion = "";
		costoRuta = 0;
		padre =null;
		profundidad= 0;
	}
	public Nodo(EstadoVasosAgua estado, String accion, int costoRuta, Nodo padre, int profundidad)
	{
		this.estado = estado;
		this.accion =accion;
		this.costoRuta = padre.getCostoRuta();
		this.padre =padre;
		this.profundidad=profundidad;
	}
	public List<Nodo> expander(ProblemaVasosAgua p)
	   {  
	      int profundidadHijo = profundidad+1;
	      Iterator<EstadoSucesor> iter = p.funcionSucesor(estado);
	      List<Nodo> hijos = new ArrayList<Nodo>();
	      while (iter.hasNext())
	      {  
	    	 EstadoSucesor succ =  iter.next();
	     
	         hijos.add(new Nodo(succ.getEstado(), succ.getAccion(),
	            succ.getCosto(), this, profundidadHijo));
	      }
	      return hijos;
	   }
	public List<Nodo> getRutaDeRaiz()
	{
		List<Nodo> ruta = new LinkedList<Nodo>();
		Nodo nodo = this;
		do
		{
			ruta.add(0,nodo);
			nodo = nodo.padre;
		} while (nodo!=null);
		return ruta;
	}
	public EstadoVasosAgua getEstado(){  return estado;}
	public String getAccion(){  return accion;}
	public int getCostoRuta(){  return costoRuta;}
	public Nodo getPadre() 	 {  return padre;}
	public int getProfundidad(){return profundidad;}
}
