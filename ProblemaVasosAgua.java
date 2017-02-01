package Vasos;
import java.util.ArrayList;
import java.util.Iterator;

public class ProblemaVasosAgua {
	int vaso1;
	int vaso2;
	
	public boolean funcionObjetivo(EstadoVasosAgua e){
		if(e.vaso1==0 && e.vaso2==2)return true;
		return false;
	}
	public int getH(Estado e){
		return 0;
	}
	public Iterator<EstadoSucesor> funcionSucesor(Estado e){
		ArrayList<EstadoSucesor> sucesores = new ArrayList<EstadoSucesor>();
		EstadoVasosAgua estado = (EstadoVasosAgua)e;
		int pasar = 0;
		// LLenar el vaso 1
		if (estado.vaso1<4){
			sucesores.add(new EstadoSucesor(
					new EstadoVasosAgua(4,estado.vaso2),
					"Llenar vaso 1",
					1));
		}

		if (estado.vaso2<3){
			sucesores.add(new EstadoSucesor(
					new EstadoVasosAgua(estado.vaso1,3),
					"Llenar vaso 2",
					1));
		}
		if (estado.vaso1>0){
			sucesores.add(new EstadoSucesor(
					new EstadoVasosAgua(0,estado.vaso2),
					"Vaciar vaso 1",
					1));
			//pasar del vaso 1 al vaso 2
			if(estado.vaso2<3){
				pasar= PasarVaso1aVaso2(estado);
				sucesores.add(new EstadoSucesor(
					new EstadoVasosAgua(estado.vaso1 - pasar,estado.vaso2+pasar),
					"Pasar de Vaso 1 a Vaso 2",
					1));
			}
		}
		if (estado.vaso2>0){
			sucesores.add(new EstadoSucesor(
					new EstadoVasosAgua(estado.vaso1,0),
					"Vaciar vaso 2",
					1));
			//pasaar vaso 2 al 1
			if(estado.vaso1<4){
				pasar= PasarVaso2aVaso1(estado);
				sucesores.add(new EstadoSucesor(
					new EstadoVasosAgua(estado.vaso1+pasar,estado.vaso2-pasar),
					"Pasar de Vaso 2 al Vaso 1",
					1));
			}
		}

		return sucesores.iterator();

	}
	public int PasarVaso1aVaso2(EstadoVasosAgua estado){
		if(3 - estado.vaso2 >= estado.vaso1){
			return estado.vaso1;
		}
		else { return 3-estado.vaso2;}
	}
	public int PasarVaso2aVaso1(EstadoVasosAgua estado){
		if(4 - estado.vaso1 >= estado.vaso2){
			return estado.vaso2;
		}
		else { return 4-estado.vaso1;}
	}
	
	public EstadoVasosAgua estadoInicial(){
		return new EstadoVasosAgua(vaso1,vaso2);
	}
	
	public void setEstadoInicial(int vaso1, int vaso2){
		this.vaso1 = vaso1;
		this.vaso2 = vaso2;
	}
}
