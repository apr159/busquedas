package busquedas;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class Nodo
{
   private Estado estado;
   private String accion;
   private int costoRuta;
   private Nodo padre;
   private int profundidad;

   public Nodo(Estado e)
   {  estado = e;
      accion = "";
      costoRuta = 0; 
      padre = null;
      profundidad = 0;
   }

   public Nodo(Estado estado, String accion, int costo,
      Nodo padre, int profundidad)
   {  
	  this.estado = estado;
      this.accion = accion;
      this.costoRuta = padre.getCostoRuta() + costo; 
      this.padre = padre;
      this.profundidad = profundidad;
   }

   public List<Nodo> expander(Problema p)
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
   {  List<Nodo> ruta = new LinkedList<Nodo>();
      Nodo nodo = this;
      do
      {  ruta.add(0, nodo);
         nodo = nodo.padre;
      } while (nodo != null);
      return ruta;
   }

   public Estado getEstado(){  return estado;}
   public String getAccion(){  return accion;}
   public int getCostoRuta(){  return costoRuta;}
   public Nodo getPadre() {  return padre;}
   public int getProfundidad(){  return profundidad;}

    @Override
    public String toString() {
        return "Nodo{" + "estado=" + estado + ", accion=" + accion + ", costoRuta=" + costoRuta + ", padre=" + padre + ", profundidad=" + profundidad + '}';
    }
   
   
}
