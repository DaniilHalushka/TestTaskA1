import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    private static BigDecimal factorial(int n){
        BigDecimal result = BigDecimal.ONE;
        for (int i = 1; i <= n; i++){
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }

    public static double calculationOfResult(int n) throws IllegalAccessException {
        if (n <= 1) throw new IllegalAccessException("N should be greater then 1, try again.");

        BigDecimal decrementN = factorial(n - 1);

        BigDecimal result = BigDecimal.ONE.divide(decrementN, 6, RoundingMode.HALF_UP);

        return result.doubleValue();
    }

    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double finalResult = calculationOfResult(n);
        System.out.println("Result for n = " + n + " is " + finalResult);

    }
}