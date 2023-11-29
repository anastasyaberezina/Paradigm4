import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        double[] array1 = new double[] { 1, 2, 3, 4, 5 };
        double[] array2 = new double[] { 1, 2, 3, 4, 5 };
        System.out.printf("Correlation = %.3f\n", correlation(array1, array2));
    }

    private static Double correlation(double[] array1, double[] array2) {
        return getNumerator(array1, array2) / getDenominator(array1, array2);
    }

    private static Double getNumerator(double[] array1, double[] array2) {
        double average1 = Arrays.stream(array1).average().stream().sum();
        double average2 = Arrays.stream(array2).average().stream().sum();
        double result = 0;
        for (int i = 0; i < array1.length; i++) {
            result += (array1[i] - average1) * (array2[i] - average2);
        }
        return result;
    }

    private static Double getDenominator(double[] array1, double[] array2) {
        double average1 = Arrays.stream(array1).average().stream().sum();
        double average2 = Arrays.stream(array2).average().stream().sum();
        double result = 0;
        for (int i = 0; i < array1.length; i++) {
            result += Math.pow(array1[i] - average1, 2) * Math.pow(array2[i] - average2, 2);
        }
        return Math.sqrt(result);
    }

}