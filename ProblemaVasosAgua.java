package busquedas;

import java.util.ArrayList;
import java.util.Iterator;

public class ProblemaVasosAgua implements Problema {

	public boolean funcionObjetivo(Estado e){
            
            EstadoVasosAgua estado = (EstadoVasosAgua) e;
		if(estado.vaso1 == 2 && estado.vaso2==0)
 			return true;
 		else {
 			return false;
 		}
	}


	public int getH(Estado e){
		return 0;
	}


	public Iterator<EstadoSucesor> funcionSucesor(Estado e){
		ArrayList<EstadoSucesor> sucesores = new ArrayList<EstadoSucesor>();
		
                EstadoVasosAgua estado = (EstadoVasosAgua)e;

		// LLenar el vaso 1
		if (estado.vaso1<4){						//estado 						Accion		Costo
			EstadoSucesor porAhora = new EstadoSucesor( new EstadoVasosAgua(4,estado.vaso2), "Llenar vaso 1", 1);
			if(!sucesores.contains(porAhora))
				sucesores.add( porAhora);
			
		}
		//llenar vaso 2
		if (estado.vaso2<3){						//estado 						Accion		Costo
			EstadoSucesor porAhora = new EstadoSucesor( new EstadoVasosAgua(estado.vaso1, 3), "Llenar vaso 2", 1);
			if(!sucesores.contains(porAhora))
				sucesores.add( porAhora);
		}
		//If las dos anteriores ya estan contempladas, vamo a alokarno
		
		//Vaciar vaso 1 
		if (estado.vaso1>0){						//estado 						Accion		Costo
			sucesores.add(new EstadoSucesor( new EstadoVasosAgua(0, estado.vaso2), "Vaciar vaso 1", 1));
		}


		//Vaciar vaso 2
		if (estado.vaso2>0){						//estado 						Accion		Costo
			sucesores.add(new EstadoSucesor( new EstadoVasosAgua(estado.vaso1, 0), "Vaciar vaso 2", 1));
		}

			//Pasamos vaso 1 a vaso 2
		if(estado.vaso1>0 && estado.vaso2<3){
			int aux = estado.vaso2 + estado.vaso1; //Aux es el contenido del vaso 
                        int vres;
                        
			if(aux >3){
				vres = aux - 3;
				aux= 3;
			}else{
				vres = 0;
			}
			sucesores.add(new EstadoSucesor( new EstadoVasosAgua(vres, aux), "Pasamos contenido de vaso 1 a vaso 2", 1));

			//Hace calor en la disco subiendo el vapor
		}


			//Pasamos vaso 2 a vaso 1 
		if(estado.vaso1<4 && estado.vaso2 >0){
			//Siente el boom de este pe-perreo intenso
			int aux = estado.vaso2 + estado.vaso1; //Aux es el contenido del vaso 
                        int vres;
                        
			if(aux >4){
				vres = aux - 4;
				aux= 4;
			}else{
				vres = 0;
			}
			sucesores.add(new EstadoSucesor( new EstadoVasosAgua(aux, vres), "Pasamos contenido de vaso 2 a vaso 1s", 1));

		}

		return sucesores.iterator();

	}


	public Estado estadoInicial(){
		return new EstadoVasosAgua(4,3);
	}
}

