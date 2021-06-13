import java.util.Arrays; 
/**
 * Write a description of class Matriz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Matriz{
    private int m, n;
    private int [][] matriz;
    public Matriz(int tamMatriz){
        n = tamMatriz;
        matriz = new int[n][n];
        llenar();
     }
    
    public void llenar(){
        int dato = 1;
        for(m = 0; m < matriz.length; m++){
            for(n = 0; n < matriz[0].length; n++){
                matriz[m][n] = dato;
                dato++;
            }
        }
     } 
    
    public int[][] recorridoCaracol(){
        int num, mInicio,mFinal, nInicio, nFinal;
        num = 1;
        mInicio = 0;
        mFinal = matriz.length - 1;
        nInicio = 0;
        nFinal = matriz.length - 1;
        
        while(mInicio <= mFinal){ 
            while(nInicio <= nFinal){
                //recorrido izq a der
                for(int j = nInicio; j<=nFinal; j++){
                    matriz[mInicio][j] = num;
                    num++;
                }
                //recorrido arriba a abajo
                for(int i = mInicio+1; i <= mFinal; i++){
                    matriz[i][nFinal] = num++;
                }
                //recorrido derecha a izq
                for(int j = nFinal-1; j >= nInicio; j--){
                    matriz[mFinal][j] = num++;
                }
                //recorrido abajo hacia arriba
                for(int i = mFinal-1; i >= mInicio+1; i--){
                    matriz[i][nInicio] = num++;
                }
                mInicio++;
                nInicio++;
                mFinal--;
                nFinal--;
            }
        }
        imprimirMatriz();
        return matriz;
     }
    
    public String matrizDiagonal(){
        String reporte;
        reporte = "";
        int dSec = matriz.length - 1;
        if(n%2 != 0){
            for(int i = 0; i<matriz.length; i++){
                for(int j = 0; j<matriz[0].length; j++){
                    if(i == j){
                        matriz[i][j] = 1;
                        reporte = reporte + matriz[i][j] + "\t";
                    }else{
                        if(j != dSec){
                            matriz[i][j] = 0;
                            reporte = reporte + matriz[i][j] + "\t";
                        }   
                    }
                    if(j == dSec){
                        //if(i != dSec){
                            if(i != (n%2 +1)){
                                matriz[i][j] = 1;
                                reporte = reporte + matriz[i][j] + "\t";
                                dSec--;
                            }else{
                                dSec--;
                            }
                        //}
                    }
                    
                }
                reporte = reporte + "\n";
            }
        }else{
            for(int i = 0; i<matriz.length; i++){
                for(int j = 0; j<matriz[0].length; j++){
                    if(i == j){
                        matriz[i][j] = 1;
                        reporte = reporte + matriz[i][j] + "\t";
                    }
                    if(i != j){
                        if(j != dSec){
                            matriz[i][j] = 0;
                            reporte = reporte + matriz[i][j] + "\t";
                        }   
                    }
                    if(j == dSec){
                        matriz[i][j] = 1;
                        reporte = reporte + matriz[i][j] + "\t";
                        dSec--;
                    }
                }
                reporte = reporte + "\n";
            }
        }
        return reporte;
    }
    
    private void imprimirMatriz(){
       String reporte;
       reporte = "";
       for(int i = 0; i < matriz.length; i++){
           for(int j = 0; j < matriz[0].length; j++){
               reporte = reporte + matriz[i][j] + "\t"; 
           }
           reporte = reporte + "\n";
       }
       System.out.println(reporte);
    }
}