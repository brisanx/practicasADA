import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author Alba Sánchez Ibáñez
 *
 */

public class MochilaAV extends Mochila {
    
    public SolucionMochila resolver(ProblemaMochila pm){
        int n = pm.size();
        ArrayList<Item> items = pm.getItems(); //array de items de la mochila, ordenar array de items según densidad.
        //Inicializamos solución, su peso y su valor
        int[] solucion = new int[n];
        int pesoTotal = 0;
        int valorTotal = 0;

        int pesoMax = pm.pesoMaximo;

       items.sort(new Comparator<Item>(){
        @Override
        //Nuevo método para realizar la comparación entre items
        public int compare(Item item1, Item item2){
            int compare = 0;
            // Comparamos las densidades de los items
            double densidad1 = (double) item1.valor/item1.peso;
            double densidad2 = (double) item2.valor/item2.peso;

            if (densidad1 > densidad2) {
                compare = -1;
            } else if (densidad1 < densidad2){
                compare = 1;
            } else if (item1.valor >= item2.valor) {
                compare = -1;
            } else if (item1.valor < item2.valor) {
                compare = 1;
            }
            return compare;
        }
       });

         //Iteramos sobre los items
        for (Item item : items){
             //Seleccionamos item según nuestro criterio, si el item no excede el peso, lo añadimos
            while(solucion[item.index] < item.unidades && item.peso <= pesoMax){
                pesoMax = pesoMax - item.peso;
                pesoTotal += item.peso;
                valorTotal += item.valor;
                solucion[item.index]++;
            }
        }
        return new SolucionMochila(solucion, pesoTotal, valorTotal);
    }

}