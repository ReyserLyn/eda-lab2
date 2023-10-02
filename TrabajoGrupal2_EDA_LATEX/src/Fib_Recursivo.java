import java.math.BigInteger;

public class Fib_Recursivo {
    public static void main(String[] args) {
        int x = (args.length > 0) ? Integer.parseInt(args[0]) : 0;

        long tmpInicio = System.currentTimeMillis();

        BigInteger result = fibonacci_recursivo(x);

        long tmpFin = System.currentTimeMillis();
        long tmpTrans = tmpFin - tmpInicio;

        if (args.length > 1 && args[1].equals("true")) {
            System.out.println("\nFibonacci Recursivo (" + x + ") = " + result);
        }

        System.out.println("\nTiempo de ejecucion: " + tmpTrans + " milisegundos\n\n");
    }

    public static BigInteger fibonacci_recursivo(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        } else {
            return fibonacci_recursivo(n - 1).add(fibonacci_recursivo(n - 2));
        }
    }
}

