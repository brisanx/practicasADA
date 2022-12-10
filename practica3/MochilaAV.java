
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author Alba Sánchez Ibáñez
 *
 */
public class MochilaAV extends Mochila {
	private static class ItemComparator implements Comparator<Item>{
        @Override
        //Nuevo método para realizar la comparación entre items
        public int compare(Item item1, Item2){
            int compare = 0;

            // Comparamos las densidades de los items
            double densidad1 = (double) ...;
            double densidad2 = (double) ...;

            if (...) {
                compare = -1;
            } else if (...){
                compare = +1;
            } else if (...) {
                compare = -1;
            } else if (...) {
                compare = +1;
            }
        }
    }

	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm=null;
		// A resolver por el alumno
		int n = pm.size();

		 //Inicializamos solución, su peso y su valor
		 int[] solucion = new int[n];
		 int pesoTotal = 0;
		 int valorTotal = 0;

		 //Iteramos sobre los items
		 for(...){
            //Seleccionamos item según nuestro criterio, si el item no excede el peso, lo añadimos
            if(...){
                pesoTotal=...;
                valorTotal=...;
                solucion[]=...;
            }
        }
        return new SolucionMochila(solucion, pesoTotal, valorTotal);
    }
		return sm;

	}
}
