package Vasos;

import java.util.Iterator;
import java.util.List;

public class Busquedas 
{	protected ProblemaVasosAgua problema;
	protected Cola cola;
	protected long tiempo;
	
	public Busquedas(ProblemaVasosAgua p)
	   { 
		  problema = p;
	   	  tiempo=0;

	   }
	public List<Nodo> anchura(){
		   cola = new ColaFIFO();
		   return buscar();
	   }
	public List<Nodo> profundidad(){
 		   cola = new ColaLIFO();
		   return buscar();
	   }
	 protected List<Nodo> buscar()
	   {  
		  tiempo++;
		  addNodo(cola, new Nodo(problema.estadoInicial()));
	      while (! cola.estaVacia())
	      {  
	    	 tiempo++;
	    	 Nodo actual = cola.removerNodoFrente();
	    	 //System.out.println(actual.getEstado());
	         if (problema.funcionObjetivo(actual.getEstado()))
	         {  return actual.getRutaDeRaiz();
	         }
	         
	         addNodos(cola, actual.expander(problema));
	      }
	      return null;
	   }
	 protected void addNodos(Cola laCola, List<Nodo> losNodos)
	   {  
		  Iterator<Nodo> iter = losNodos.iterator();
	      while (iter.hasNext())
	      {  
	    	  addNodo(laCola, iter.next());
	      }
	   }
	   
	   protected void addNodo(Cola laCola, Nodo elNodo)
	   {  
		   
		   laCola.addNodo(elNodo);
	   }
	   public void imprimir(List<Nodo> nodos){
		   if (nodos==null){
			   System.out.println("No se encontro solución");
			   return;
		   }
		   Iterator<Nodo> it = nodos.iterator();
		   while (it.hasNext()){
			   Nodo n = it.next();
			   System.out.println(n.getAccion());
			   System.out.println("<"+n.getEstado().vaso1 +","+ n.getEstado().vaso2+">");
		   }
	   }
	   public int getTCola()
	   {
		   return cola.getTcola();
	   }
	   
	   public long getTiempo()
	   {
		   return tiempo;
	   }

	

}
