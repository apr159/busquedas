/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedas;
import java.util.Deque;
import java.util.LinkedList;
/**
 *
 * @author root
 */
public class ColaLIFO implements Cola {
   
   public Deque<Nodo> colaL;
   
   //Constructor
   public ColaLIFO(){
        colaL = new LinkedList<>();
   }
   
   public boolean estaVacia(){
       if(colaL.size() == 0){
           return true;
       }
       return false;
   }
   public void addNodo(Nodo nodo){
       colaL.addFirst(nodo);
   }
   public Nodo removerNodoFrente(){
       return colaL.removeFirst();
   }
   
   public int getTCola(){
   	return colaL.size();
   }
}
