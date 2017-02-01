package busquedas;
import java.util.Deque;
import java.util.LinkedList;




public class ColaFIFO implements Cola{
    public Deque<Nodo> colaF;
        
    //Constructor
    public ColaFIFO (){
        colaF = new LinkedList<>();
    }

   public boolean estaVacia(){
        if(colaF.size() == 0){return true;}
        return false;

   }

   public void addNodo(Nodo nodo){
   	colaF.addFirst(nodo);

   }

   public Nodo removerNodoFrente(){
   	return colaF.removeLast();
   }

   public int getTCola(){
   	return colaF.size();
   }

}
