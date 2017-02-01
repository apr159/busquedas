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
public class ColaLimitada implements Cola {
    
   public Deque<Nodo> colaLim;
   public int limite;
   //Constructor
   public ColaLimitada(int limite){
        colaLim = new LinkedList<>();
        this.limite = limite;
   }
   
   public boolean estaVacia(){
       if(colaLim.size() == 0){
           return true;
       }
       return false;
   }
   public void addNodo(Nodo nodo){
       if(colaLim.size() == limite){
           //Do nothing
       }else{
            colaLim.addFirst(nodo);
       }
   }
   public Nodo removerNodoFrente(){
       return colaLim.removeFirst();
   }
   
   public int getTCola(){
   	return colaLim.size();
   }
}
