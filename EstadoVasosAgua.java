package Vasos;

public class EstadoVasosAgua implements Estado{
	int vaso1;
	int vaso2;

	public EstadoVasosAgua(int vaso1, int vaso2){
		this.vaso1 = vaso1;
		this.vaso2 = vaso2;
	}
	public String EstadosString(){
		
		return ("El estado <"+vaso1+","+vaso2+">");
	}
}