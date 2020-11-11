import java.util.Arrays;

public class ColoreadoDeGrafos{
    
    static int matrizAdyacencia[][];
    static int[] colores;
    static int nColores;
    static int nNodos;
    
    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    private static int getColorNodo(int k) {
        do { 
            colores[k]=colores[k]+1; // asigna el siguiente color
            if (colores[k]==nColores+1) return 0; // si todos los colores han sido probados en el nodo, no lo pinta
            for (int j=1; j<=nNodos; ++j){ // comprueba si algún nodo conectado a este ya tiene este color
                if(matrizAdyacencia[k][j] == 1 && colores[k] == colores[j] && k!=j){ 
                    break;
                }
            }  
            if (j==nNodos+1)return colores[k]; // ¿Por qué está fuera del ciclo? //El algoritmo no funciona
        }while(true);
    }
    
    public static void mColorear(int k) {
        do { 
            colores[k]=getColorNodo(k); // dota de un color a este nodo
            if (colores[k]==0) return; // si ya se han repartido todos los colores, acaba
            if (k==nNodos) // si se han coloreado todos los nodos correctamente, imprime la solución. Este algoritmo ofrece todas las soluciones posibles
                System.out.println(Arrays.toString(colores));
            else mColorear(k+1); // si todavía no se ha coloreado todo el grafo, entonces continuamos
        }while(true);
    }
    
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args) throws Exception { 
            nColores=3; // seleccionamos 3 colores, por ejemplo. La matriz de adyacencia indica 1 si los nodos están conectados, y 0 si no
            matrizAdyacencia=new int[][]{{0, 0, 0, 0, 0}, {0, 1, 1, 0, 1}, {0, 1, 1, 1, 1}, {0, 0, 1, 1, 1}, {0, 1, 1, 1, 1}}; 
            nNodos=matrizAdyacencia.length-1; // cantidad de nodos de nuestro grafo
            colores=new int[nNodos+1]; // este es el array que nos dará la solución con los colores de los nodos
            mColorear(1);
    } 
    
}
