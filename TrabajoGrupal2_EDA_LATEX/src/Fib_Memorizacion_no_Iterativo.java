import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fib_Memorizacion_no_Iterativo {
    private static Map<Integer, BigInteger> memo = new HashMap<>();

    public static void main(String[] args) {
        int x = (args.length > 0) ? Integer.parseInt(args[0]) : 0;

        long tmpInicio = System.currentTimeMillis();

        BigInteger result = fibonacci_memorizacion(x);

        long tmpFin = System.currentTimeMillis();
        long tmpTrans = tmpFin - tmpInicio;

        if (args.length > 1 && args[1].equals("true")) {
            System.out.println("\nFibonacci Memorizacion (" + x + ") = " + result);
        }

        System.out.println("\nTiempo de ejecucion: " + tmpTrans + " milisegundos\n\n");
    }

    public static BigInteger fibonacci_memorizacion(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        } else if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            BigInteger result = fibonacci_memorizacion(n - 1).add(fibonacci_memorizacion(n - 2));
            memo.put(n, result);
            return result;
        }
    }
}
