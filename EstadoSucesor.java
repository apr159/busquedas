package busquedas;


public class EstadoSucesor
{
   private Estado estado;
   private String accion;
   private int costo;

   public EstadoSucesor(Estado estado, String accion,
      int costo)
   {  this.estado = estado;
      this.accion = accion;
      this.costo = costo;
   }

   public Estado getEstado()
   {  return estado;
   } 

   public String getAccion()
   {  return accion;
   }
   public int getCosto()
   {  return costo;
   }
   public String toString(){
	   return estado.toString();
   }
   
}