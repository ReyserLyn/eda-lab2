
import java.math.BigInteger;

public class Fib_Iterativo {
  public static void main(String[] args) {
    int x = (args.length > 0) ? Integer.parseInt(args[0]) : 0;
    
    long tmpInicio = System.currentTimeMillis();

    BigInteger result = fibonacci_iterativo(x);

    long tmpFin = System.currentTimeMillis();
    long tmpTrans = tmpFin - tmpInicio;

    if (args.length > 1 && args[1].equals("true")){
      System.out.println("\nFibonacci Iterativo (" + x + ") = " + result);
    }

    System.out.println("\nTiempo de ejecucion: " + tmpTrans + " milisegundos\n\n");
  }

  public static BigInteger fibonacci_iterativo(int num) {
    if (num <= 1) {
      return BigInteger.valueOf(num);
    }

    BigInteger fibPrevPrev = BigInteger.ZERO;
    BigInteger fibPrev = BigInteger.ONE;
    BigInteger fibCurrent = BigInteger.ZERO;

    for (int i = 2; i <= num; i++) {
      fibCurrent = fibPrev.add(fibPrevPrev);
      fibPrevPrev = fibPrev;
      fibPrev = fibCurrent;
    }

    return fibCurrent;
  }
}

