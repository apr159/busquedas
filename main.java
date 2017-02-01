package Vasos;
import java.util.Scanner;

//import java.util.ArrayList;
//import java.util.Iterator;
import Vasos.ProblemaVasosAgua;
public class main {
	
	public static void main(String[] args) {
		System.out.println("Integrantes\n");
		System.out.println("\tVictoria Chang");
		System.out.println("\tRoberto Cervera");
		System.out.println("\tVictor Burgos");

		Scanner vasos = new Scanner(System.in);
		Scanner resp = new Scanner(System.in);
		
		int vaso1 = 4;
		int vaso2 = 3;
		String r;
	
			System.out.println("Deesea ingresar un estado inicial? [s/n]");
			r = resp.nextLine();
			
			if ( r.equals("s") || r.equals("S")){
				System.out.println("Vaso1: "); vaso1 = vasos.nextInt();
				System.out.println("Vaso2: "); vaso2 = vasos.nextInt();
			} else{
				System.out.println("El estado inicial es <4, 3>\n\n");
			}
			
			ProblemaVasosAgua problema= new ProblemaVasosAgua();
			problema.setEstadoInicial(vaso1, vaso2);
			
			// Busqueda de solución por anchura
			System.out.println("Busqueda por anchura");
			Busquedas buscarAnchura = new Busquedas(problema);
			buscarAnchura.imprimir(buscarAnchura.anchura());
			
			System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			// Busqueda de solución por profundidad	
			
			System.out.println("Busqueda por profundidad");
			Busquedas buscarProfundidad = new Busquedas(problema);
			buscarProfundidad.imprimir(buscarProfundidad.profundidad());
					
	}
	
}
