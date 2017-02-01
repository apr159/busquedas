/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//INTEGRANTES
//Miguel ANgel Delgado Cab
//Victor Jose Ramirez Castanon
//Jose Carlos Lozano Vazquez
package busquedas;

/**
 *
 * @author root
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Busqueda por anchura");
        ProblemaVasosAgua pvs = new ProblemaVasosAgua();
        Busquedas nueva = new Busquedas(pvs);
        nueva.imprimir(nueva.anchura());
       
        
    }
    
}
