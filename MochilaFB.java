
/**
 * 
 * @author ***** Alba Sánchez Ibáñez ******* Asumimos que: a) Todos los items tienen
 *         un valor >=1 b) W>0
 */

public class MochilaFB extends Mochila {

	
	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm=null;
		// A resolver por el alumno
        
        int n= pm.size();  //n es el # items del problema
        long dosN = 2^n;  //# posibles soluciones, 2^n

        //Iteramos sobre las posibles soluciones
        for(...){ 
            int k=1;
            // Inicializar combinación actual, su peso y su valor
            int[] combinacion = new int[n];
            int pesoTotal = 0;
            int valorTotal = 0;

            //Iteramos sobre los objetos creando una nueva combinación.
            while(dosN!=0){
                
                dosN--;
            }

            if(...){
                if(sm==null){
                    //Primera solución buena, se selecciona, es la primera vez
                    sm = new SolucionMochila(combinacion, pesoTotal, valorTotal);
                } else if (...){
                    //Otra condición para su solución, hay que comparar con la solución (mejor). Maximizar el valor
                    sm = new SolucionMochila(combinacion, pesoTotal, valorTotal);
                } else if (...){
                    //Otra condición para su solución, hay que comparar con la solución (peor). Minimizar el peso
                    sm = new SolucionMochila(combinacion, pesoTotal, valorTotal);
                }
            }
		return sm;	}

}
