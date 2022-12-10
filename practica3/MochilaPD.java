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

	
	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm=null;
		// A resolver por el alumno
		int n = pm.size();  // n es el numero de items del problema
        pesos = pm.getPesos(); // pesos de solucion parcial
        valores = pm.getValores(); // valroes de solucion parcial
		int Objetos = valores.length;

		int capacidad = pm.getPesoMaximo();
		int[] cantidadObjetos = pm.getUnidades();
		
		matriz = new int[n+1][capacidad+1]; // matriz de solucion parcial

		creacion(n,pm.getPesoMaximo(), cantidadObjetos);

		int[] sol = solucion(pesos, pm.getPesoMaximo(), cantidadObjetos, n);
		return new SolucionMochila(sol, pm.sumaPesos(sol), matriz[Objetos][capacidad]);
	}

	private int creacion(int n, int pesoMaximo, int[] cantidadObjetos){
		for(int i =0; i<=valores.length; i++){
			for (int j=0; j<=pesoMaximo; j++){
				if (i==0 || j==0){
					matriz[i][j]=0;
				} else if(j<pesos[i-1]){
					matriz[i][j] = matriz[i-1][j];
				} else if(j >= pesos[i-1]){
					int objeto = 0;
					int objetoOptimo = 0;
					for(int k = 1; k<= cantidadObjetos[i-1];k++){
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
		return matriz[n][pesoMaximo];
	}

	private int[] solucion(int[] pesos, int pesoMaximo, int[] cantidadObjetos, int n){
		int i=pesos.length;
		int[] solucion = new int[n];
		Arrays.fill(solucion,0);
		
		int j=pesoMaximo;

		while (i>0 && j>0){
			while(matriz[i-1][j]<matriz[i][j] && solucion[i-1] < cantidadObjetos[i-1]){
				solucion[i-1] += 1;
				j -= pesos[i-1];
			}
			i--;
		}
		return solucion;
	}
}
