
import java.math.BigInteger;

public class Fib_logaritmico {

    public static void main(String[] args) {
      int x = (args.length > 0) ? Integer.parseInt(args[0]) : 0;
    
      long tmpInicio = System.currentTimeMillis();

      BigInteger result = fibonacci_logaritmico(x);

      long tmpFin = System.currentTimeMillis();
      long tmpTrans = tmpFin - tmpInicio;

      if (args.length > 1 && args[1].equals("true")){
        System.out.println("\nFibonacci Logaritmico (" + x + ") = " + result);
      }

      System.out.println("\nTiempo de ejecucion: " + tmpTrans + " milisegundos\n\n");
    }

    public static BigInteger fibonacci_logaritmico(int n) {
        if (n <= 0) {
            return BigInteger.ZERO;
        }
        
        BigInteger[][] matriz = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}}; //{0, 0} {1, 1}
        elevarMatriz(matriz, n - 1);
        
        return matriz[0][0];
    }

    public static void multiplicarMatriz(BigInteger[][] A, BigInteger[][] B) {
        BigInteger a = A[0][0].multiply(B[0][0]).add(A[0][1].multiply(B[1][0]));
        BigInteger b = A[0][0].multiply(B[0][1]).add(A[0][1].multiply(B[1][1]));
        BigInteger c = A[1][0].multiply(B[0][0]).add(A[1][1].multiply(B[1][0]));
        BigInteger d = A[1][0].multiply(B[0][1]).add(A[1][1].multiply(B[1][1]));

        A[0][0] = a;  // a b
        A[0][1] = b;  // c d
        A[1][0] = c;
        A[1][1] = d;
    }

    public static void elevarMatriz(BigInteger[][] matriz, int n) {
        if (n <= 1) {
            return;
        }

        elevarMatriz(matriz, n / 2);
        multiplicarMatriz(matriz, matriz);

        BigInteger[][] base = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        if (n % 2 != 0) {
            multiplicarMatriz(matriz, base);
        }
    }
}
