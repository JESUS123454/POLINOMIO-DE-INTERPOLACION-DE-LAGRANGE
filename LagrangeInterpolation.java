import java.util.Scanner;

public class LagrangeInterpolation {
    public static double lagrangeInterpolate(double[] x, double[] y, double xValue) {
        double result = 0;

        for (int i = 0; i < x.length; i++) {
            double term = y[i];
            StringBuilder expression = new StringBuilder("L" + i + "(x) = ");
            for (int j = 0; j < x.length; j++) {
                if (j != i) {
                    term *= (xValue - x[j]) / (x[i] - x[j]);
                    expression.append("(x - ").append(x[j]).append(") / (").append(x[i]).append(" - ").append(x[j]).append(")");
                    if (j < x.length - 1) {
                        expression.append(" * ");
                    }
                }
            }
            System.out.println(expression.toString());
            result += term;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de puntos de datos:");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        System.out.println("Ingrese los valores de x:");
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextDouble();
        }

        System.out.println("Ingrese los valores de y:");
        for (int i = 0; i < n; i++) {
            y[i] = scanner.nextDouble();
        }

        System.out.println("Ingrese el valor de x para interpolar:");
        double xValue = scanner.nextDouble();

        double interpolatedValue = lagrangeInterpolate(x, y, xValue);
        System.out.println("\nEl valor interpolado en x = " + xValue + " es: " + interpolatedValue);

        scanner.close();
    }
}