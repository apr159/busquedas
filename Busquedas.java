package busquedas;

import java.util.List;
import java.util.Iterator;

public class Busquedas
{
	protected Problema problema;
	protected Cola cola;
	protected long tiempo;
	

   public Busquedas(Problema p)
   { 
	  problema = p;
   	  tiempo=0;

   }
   
   public List<Nodo> anchura(){
	   cola = new ColaLIFO();
	   return buscar();
   }
   
   public List<Nodo> profundidad(){
	   cola = new ColaFIFO();
	   return buscar();
   }
   
   public List<Nodo> profundidadLimitada(int limite){
	   cola = new ColaLimitada(limite);
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
		   System.out.println(n.getEstado());
	   }
   }

   
   public int getTCola()
   {
	   return cola.getTCola();
   }
   
   public long getTiempo()
   {
	   return tiempo;
   }

}
