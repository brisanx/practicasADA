import java.util.Arrays;

/**
 * 
 * @author ***** Alba Sánchez Ibáñez *******
 *
 */
public class MochilaPD extends Mochila {
	int[][] matriz;
    int[] pesos;
    int[] valores;
	int[] repeticiones;
	int items;

	public SolucionMochila resolver(ProblemaMochila pm) {
		items = pm.size();  // n es el numero de items del problema
        pesos = pm.getPesos(); // pesos de solucion parcial
        valores = pm.getValores(); // valores de solucion parcial
		repeticiones = pm.getUnidades();

		int capacidad = pm.getPesoMaximo();
		
		matriz = new int[items+1][capacidad+1]; // matriz de solucion parcial

		// creamos la tabla de subproblemas
		creacion(items, capacidad);

		int[] sol = solucion(pesos, pm.getPesoMaximo());
		return new SolucionMochila(sol, pm.sumaPesos(sol), matriz[items][capacidad]);
	}

	private int creacion(int items, int pesoMaximo){
		for(int i =0; i<=valores.length; i++){
			for (int j=0; j<=pesoMaximo; j++){
				if (i==0 || j==0){
					matriz[i][j]=0;
				} else if(j<pesos[i-1]){
					matriz[i][j] = matriz[i-1][j];
				} else if(j >= pesos[i-1]){
					int objeto = 0;
					int objetoOptimo = 0;
					for(int k = 1; k<= repeticiones[i-1];k++){
						if(j-(k*pesos[i-1])>=0){
							objeto = matriz[i-1][j-(k*pesos[i-1])] + k*valores[i-1];
						}
						if(objeto>objetoOptimo){
							objetoOptimo=objeto;
						}
					}
					matriz[i][j] = Math.max(matriz[i-1][j],objetoOptimo);
				}
			}
		}
		return matriz[items][pesoMaximo];
	}

	private int[] solucion(int[] pesos, int pesoMaximo){
		int i=pesos.length;
		int[] solucion = new int[items];
		Arrays.fill(solucion,0);
		
		int j=pesoMaximo;

		while (i>0 && j>0){
			while(matriz[i-1][j]<matriz[i][j] && solucion[i-1] < repeticiones[i-1]){
				solucion[i-1] += 1;
				j -= pesos[i-1];
			}
			i--;
		}
		return solucion;
	}
}
