import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author ***** Alba Sánchez Ibáñez ******* Asumimos que: a) Todos los items
 *         tienen
 *         un valor >=1 b) W>0
 */

public class MochilaFB extends Mochila {

    public SolucionMochila resolver(ProblemaMochila pm) {
        int[] temporal = new int[pm.size()];
        int[] Solucion = new int[pm.size()];
        int tamano = pm.size();
        int valorOptimo = 0;

        boolean quedanCombinaciones = true;
        ArrayList<Item> unidadesMax = pm.getItems();
        while (quedanCombinaciones) {
            boolean seguir = true;
            for (int i = 0; i < tamano && seguir; i++) {
                int cantidad = temporal[i] + 1;
                if (cantidad > unidadesMax.get(i).unidades) {
                    cantidad = 0;
                    if (i == tamano - 1) {
                        quedanCombinaciones = false;
                    }
                } else {
                    seguir = false;
                }
                temporal[i] = cantidad;
            }

            int valorTotal = valorTotal(temporal, pm);
            int pesoTotal = pesoTotal(temporal, pm);

            if (valorTotal > valorOptimo && pesoTotal <= pm.pesoMaximo) {
                Solucion = Arrays.copyOf(temporal, temporal.length);
                valorOptimo = valorTotal;
            }
        }
        return new SolucionMochila(Solucion, pm.sumaPesos(Solucion),pm.sumaValores(Solucion));
    }

    public int valorTotal(int[] array, ProblemaMochila pm) {
        return pm
                .sumaValores(array);

    }

    public int pesoTotal (int[] array, ProblemaMochila pm) {
        return pm.sumaPesos(array);
    }
}
