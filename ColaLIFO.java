package Vasos;

import java.util.ArrayList;
import java.util.LinkedList;

public class ColaLIFO implements Cola {
	LinkedList<Nodo> cola = new LinkedList<Nodo>();
	ArrayList<EstadoVasosAgua> estadosRepetidos = new ArrayList<EstadoVasosAgua>();
	//@Override
	public boolean estaVacia() {
		// TODO Auto-generated method stub
		if(cola.size()==0) return true;
		
		return false;
	}

	//@Override
	public void addNodo(Nodo nodo) {
		// TODO Auto-generated method stub
		int bandera=0;
		for(int i=0; i<estadosRepetidos.size();i++){
			if(estadosRepetidos.get(i).vaso1 == nodo.getEstado().vaso1 && estadosRepetidos.get(i).vaso2 == nodo.getEstado().vaso2){
				bandera=1;
			}
		}
		if(bandera==0){
			cola.addFirst(nodo);
			estadosRepetidos.add(nodo.getEstado());
		}
		
		/*if(estadosRepetidos.contains(nodo.getEstado()) ){}
		else{
			cola.addFirst(nodo);
			estadosRepetidos.add(nodo.getEstado());
		}*/
	}

	//@Override
	public Nodo removerNodoFrente() {
		// TODO Auto-generated method stub
		return (Nodo)cola.removeFirst();
	}

	//@Override
	public int getTcola(){
		// TODO Auto-generated method stub
		return cola.size();
	}

}
