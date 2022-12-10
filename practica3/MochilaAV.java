
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

        ArrayList<Item> items = pm.getItems();
        int pesoMax = pm.pesoMaximo;
        int valorMochila = 0;
        int [] valores = new int[pm.size()];
        items.sort(new Comparator<Item>() {

        @Override
        public int compare(Item o1, Item o2) {
            double ratio1 = (double) o1.valor/o2.peso;
            double ratio2 = (double) o2.valor/o2.peso;

            if(ratio1 > ratio2){
                return -1;
            } else if (ratio1 < ratio2) {
                return 1;
            }
            else 
            {
                if(o1.valor >= o2.valor){
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        });

        for (Item item : items){
            while(valores[item.index] < item.unidades && item.peso <= pesoMax){
                valores[item.index]++;
                pesoMax -= item.peso;
                valorMochila += item.valor;
            }
        }
        return new SolucionMochila(valores, pm.getPesoMaximo() - pesoMax, valorMochila);
    }

}
