package service;

public class MathService {

    public static int isPrime(int number) {
        if (number < 2) {
            return 0;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int calculateMod(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor must not be zero.");
        }
        return a % b;
    }

    public static double calculateSin(double degree) {
        double radians = Math.toRadians(degree);
        return Math.sin(radians);
    }

    public static double calculateCos(double degree) {
        double radians = Math.toRadians(degree);
        return Math.cos(radians);
    }

    public static double calculateTan(double degree) {
        if ((degree - 90) % 180 == 0 || (degree + 90) % 180 == 0) {
            throw new ArithmeticException("Tangent is undefined for this angle.");
        }
        double radians = Math.toRadians(degree);
        return Math.tan(radians);
    }
}
